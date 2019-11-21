package jc.pay.cache;

import javax.servlet.http.HttpServletRequest;

import com.dbmysql.entity.PayOperator;



/**
 * 
 * @author JC
 * @Date 2019年11月22日
 * @since
 */
public class CacheSession {
	
	private static interface SESSIONKEY {
		public final String OPERATOR = "LOGIN_OPERATOR:";
		public final String VERIFYCODE = "VERIFYCODE";
	}

	/**
	 * @Remark 从SESSION中获取图片验证码
	 * @param request
	 * @return
	 */
	public static Object[] getVerifyCode(HttpServletRequest request) {
		return (Object[]) request.getSession().getAttribute(SESSIONKEY.VERIFYCODE);
	}
	/**
	 * @Remark 将图片验证码设置到SESSION中
	 * @param request
	 * @param objs
	 */
	public static void setVerifyCode(HttpServletRequest request, Object[] objs) {
		request.getSession().setAttribute(SESSIONKEY.VERIFYCODE, objs);
	}
	
	/**
	 * @Remark 从session中获取user
	 * @param request
	 * @return
	 */
	public static PayOperator getOperator(HttpServletRequest request) {
		return (PayOperator) request.getSession().getAttribute(SESSIONKEY.OPERATOR);
	}
	
	/**
	 * @Remark 将user设置到session
	 * @param request
	 * @param user
	 */
	public static void setOperator(HttpServletRequest request, PayOperator operator) {
		//退出
		if(operator==null) {
			request.getSession().removeAttribute(SESSIONKEY.OPERATOR);
		}
		request.getSession().setAttribute(SESSIONKEY.OPERATOR, operator);
	}
	
}
