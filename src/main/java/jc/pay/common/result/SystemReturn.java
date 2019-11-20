package jc.pay.common.result;

public enum SystemReturn {
	OK(0, "请求成功"), 
	FAIL(-1,"请求错误"), 
	PLEASE_SMV_CODE(-1,"请输入短信验证码"), 
	PLEASE_SEND_SMV_CODE(-1,"请先发送短信验证码"), 	
	PLEASE_MOBILE(-1,"请正确输入手机号"), 
	ERROR_SMV_CODE(-1,"验证码错误"), 
//	INSERT_FAIL(101,"添加失败"),
//	UPDATE_FAIL(102,"修改失败"),
//	DELETE_FAIL(103,"删除失败"),
//	DATA_NULL(1000,"空数据"), 
	
//	NOT_LOGIN(1002,"用户未登录"), 
//	REGISTER_FAIL(2000,"手机号或用户名已经被使用"),
//	LOGIN_FAIL(2001,"该账号未注册"),
//	PASSWORD_ERROR(2002,"密码错误"), 
	GUEST(900, "游客模式"),
	LOGIN_INVALID(700, "您的登陆状态失效，请重新登陆！"), 
	USER_ISBAN(1001, "该账号已经被禁用"), 
	GET_FAIL(1001, "领取奖励失败！"),
	CONSTANT_VERIFY(1002, "验证码为123456"),
	NOT_MOBILE(1001,"请输入正确的手机号"),
	FREQUENT_VERIFY(1002, "验证码5分钟有效，请勿多次发送"), 
	VERIFY_INVALID(1002, "请先获取验证码或验证码已失效"),
	VERIFY_ERROR(1002, "验证码错误"),
	REGISTER_FAIL(1007, "注册失败，请重试"),
	INSTANCE(9999, ""),
	LIVE_STOP(1005, "直播已结束"),
	SUPER_CANNT_IN(1007, "超管不能进入1v1房间"), 
	PLEASE_AUTH(1002, "请先进行身份认证或等待审核"),
	PASSWORD_NOTNULL(1002, "密码不能为空"), 
	PRICECANNOTLESSTHANZERO(1003,"价格不能小于等于0")
	;
	private int code;
	private String msg;

	private SystemReturn(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static SystemReturn instance(int code, String msg) {
		SystemReturn instance = SystemReturn.INSTANCE;
		instance.setCode(code);
		instance.setMsg(msg);
		return instance;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
