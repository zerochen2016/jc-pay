package jc.base.service;


import jc.mybatis.extension.util.PageModel;
import jc.pay.common.result.JsonResult;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dbmysql.entity.PayMenu;

@Service
public interface PayMenuService {


	PageModel<PayMenu> pagePayMenu(PayMenu record, PageModel<PayMenu> pageModel);


	List<PayMenu> listPayMenu(PayMenu record);


	PayMenu getPayMenu(PayMenu record);


	PayMenu getPayMenuById(Integer id);


	int updatePayMenuById(PayMenu record,Integer id);


	int deletePayMenuById(Integer id);


	List<PayMenu> listPayMenuByPid(Integer pid);


	int updatePayMenuByPid(PayMenu record,Integer pid);


	int deletePayMenuByPid(Integer pid);


	List<PayMenu> listPayMenuByStatus(Integer status);


	int updatePayMenuByStatus(PayMenu record,Integer status);


	int deletePayMenuByStatus(Integer status);


	int insertPayMenu(PayMenu record);


	int updatePayMenu(PayMenu record);


	int deletePayMenu(PayMenu record);

	JsonResult listMenuResult(String account);

}
