package com.dbmysql.mapper;

import com.dbmysql.entity.PayMenu;
import com.dbmysql.entity.PayMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMenuMapper {
    long countByExample(PayMenuExample example);

    int deleteByExample(PayMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayMenu record);

    int insertSelective(PayMenu record);

    List<PayMenu> selectByExample(PayMenuExample example);

    PayMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMenu record, @Param("example") PayMenuExample example);

    int updateByExample(@Param("record") PayMenu record, @Param("example") PayMenuExample example);

    int updateByPrimaryKeySelective(PayMenu record);

    int updateByPrimaryKey(PayMenu record);
}