package com.sen.lifecycle.callbacks;

import org.springframework.context.annotation.Bean;

/**
 * @author HuangJS
 * @date 2019-09-21 9:18 下午
 */
public class Config {
	@Bean
	public ExampleInitDestroyBean exampleDestroyBean() {
		return new ExampleInitDestroyBean();
	}

	@Bean
	public ExampleInitDestroyForAnnotationBean exampleInitDestroyForAnnotationBean() {
		return new ExampleInitDestroyForAnnotationBean();
	}

}
