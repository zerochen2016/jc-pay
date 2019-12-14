package jc.pay.interceptor;


import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dbmysql.entity.PayOperator;
import com.pay.util.BeanFactory;

import jc.base.service.impl.PayOperatorServiceImpl;
import jc.common.util.IPUtil;
import jc.pay.cache.CacheInternal;
import jc.pay.cache.CacheSession;



public class AdminInterceptor implements HandlerInterceptor{

	private static Logger log = LoggerFactory.getLogger(AdminInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(this.adminIntercept(request)) {
			return true;
		}
		response.sendRedirect("/login/home");
		return false;
	}



	private boolean adminIntercept(HttpServletRequest request) {
		PayOperator user = CacheSession.getOperator(request);
		if(user == null) {
			TreeSet<String> ips = CacheInternal.whiteListIP();
			if(ips.contains(IPUtil.getClientIpSimple(request))) {
				PayOperator operator = BeanFactory.getBean(PayOperatorServiceImpl.class).getPayOperatorByAccount("admin");
				CacheSession.setOperator(request, operator);
				return true;
			}
			log.info("------------------------------admin interceptor------------:not login,uri={}",request.getRequestURL());
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
