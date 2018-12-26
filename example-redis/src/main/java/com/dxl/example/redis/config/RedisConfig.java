package com.dxl.example.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Program RedisConfig
 * @Description
 * @Author duxl
 * @Create 2018/12/25 10:21
 */
@Configuration
public class RedisConfig {
	@Value("${clusterOn}")
	private Boolean clusterOn;

	@Bean("redisTemplate")
	public RedisTemplate getRedisTemplate() {
		RedisTemplate t = new RedisTemplate();
		if (clusterOn != null && clusterOn) {
			t.setConnectionFactory(clusterJedisConnectionFactory());
		} else {
			t.setConnectionFactory(standaloneJedisConnectionFactory());
		}
		StringRedisSerializer ks = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<Object> vs = new Jackson2JsonRedisSerializer<>(Object.class);
		t.setKeySerializer(ks);
		t.setValueSerializer(vs);
		t.setHashKeySerializer(ks);
		t.setHashValueSerializer(vs);
		t.afterPropertiesSet();
		return t;
	}


	@Bean("standaloneJedisConnectionFactory")
	public JedisConnectionFactory standaloneJedisConnectionFactory() {
		return new JedisConnectionFactory(redisStandaloneConfiguration());

	}


	@Bean("clusterJedisConnectionFactory")
	public JedisConnectionFactory clusterJedisConnectionFactory() {
		return new JedisConnectionFactory(redisClusterConfiguration(), jedisPoolConfig());
	}

	/**
	 * 单机配置
	 *
	 * @return
	 */
	@Bean
	public RedisStandaloneConfiguration redisStandaloneConfiguration() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
		//redisStandaloneConfiguration.setPassword(RedisPassword.of("cashman"));
		return redisStandaloneConfiguration;
	}

	/**
	 * 集群配置
	 *
	 * @return
	 */
	@Bean
	public RedisClusterConfiguration redisClusterConfiguration() {
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6379));
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6380));
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6381));
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6382));
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6383));
		redisClusterConfiguration.addClusterNode(new RedisNode("172.16.0.37", 6384));
		redisClusterConfiguration.setPassword(RedisPassword.of("cashman"));
		return redisClusterConfiguration;
	}

	/**
	 * 连接池配置
	 *
	 * @return
	 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(50);
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMaxWaitMillis(20000);
		return jedisPoolConfig;
	}

}
