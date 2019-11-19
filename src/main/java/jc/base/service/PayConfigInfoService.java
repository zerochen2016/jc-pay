package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayConfigInfo;


public interface PayConfigInfoService {


	PageModel<PayConfigInfo> pagePayConfigInfo(PayConfigInfo record, PageModel<PayConfigInfo> pageModel);


	List<PayConfigInfo> listPayConfigInfo(PayConfigInfo record);


	PayConfigInfo getPayConfigInfo(PayConfigInfo record);


	PayConfigInfo getPayConfigInfoByConfigKey(String configKey);


	int updatePayConfigInfoByConfigKey(PayConfigInfo record,String configKey);


	int deletePayConfigInfoByConfigKey(String configKey);


	List<PayConfigInfo> listPayConfigInfoByConfigType(Integer configType);


	int updatePayConfigInfoByConfigType(PayConfigInfo record,Integer configType);


	int deletePayConfigInfoByConfigType(Integer configType);


	int insertPayConfigInfo(PayConfigInfo record);


	int updatePayConfigInfo(PayConfigInfo record);


	int deletePayConfigInfo(PayConfigInfo record);


}
