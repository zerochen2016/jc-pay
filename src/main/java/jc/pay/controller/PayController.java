package jc.pay.controller;



import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbmysql.entity.PayAccountNotify;
import com.dbmysql.entity.PayOrderInfo;
import com.dbmysql.entity.PayQrcode;

import jc.base.service.PayAccountNotifyService;
import jc.base.service.PayOrderInfoService;
import jc.base.service.PayQrcodeService;
import jc.common.util.DateUtil;
import jc.common.util.DomainUtil;
import jc.common.util.HttpClientUtil;
import jc.common.util.RandomUtil;
import jc.common.util.SignatureUtil;
import jc.common.util.StringUtil;
import jc.pay.cache.CacheInternal;
import jc.pay.common.result.JsonResult;
import jc.pay.common.result.SystemReturn;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	private static final Logger log = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	PayQrcodeService payQrcodeServiceImpl;
	@Autowired
	PayOrderInfoService payOrderInfoServiceImpl;
	@Autowired
	PayAccountNotifyService payAccountNotifyServiceImpl;

	@RequestMapping("/transfer")
	public String transfer(HttpServletRequest request, Model model) {
		model.addAttribute("cardNo", "");//银行账号
		model.addAttribute("bankName", "");
		model.addAttribute("bankAccount", "");
		model.addAttribute("money", "0.01");
		model.addAttribute("amount", "0.01");
		model.addAttribute("bankMark", "CMB");
		model.addAttribute("jumpUrl", new StringBuffer(DomainUtil.getHost(request)).append("pay/transfer"));
		return "pay/transfer";
	}
	
	@RequestMapping("/page/{account}/{userId}/{mobile}/{tradeNo}/{moneyKey}")
	public String page(@PathVariable String account, @PathVariable String moneyKey,@PathVariable String mobile,
			@PathVariable String tradeNo, @PathVariable String userId, Model model) {
		PayOrderInfo exist = this.payOrderInfoServiceImpl.getPayOrderInfoByTradeNo(tradeNo);
		if(exist != null) {
			return "pay/pay_get_new";
		}
		PayQrcode qrcode = this.payQrcodeServiceImpl.getQRCode(moneyKey,userId,account);
		if(qrcode == null) {
			return "pay/pay_no";
		}
		PayOrderInfo order = this.payOrderInfoServiceImpl.create(qrcode.getId(), qrcode.getMoney(), tradeNo, userId, qrcode.getAccount(),mobile);
		if(order == null) {
			return null;
		}
		PayAccountNotify pn = this.payAccountNotifyServiceImpl.getPayAccountNotifyByAccount(account);
		model.addAttribute("qrCode", qrcode.getQrcodeUrl());
		model.addAttribute("time",CacheInternal.orderExpireTimeMinutes());
		model.addAttribute("expireTime", DateUtil.getDateString(qrcode.getOktime(), DateUtil.TIMEFORMAT.YYYY_MM_DD_HH_MM_SS));
		model.addAttribute("jumpUrlAlipay", CacheInternal.jumpUrlAlipay());
		model.addAttribute("jumpUrlWechat", CacheInternal.jumpUrlWechat());
		model.addAttribute("orderNo", order.getOrderNo());
		model.addAttribute("tradeNo", order.getTradeNo());
		model.addAttribute("money", qrcode.getMoney());
		int payType = pn.getShowType();
		if(payType == 1) {
			model.addAttribute("payTypeString", "支付宝");
		}else if(payType == 2) {
			model.addAttribute("payTypeString", "微信");
		}else if(payType == 3) {
			model.addAttribute("payTypeString", "支付宝或微信");
		}
		model.addAttribute("payButtonType", payType);
		String nonceString = RandomUtil.getRandomChar(16);
		String timestamp = DateUtil.getSystemTimeInt()+"";
		Map<String,String> signParams = new HashMap<>();
		signParams.put("nonceString", nonceString);
		signParams.put("timestamp", timestamp);
		signParams.put("publicKey", CacheInternal.payPublicKey());
		String signpre = SignatureUtil.sortParams(signParams);
		String sign = SignatureUtil.encodeMD5(signpre);	
		model.addAttribute("sign", sign);
		model.addAttribute("nonceString", nonceString);
		model.addAttribute("timestamp", timestamp);
		return "pay/zbpay";
	}
	
	@ResponseBody
	@RequestMapping("/notifyali/{account}/{money}")
	public String notify(@PathVariable String account, @PathVariable String money) {
		log.info("-------------------------------------------notifylog start,account={},money={}",account,money);
		PayOrderInfo order = this.payOrderInfoServiceImpl.successCallback(account, money);
		if(order == null) {
			log.info("-------------------------------------------notifylog order null,account={},money={},orderMo={}",account,money,order.getOrderNo());
			return JsonResult.setReturnStr(SystemReturn.FAIL);
		}
		log.info("-------------------------------------------notifylog order notNull,account={},money={},orderMo={}",account,money,order.getOrderNo());
		PayAccountNotify pa = this.payAccountNotifyServiceImpl.getPayAccountNotifyByAccount(account);
		if(pa == null || StringUtil.isEmpty(pa.getNotify())) {
			log.info("-------------------------------------------notifylog notifyNull,account={},money={},notifyUrl={}",account,money,pa.getNotify());
			return JsonResult.setReturnStr(SystemReturn.FAIL);
		}
		log.info("-------------------------------------------notifylog notifyNotNull,account={},money={},notifyUrl={}",account,money,pa.getNotify());
		String url = pa.getNotify();
		String nonceString = RandomUtil.getRandomChar(16);
		String timestamp = DateUtil.getSystemTimeInt()+"";
		Map<String,String> signParams = new HashMap<>();
		signParams.put("nonceString", nonceString);
		signParams.put("timestamp", timestamp);
		signParams.put("publicKey", CacheInternal.payPublicKey());
		String signpre = SignatureUtil.sortParams(signParams);
		String sign = SignatureUtil.encodeMD5(signpre);		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("tradeNo", order.getTradeNo());
		params.put("sign", sign);
		params.put("nonceString", nonceString);
		params.put("timestamp", timestamp);
		String result = HttpClientUtil.doPost(url, params, "utf-8");
		log.info("-------------------------------------------notifylog notifyResult,result={}",result);
		this.doStatisticReport(order.getUserId(),order.getMoney(),pa.getStatisticNotify());
		return JsonResult.setReturnStr(SystemReturn.OK);
	}
	
	private void doStatisticReport(String userId, BigDecimal money,String staticNotify) {
		String nonceString = RandomUtil.getRandomChar(16);
		String timestamp = DateUtil.getSystemTimeInt()+"";
		Map<String,String> signParams = new HashMap<>();
		signParams.put("nonceString", nonceString);
		signParams.put("timestamp", timestamp);
		signParams.put("publicKey", CacheInternal.extPublicKey());
		String signpre = SignatureUtil.sortParams(signParams);
		String sign = SignatureUtil.encodeMD5(signpre);	
		String url = staticNotify + userId + "/0.0.0.0/" + money.toString();
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("sign", sign);
		params.put("nonceString", nonceString);
		params.put("timestamp", timestamp);
		HttpClientUtil.doPost(url, params);
	}

	@ResponseBody
	@RequestMapping("/checkPay/{orderNo}")
	public String checkPay(@PathVariable String orderNo) {
		boolean paySuccess = this.payOrderInfoServiceImpl.checkPay(orderNo);
		if(paySuccess) {
			return JsonResult.setReturnStr(SystemReturn.OK);	
		}else {
			return JsonResult.setReturnStr(SystemReturn.FAIL);
		}	
	}
	
	@ResponseBody
	@RequestMapping("/success")
	public String success() {
		return "pay/pay_success";
	}
	
}
