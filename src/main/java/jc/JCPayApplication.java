package jc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.pay.util.BeanFactory;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { 
		"com.dbmysql",
		"com.dbredis",
		"jc",
		})
@EnableScheduling
@EnableAsync
public class JCPayApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(JCPayApplication.class, args);
		BeanFactory.setApplicationContext(applicationContext);
	}	
}
