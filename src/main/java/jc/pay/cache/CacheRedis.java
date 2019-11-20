package jc.pay.cache;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import jc.common.util.DateUtil;

@Component
public class CacheRedis {

	private static Logger log = LoggerFactory.getLogger(CacheRedis.class);
	
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	public boolean hasKey(String key) {
		return this.redisTemplate.hasKey(key);
	}
	
	@PostConstruct
	private void checkRedisConnect() {
		String key = "TEST:" + DateUtil.getSystemTimeLong();
		this.redisTemplate.opsForValue().set(key, "1", 1, TimeUnit.MINUTES);
		log.info("-------------------------------------------------- redis connect --------------------------------------------------");
		log.info("-------------------------------------------------- {} --------------------------------------------------",this.redisTemplate.opsForValue().get(key));
		log.info("-------------------------------------------------- redis connect --------------------------------------------------");
	}
	
	public void setCache(String key, String value) {
		this.redisTemplate.opsForValue().set(key, value);
	}
	
	public void setCache(String key, String value, long minutes) {
		this.redisTemplate.opsForValue().set(key, value, minutes, TimeUnit.MINUTES);
	}
	
	public String getCache(String key) {
		if(!this.redisTemplate.hasKey(key)) {
			return "";
		}
		return this.redisTemplate.opsForValue().get(key) + "";
	}
}
