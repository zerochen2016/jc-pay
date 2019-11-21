package jc.pay.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbmysql.entity.PayOperator;

import jc.base.service.PayMenuService;
import jc.common.util.UAUtil;
import jc.pay.cache.CacheSession;
import jc.pay.common.result.JsonResult;
import jc.pay.entity.BaseInfo;



@Controller
@RequestMapping("/admin")
public class IndexController {

	@Autowired
	PayMenuService payMenuServiceImpl;
	/**
	 * @Remark 首页
	 * @author Zero.chen
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/home")
	public String index(Model model,HttpServletRequest request) {
		PayOperator operator = CacheSession.getOperator(request);
		int mask = 0;
		if(UAUtil.isQQ(request)||UAUtil.isWechat(request)) {
			mask = 1;
		}
		model.addAttribute("mask", mask);
		JsonResult jsonResult = this.payMenuServiceImpl.listMenuResult(operator.getAccount());
		model.addAttribute("menus", jsonResult.getData());
		model.addAttribute("iconUrl", BaseInfo.SYSTEM_ICON_URL);
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		return "index";
	}
	
	/**
	 * @Remark 退出
	 * @date 2018年11月13日
	 * @param request
	 * @return
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request, Model model) {
		CacheSession.setOperator(request, null);
		int mask = 0;
		if(UAUtil.isQQ(request)||UAUtil.isWechat(request)) {
			mask = 1;
		}
		model.addAttribute("mask", mask);
		model.addAttribute("iconUrl", BaseInfo.SYSTEM_ICON_URL);
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		return "login";
	}
}
