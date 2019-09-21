package com.sen.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author HuangJS
 * @date 2019-09-21 5:15 下午
 */
public class ApplicationContextHolder implements ApplicationContextAware {
	private static final ApplicationContextHolder INSTANCE = new ApplicationContextHolder();
	public static ApplicationContext context;
	private ApplicationContextHolder(){}

	public static ApplicationContextHolder getInstance() {
		System.out.println("ApplicationContextHolder:  getInstance()");
		return INSTANCE;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextHolder:  setApplicationContext()");
		context = applicationContext;
	}
}
