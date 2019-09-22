package com.sen.test.lifecycle.callbacks;

import com.sen.lifecycle.callbacks.Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author HuangJS
 * @date 2019-09-21 9:20 下午
 */
public class ExampleInitDestroyBeanTest {
	@Test
	public void test() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("application context init finish");

		// 关闭Spring IoC容器
		context.registerShutdownHook();
	}
}
