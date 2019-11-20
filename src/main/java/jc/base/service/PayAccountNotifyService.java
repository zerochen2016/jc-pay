package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayAccountNotify;


public interface PayAccountNotifyService {


	PageModel<PayAccountNotify> pagePayAccountNotify(PayAccountNotify record, PageModel<PayAccountNotify> pageModel);


	List<PayAccountNotify> listPayAccountNotify(PayAccountNotify record);


	PayAccountNotify getPayAccountNotify(PayAccountNotify record);


	PayAccountNotify getPayAccountNotifyByAccount(String account);


	int updatePayAccountNotifyByAccount(PayAccountNotify record,String account);


	int deletePayAccountNotifyByAccount(String account);


	int insertPayAccountNotify(PayAccountNotify record);


	int updatePayAccountNotify(PayAccountNotify record);


	int deletePayAccountNotify(PayAccountNotify record);


}
