package com.sen.lifecycle.callbacks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author HuangJS
 * @date 2019-09-21 9:37 下午
 */
public class Test {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


		context.registerShutdownHook();
	}
}
