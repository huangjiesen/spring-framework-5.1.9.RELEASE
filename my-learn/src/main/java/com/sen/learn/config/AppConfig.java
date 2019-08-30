package com.sen.learn.config;

import com.sen.learn.config.dao.MapperScan;
import com.sen.learn.service.DogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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

	//@Bean
	//public MapperBeanDefinitionRegistryPostProcessor daoBeanDefinitionRegistryPostProcessor() {
	//	return new MapperBeanDefinitionRegistryPostProcessor();
	//}
}
