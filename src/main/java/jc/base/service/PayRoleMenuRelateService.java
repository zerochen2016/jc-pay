package jc.base.service;


import jc.mybatis.extension.util.PageModel;


import java.util.List;
import com.dbmysql.entity.PayRoleMenuRelate;


public interface PayRoleMenuRelateService {


	PageModel<PayRoleMenuRelate> pagePayRoleMenuRelate(PayRoleMenuRelate record, PageModel<PayRoleMenuRelate> pageModel);


	List<PayRoleMenuRelate> listPayRoleMenuRelate(PayRoleMenuRelate record);


	PayRoleMenuRelate getPayRoleMenuRelate(PayRoleMenuRelate record);


	PayRoleMenuRelate getPayRoleMenuRelateById(Integer id);


	int updatePayRoleMenuRelateById(PayRoleMenuRelate record,Integer id);


	int deletePayRoleMenuRelateById(Integer id);


	List<PayRoleMenuRelate> listPayRoleMenuRelateByRoleId(Integer roleId);


	int updatePayRoleMenuRelateByRoleId(PayRoleMenuRelate record,Integer roleId);


	int deletePayRoleMenuRelateByRoleId(Integer roleId);


	List<PayRoleMenuRelate> listPayRoleMenuRelateByMenuId(Integer menuId);


	int updatePayRoleMenuRelateByMenuId(PayRoleMenuRelate record,Integer menuId);


	int deletePayRoleMenuRelateByMenuId(Integer menuId);


	int insertPayRoleMenuRelate(PayRoleMenuRelate record);


	int updatePayRoleMenuRelate(PayRoleMenuRelate record);


	int deletePayRoleMenuRelate(PayRoleMenuRelate record);


}
