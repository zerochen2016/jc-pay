package com.dbmysql.mapper;

import com.dbmysql.entity.PayOrderInfo;
import com.dbmysql.entity.PayOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderInfoMapper {
    long countByExample(PayOrderInfoExample example);

    int deleteByExample(PayOrderInfoExample example);

    int deleteByPrimaryKey(String orderNo);

    int insert(PayOrderInfo record);

    int insertSelective(PayOrderInfo record);

    List<PayOrderInfo> selectByExample(PayOrderInfoExample example);

    PayOrderInfo selectByPrimaryKey(String orderNo);

    int updateByExampleSelective(@Param("record") PayOrderInfo record, @Param("example") PayOrderInfoExample example);

    int updateByExample(@Param("record") PayOrderInfo record, @Param("example") PayOrderInfoExample example);

    int updateByPrimaryKeySelective(PayOrderInfo record);

    int updateByPrimaryKey(PayOrderInfo record);
}