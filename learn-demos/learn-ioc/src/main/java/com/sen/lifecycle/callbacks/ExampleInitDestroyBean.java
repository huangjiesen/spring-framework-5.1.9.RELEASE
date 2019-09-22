package com.sen.lifecycle.callbacks;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author HuangJS
 * @link https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/core.html#beans-factory-lifecycle
 * @date 2019-09-21 9:16 下午
 */
public class ExampleInitDestroyBean implements InitializingBean, DisposableBean {

	// 重写的InitializingBean.afterPropertiesSet方法,会在bean初始化时执行该方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ExampleDestroyBean for InitializingBean.afterPropertiesSet");
	}

	// 重写的DisposableBean.destroy方法,会在Spring IoC销毁时执行该方法
	// 非web应用的环境下,可调用AbstractApplicationContext.registerShutdownHook()方法关闭Spring的IoC容器
	@Override
	public void destroy() throws Exception {
		System.out.println("ExampleDestroyBean for DisposableBean.destroy");
	}

	//为同一个bean配置的具有不同初始化方法的多种生命周期机制如下：
	//	1.用注释的方法 @PostConstruct
	//	2.afterPropertiesSet()由InitializingBean回调接口定义
	//	3.定制配置的init()方法
	//销毁方法的调用顺序相同：
	//	1.用注释的方法 @PreDestroy
	//	2.destroy()由DisposableBean回调接口定义
	//	3.定制配置的destroy()方法
}
