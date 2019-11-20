package jc.pay.interceptor;



import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jc.common.util.SignatureUtil;
import jc.common.util.StringUtil;
import jc.pay.cache.CacheInternal;
import jc.pay.common.result.JsonResult;



public class PayInterceptor implements HandlerInterceptor{

	private static Logger logger = LoggerFactory.getLogger(PayInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(checkSign(request)) {
			return true;
		}
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null ;
		out = response.getWriter();
		out.append(JsonResult.setReturnStr(-1,"签名错误"));
		return false;
	}

	private boolean checkSign(HttpServletRequest request) {
		String sign = request.getParameter("sign");
		String nonceString = request.getParameter("nonceString");
		String timestamp = request.getParameter("timestamp");
		if(StringUtil.anyEmpty(timestamp, nonceString, sign)) {
			logger.info("------------------sign parameters empty, url={}, sign={}, timestamp={}, nonceString={}",
					request.getRequestURI(), sign, timestamp, nonceString);
			return false;
		}
		String signpre= String.format("nonceString=%s&publicKey=%s&timestamp=%s", nonceString, CacheInternal.payPublicKey(), timestamp);
		String mysign = SignatureUtil.encodeMD5(signpre);
		if(!mysign.equals(sign)) {
			logger.info("-------------------sign not equal, url={},timestamp={}, nonceString={}, signpre={}, sign={}, mysign={}",
					request.getRequestURI(),timestamp, nonceString, signpre, sign, mysign);
			return false;
		}	
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
