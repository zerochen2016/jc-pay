package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayRoleInfo;


public interface PayRoleInfoService {


	PageModel<PayRoleInfo> pagePayRoleInfo(PayRoleInfo record, PageModel<PayRoleInfo> pageModel);


	List<PayRoleInfo> listPayRoleInfo(PayRoleInfo record);


	PayRoleInfo getPayRoleInfo(PayRoleInfo record);


	PayRoleInfo getPayRoleInfoById(Integer id);


	int updatePayRoleInfoById(PayRoleInfo record,Integer id);


	int deletePayRoleInfoById(Integer id);


	int insertPayRoleInfo(PayRoleInfo record);


	int updatePayRoleInfo(PayRoleInfo record);


	int deletePayRoleInfo(PayRoleInfo record);


}
