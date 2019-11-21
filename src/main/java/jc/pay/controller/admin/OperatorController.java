package jc.pay.controller.admin;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbmysql.entity.PayOperator;

import jc.base.service.PayOperatorService;
import jc.common.util.DateUtil;
import jc.common.util.SignatureUtil;
import jc.pay.cache.CacheSession;
import jc.pay.common.result.JsonResult;
import jc.pay.common.result.SystemReturn;
import jc.pay.entity.BaseInfo;

@Controller
@RequestMapping("/admin")
public class OperatorController {

	@Autowired
	PayOperatorService payOperatorServiceImpl;
	
	@RequestMapping("/operator/password")
	public String updatePassword(HttpServletRequest request, Model model) {
		model.addAttribute("account", CacheSession.getOperator(request).getAccount());
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		return "/admin/operator/update_password";
	}
	
	@ResponseBody
	@RequestMapping("/operator/updatePassword/{account}/{password}")
	public String updatePassword(@PathVariable String account, @PathVariable String password,
			HttpServletRequest request) {
		PayOperator operator = CacheSession.getOperator(request);
		if(!operator.getAccount().equals(account)) {
			return JsonResult.setReturnStr(SystemReturn.FAIL);
		}
		PayOperator record = new PayOperator();
		record.setPassword(SignatureUtil.encodeMD5(password));
		record.setUpdateTime(DateUtil.getSystemTimeLong());
		this.payOperatorServiceImpl.updatePayOperatorByAccount(record, account);
		return JsonResult.setReturnStr(SystemReturn.OK);
	}

}
