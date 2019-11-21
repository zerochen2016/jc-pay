package com.dbmysql.mapper.flexible;

import com.dbmysql.entity.PayMenu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMenuFlexibleMapper {
    
    List<PayMenu> listMenuResult(@Param("account")String account, @Param("pid")Integer pid);
}