package com.dbmysql.mapper;

import com.dbmysql.entity.PayAccountNotify;
import com.dbmysql.entity.PayAccountNotifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayAccountNotifyMapper {
    long countByExample(PayAccountNotifyExample example);

    int deleteByExample(PayAccountNotifyExample example);

    int deleteByPrimaryKey(String account);

    int insert(PayAccountNotify record);

    int insertSelective(PayAccountNotify record);

    List<PayAccountNotify> selectByExample(PayAccountNotifyExample example);

    PayAccountNotify selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") PayAccountNotify record, @Param("example") PayAccountNotifyExample example);

    int updateByExample(@Param("record") PayAccountNotify record, @Param("example") PayAccountNotifyExample example);

    int updateByPrimaryKeySelective(PayAccountNotify record);

    int updateByPrimaryKey(PayAccountNotify record);
}