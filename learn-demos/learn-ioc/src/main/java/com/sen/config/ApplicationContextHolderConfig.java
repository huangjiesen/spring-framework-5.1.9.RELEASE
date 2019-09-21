package com.sen.config;

import com.sen.aware.ApplicationContextHolder;
import org.springframework.context.annotation.Bean;

/**
 * @author HuangJS
 * @date 2019-09-21 5:17 下午
 */
public class ApplicationContextHolderConfig {

	@Bean
	public ApplicationContextHolder applicationContextHolder() {
		 System.out.println("ApplicationContextHolder: config bean getInstance befer()");
		 ApplicationContextHolder instance = ApplicationContextHolder.getInstance();
		 System.out.println("ApplicationContextHolder: config bean getInstance after()");
		 return instance;
	}

	@Bean
	public Globals globals() {
		Globals globals = new Globals();
		globals.setUrl("www.baidu.com");
		return globals;
	}
}
