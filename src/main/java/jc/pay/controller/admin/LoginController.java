package jc.pay.controller.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbmysql.entity.PayOperator;

import jc.base.service.PayOperatorService;
import jc.common.util.ImageUtil;
import jc.common.util.SignatureUtil;
import jc.common.util.UAUtil;
import jc.pay.cache.CacheSession;
import jc.pay.common.result.JsonResult;
import jc.pay.common.result.SystemReturn;
import jc.pay.entity.BaseInfo;





@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	PayOperatorService payOperatorServiceImpl;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) {
		int mask = 0;
		if(UAUtil.isQQ(request)||UAUtil.isWechat(request)) {
			mask = 1;
		}
		model.addAttribute("mask", mask);
		model.addAttribute("iconUrl", BaseInfo.SYSTEM_ICON_URL);
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String login(String account,String password,String verifyCode,HttpServletRequest request,Model model) {
		Object[] verifyCodeObject = CacheSession.getVerifyCode(request);
		//账号验空
		if(StringUtils.isEmpty(account)) {
			return JsonResult.setReturnStr(-1,"请填写登录账号");
		}
		//密码验空
		if(StringUtils.isEmpty(password)) {
			return JsonResult.setReturnStr(-1,"请填写密码");
		}
		if(StringUtils.isEmpty(verifyCode)) {
			return JsonResult.setReturnStr(-1,"请填写验证码");
		}
		if(!verifyCode.equalsIgnoreCase(String.valueOf(verifyCodeObject[0]))) {
			return JsonResult.setReturnStr(-1,"验证码错误");
		}
		PayOperator operator = new PayOperator();
		operator.setAccount(account);
		operator = this.payOperatorServiceImpl.getPayOperatorByAccount(account);
		if(operator == null) {
			return JsonResult.setReturnStr(-1,"用户不存在");
		}
		if(operator.getStatus() == 0) {
			return JsonResult.setReturnStr(-1,"账号被禁用");
		}
		password = SignatureUtil.encodeMD5(password);
		if(!password.equals(operator.getPassword())) {
			return JsonResult.setReturnStr(-1,"密码错误");
		}
		
		model.addAttribute("iconUrl", BaseInfo.SYSTEM_ICON_URL);
		model.addAttribute("name", BaseInfo.SYSTEM_NAME);
		CacheSession.setOperator(request, operator);
		return JsonResult.setReturnStr(SystemReturn.OK);
	}
	/**
	 * 获取验证码
	 * @author Zero.chen
	 * @param httpRequest
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/getVerifyPicture")
	public void getVerifyPicture(HttpServletRequest request,HttpServletResponse response) {
		//获取图片验证码
		Object[] objs = ImageUtil.createVerifyImage();
        BufferedImage image = (BufferedImage) objs[1];  
        File file;
		try {
			file = File.createTempFile("tempFile", ".png");
			OutputStream os = new FileOutputStream(file);
	        ImageIO.write(image, "png", os);  
	        os.close();
		} catch (IOException e) {
			LOGGER.error("-----------------------------------getVerifyPicture error",e);
		}
		CacheSession.setVerifyCode(request,objs);
		BufferedImage bufferImage = (BufferedImage) objs[1]; //生成一个bufferImage
			try {
				//通过write方法将图像从内存中写到页面上。
				ImageIO.write(bufferImage , "jpg", response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			} 
	}	
}
