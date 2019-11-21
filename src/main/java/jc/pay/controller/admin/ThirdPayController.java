package jc.pay.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbmysql.entity.PayAccountNotify;
import com.dbmysql.entity.PayOrderInfo;

import jc.base.service.PayAccountNotifyService;
import jc.base.service.PayOrderInfoService;
import jc.common.util.DateUtil;
import jc.common.util.HttpClientUtil;
import jc.common.util.RandomUtil;
import jc.common.util.SignatureUtil;
import jc.mybatis.extension.util.PageModel;
import jc.pay.cache.CacheInternal;
import jc.pay.common.result.JsonResult;
import jc.pay.common.result.SystemReturn;
import jc.pay.entity.BaseInfo;

@Controller
@RequestMapping("/admin")
public class ThirdPayController {
	
	@Autowired
	PayOrderInfoService payOrderInfoServiceImpl;
	@Autowired
	PayAccountNotifyService payAccountNotifyServiceImpl;
	
	@RequestMapping("/thirdPay/pager")
	public String thirdPay(PayOrderInfo record, PageModel<PayOrderInfo> pageModel, Model model,
			HttpServletRequest request) {
		pageModel = this.payOrderInfoServiceImpl.pagePayOrderInfo(record, pageModel);
		model.addAttribute("pageModel", pageModel);
		model.addAttribute("record", record);
		model.addAttribute("action", request.getRequestURI());
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		return "admin/pay/third_pay";
	}
	
	@ResponseBody
	@RequestMapping("/thirdPay/notifyOrder/{tradeNo}/{account}")
	public String notifyOrder(@PathVariable String tradeNo, @PathVariable String account) {
		PayOrderInfo record = new PayOrderInfo();
		record.setStatus(2);
		this.payOrderInfoServiceImpl.updatePayOrderInfoByTradeNo(record, tradeNo);
		PayAccountNotify pn = this.payAccountNotifyServiceImpl.getPayAccountNotifyByAccount(account);
		String url = pn.getNotify();
		String nonceString = RandomUtil.getRandomChar(16);
		String timestamp = DateUtil.getSystemTimeInt()+"";
		Map<String,String> signParams = new HashMap<>();
		signParams.put("nonceString", nonceString);
		signParams.put("timestamp", timestamp);
		signParams.put("publicKey", CacheInternal.payPublicKey());
		String signpre = SignatureUtil.sortParams(signParams);
		String sign = SignatureUtil.encodeMD5(signpre);		
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("tradeNo", tradeNo);
		params.put("sign", sign);
		params.put("nonceString", nonceString);
		params.put("timestamp", timestamp);
		HttpClientUtil.doPost(url, params, "utf-8");
		return JsonResult.setReturnStr(SystemReturn.OK);
	}
}

