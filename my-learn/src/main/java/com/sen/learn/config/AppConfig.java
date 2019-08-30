package com.sen.learn.config;

import com.sen.learn.mapper.SqlSession;
import com.sen.learn.mapper.MapperScan;
import com.sen.learn.service.DogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在@MapperScan注解中import MapperBeanDefinitionRegistryPostProcessor.class
 * @author HuangJS
 * @date 2019-08-29 9:44 AM
 */
@Configuration
@MapperScan("com.sen.learn.dao")
public class AppConfig {

	@Bean
	public DogService dogService() {
		return new DogService();
	}


	// sql session 模拟类
	@Bean
	public SqlSession sqlSession() {
		return new SqlSession();
	}

	//@Bean
	//public MapperBeanDefinitionRegistryPostProcessor daoBeanDefinitionRegistryPostProcessor() {
	//	return new MapperBeanDefinitionRegistryPostProcessor();
	//}

}
