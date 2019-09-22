package com.sen.lifecycle.callbacks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 *
 * @author HuangJS
 * @date 2019-09-21 9:16 下午
 */
public class ExampleInitDestroyForAnnotationBean {

	// 使用@PostConstruct注解的方法,会在bean初始化时被调用
	// 使用@PreDestroy注解的方法,会在Spring IoC销毁时执行该方法
	@PreDestroy
	@PostConstruct
	public void init() throws Exception {
		System.out.println("ExampleInitDestroyForAnnotationBean for @PostConstruct.init()");
	}

	@PostConstruct
	public void init2() throws Exception {
		System.out.println("ExampleInitDestroyForAnnotationBean for @PostConstruct.init2()");
	}
	@PostConstruct
	public void init3() throws Exception {
		System.out.println("ExampleInitDestroyForAnnotationBean for @PostConstruct.init3()");
	}


	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("ExampleInitDestroyForAnnotationBean for @PreDestroy.destroy()");
	}
	@PreDestroy
	public void destroy1() throws Exception {
		System.out.println("ExampleInitDestroyForAnnotationBean for @PreDestroy.destroy1()");
	}


}
