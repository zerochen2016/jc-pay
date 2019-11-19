package com.dbmysql.mapper;

import com.dbmysql.entity.PayConfigInfo;
import com.dbmysql.entity.PayConfigInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayConfigInfoMapper {
    long countByExample(PayConfigInfoExample example);

    int deleteByExample(PayConfigInfoExample example);

    int deleteByPrimaryKey(String configKey);

    int insert(PayConfigInfo record);

    int insertSelective(PayConfigInfo record);

    List<PayConfigInfo> selectByExample(PayConfigInfoExample example);

    PayConfigInfo selectByPrimaryKey(String configKey);

    int updateByExampleSelective(@Param("record") PayConfigInfo record, @Param("example") PayConfigInfoExample example);

    int updateByExample(@Param("record") PayConfigInfo record, @Param("example") PayConfigInfoExample example);

    int updateByPrimaryKeySelective(PayConfigInfo record);

    int updateByPrimaryKey(PayConfigInfo record);
}