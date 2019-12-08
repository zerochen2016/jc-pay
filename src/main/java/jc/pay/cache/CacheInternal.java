package jc.pay.cache;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbmysql.entity.PayConfigInfo;

import jc.base.service.PayConfigInfoService;


@Component
public class CacheInternal {

	private static TreeMap<String,String> CONFIG_INFO = null;
	
	static {
		CONFIG_INFO = CONFIG_INFO == null ? new TreeMap<String, String>() : CONFIG_INFO;
	}
	
	@Autowired
	PayConfigInfoService payConfigInfoServiceImpl;
	
	@PostConstruct
	private void init() {
		this.payConfigInfoServiceImpl.listPayConfigInfo(new PayConfigInfo()).stream().forEach(x->{
			CONFIG_INFO.put(x.getConfigKey(),x.getConfigValue());
		});
	}
	
	public static int coinChipRage() {
		return Integer.valueOf(CONFIG_INFO.get("COIN_CHIP_RATE"));
	}
	
	public static int chipInit() {
		return  Integer.valueOf(CONFIG_INFO.get("CHIP_INIT"));
	}
	
	public static String chessPathKey() {
		return CONFIG_INFO.get("CHESS_PATH_KEY");
	}
	
	public static String chessWebUrl() {
		return CONFIG_INFO.get("CHESS_WEB_URL");
	}
	
	public static String zbApiPublicKey() {
		return CONFIG_INFO.get("ZB_API_PUBLIC_API");
	}
	
	public static int orderExpireTimeMinutes() {
		return Integer.valueOf(CONFIG_INFO.get("PAY_EXPIRE_TIME_MINUTES") + "");
	}
	
	public static long orderExpireTimeMilliSecond() {
		return (long)orderExpireTimeMinutes() * 60000l;
	}
	
	public static String jumpUrlAlipay() {
		return CONFIG_INFO.get("PAY_JUMP_ALIPAY");
	}
	
	public static String jumpUrlWechat() {
		return CONFIG_INFO.get("PAY_JUMP_WECHAT");
	}
	
	public static String payPublicKey(){
		return CONFIG_INFO.get("PAY_PUBLIC_KEY");
	}
	
	public static String extPublicKey(){
		return CONFIG_INFO.get("EXT_PUBLIC_KEY");
	}
	
	public static String mainColor() {
		return CONFIG_INFO.get("MAIN_COLOR");
	}
	
	public static String shareUrl() {
		return CONFIG_INFO.get("ZB_SHARE_URL");
	}
	
	public static int payButtonType() {
		return Integer.valueOf(CONFIG_INFO.get("PAY_BUTTON_TYPE"));
	}
	
	public static TreeSet<String> whiteListIP(){
		return new TreeSet<String>(Arrays.asList(CONFIG_INFO.get("WHITE_LIST_IP").split(",")));
	}
}
