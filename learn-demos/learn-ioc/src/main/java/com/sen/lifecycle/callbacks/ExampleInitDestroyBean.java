package com.sen.lifecycle.callbacks;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @link https://docs.spring.io/spring/docs/5.1.9.RELEASE/spring-framework-reference/core.html#beans-factory-lifecycle
 * @author HuangJS
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
}
