package com.dbmysql.mapper;

import com.dbmysql.entity.PayRoleMenuRelate;
import com.dbmysql.entity.PayRoleMenuRelateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRoleMenuRelateMapper {
    long countByExample(PayRoleMenuRelateExample example);

    int deleteByExample(PayRoleMenuRelateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayRoleMenuRelate record);

    int insertSelective(PayRoleMenuRelate record);

    List<PayRoleMenuRelate> selectByExample(PayRoleMenuRelateExample example);

    PayRoleMenuRelate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayRoleMenuRelate record, @Param("example") PayRoleMenuRelateExample example);

    int updateByExample(@Param("record") PayRoleMenuRelate record, @Param("example") PayRoleMenuRelateExample example);

    int updateByPrimaryKeySelective(PayRoleMenuRelate record);

    int updateByPrimaryKey(PayRoleMenuRelate record);
}