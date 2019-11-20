package com.dbmysql.mapper;

import com.dbmysql.entity.PayRoleInfo;
import com.dbmysql.entity.PayRoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRoleInfoMapper {
    long countByExample(PayRoleInfoExample example);

    int deleteByExample(PayRoleInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayRoleInfo record);

    int insertSelective(PayRoleInfo record);

    List<PayRoleInfo> selectByExample(PayRoleInfoExample example);

    PayRoleInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayRoleInfo record, @Param("example") PayRoleInfoExample example);

    int updateByExample(@Param("record") PayRoleInfo record, @Param("example") PayRoleInfoExample example);

    int updateByPrimaryKeySelective(PayRoleInfo record);

    int updateByPrimaryKey(PayRoleInfo record);
}