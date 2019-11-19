package com.dbmysql.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = {
		MasterDataSourceConfiguration.PACKAGE,
		MasterDataSourceConfiguration.PACKAGE2
}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(MasterDataSourceConfiguration.class);
	// 精确到 master 目录，以便跟其他数据源隔离
	static final String PACKAGE = "com.dbmysql.mapper";
	static final String PACKAGE2 = "com.dbmysql.mapper.flexible";

	@Value("${mysql.datasource.master.url}")
	private String url;

	@Value("${mysql.datasource.master.username}")
	private String user;

	@Value("${mysql.datasource.master.password}")
	private String password;

	@Value("${mysql.datasource.master.driverClassName}")
	private String driverClass;

	@Value("${mysql.datasource.master.loginTimeout:30}")
	private Integer loginTimeout;

	@Value("${mysql.datasource.master.maxIdle:15}")
	private Integer maxIdle;
	@Value("${mysql.datasource.master.minIdle:10}")
	private Integer minIdle;
	
	@Value("${mysql.datasource.master.maxActive:30}")
	private Integer maxActive;

	/**
	 * mysql.datasource.master.minPoolSize=3
	 * mysql.datasource.master.maxPoolSize=25
	 * mysql.datasource.master.maxLifetime=20000
	 * mysql.datasource.master.borrowConnectionTimeout=30
	 * mysql.datasource.master.loginTimeout=30
	 * mysql.datasource.master.maintenanceInterval=60
	 * mysql.datasource.master.maxIdleTime=60
	 * 
	 * @return
	 */

	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setLoginTimeout(loginTimeout);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestWhileIdle(true);
		dataSource.setTimeBetweenEvictionRunsMillis(3600000);
		LOGGER.info("-------------------------------------------------- first datasource --------------------------------------------------");
		LOGGER.info("-------------------------------------------------- {} --------------------------------------------------",url);
		LOGGER.info("-------------------------------------------------- first datasource --------------------------------------------------");
		return dataSource;
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(masterDataSource());
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);
		return sessionFactory.getObject();
	}
}
