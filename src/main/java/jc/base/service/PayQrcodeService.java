package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayQrcode;


public interface PayQrcodeService {


	PageModel<PayQrcode> pagePayQrcode(PayQrcode record, PageModel<PayQrcode> pageModel);


	List<PayQrcode> listPayQrcode(PayQrcode record);


	PayQrcode getPayQrcode(PayQrcode record);


	PayQrcode getPayQrcodeById(Integer id);


	int updatePayQrcodeById(PayQrcode record,Integer id);


	int deletePayQrcodeById(Integer id);


	List<PayQrcode> listPayQrcodeByAccount(String account);


	int updatePayQrcodeByAccount(PayQrcode record,String account);


	int deletePayQrcodeByAccount(String account);


	List<PayQrcode> listPayQrcodeByMoneyKey(String moneyKey);


	int updatePayQrcodeByMoneyKey(PayQrcode record,String moneyKey);


	int deletePayQrcodeByMoneyKey(String moneyKey);


	int insertPayQrcode(PayQrcode record);


	int updatePayQrcode(PayQrcode record);


	int deletePayQrcode(PayQrcode record);
	
	PayQrcode getQRCode(String money,String uid);

}
