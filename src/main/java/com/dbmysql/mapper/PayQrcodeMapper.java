package com.dbmysql.mapper;

import com.dbmysql.entity.PayQrcode;
import com.dbmysql.entity.PayQrcodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayQrcodeMapper {
    long countByExample(PayQrcodeExample example);

    int deleteByExample(PayQrcodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayQrcode record);

    int insertSelective(PayQrcode record);

    List<PayQrcode> selectByExample(PayQrcodeExample example);

    PayQrcode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayQrcode record, @Param("example") PayQrcodeExample example);

    int updateByExample(@Param("record") PayQrcode record, @Param("example") PayQrcodeExample example);

    int updateByPrimaryKeySelective(PayQrcode record);

    int updateByPrimaryKey(PayQrcode record);
}