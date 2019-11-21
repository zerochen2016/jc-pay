package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayOperator;


public interface PayOperatorService {


	PageModel<PayOperator> pagePayOperator(PayOperator record, PageModel<PayOperator> pageModel);


	List<PayOperator> listPayOperator(PayOperator record);


	PayOperator getPayOperator(PayOperator record);


	PayOperator getPayOperatorByAccount(String account);


	int updatePayOperatorByAccount(PayOperator record,String account);


	int deletePayOperatorByAccount(String account);


	int insertPayOperator(PayOperator record);


	int updatePayOperator(PayOperator record);


	int deletePayOperator(PayOperator record);


}
