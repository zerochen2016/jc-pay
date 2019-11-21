package com.dbmysql.mapper;

import com.dbmysql.entity.PayOperator;
import com.dbmysql.entity.PayOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOperatorMapper {
    long countByExample(PayOperatorExample example);

    int deleteByExample(PayOperatorExample example);

    int deleteByPrimaryKey(String account);

    int insert(PayOperator record);

    int insertSelective(PayOperator record);

    List<PayOperator> selectByExample(PayOperatorExample example);

    PayOperator selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") PayOperator record, @Param("example") PayOperatorExample example);

    int updateByExample(@Param("record") PayOperator record, @Param("example") PayOperatorExample example);

    int updateByPrimaryKeySelective(PayOperator record);

    int updateByPrimaryKey(PayOperator record);
}