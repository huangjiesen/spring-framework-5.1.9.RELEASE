package com.sen;

import com.sen.aware.ApplicationContextHolder;
import com.sen.config.ApplicationContextHolderConfig;
import com.sen.config.Globals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author HuangJS
 * @date 2019-09-21 5:19 下午
 */
public class ApplicationContextAwareTest {
	@Before
	public void before() {
		//ApplicationContext context =
				new AnnotationConfigApplicationContext(ApplicationContextHolderConfig.class);
		//Globals bean = context.getBean(Globals.class);
		//System.out.println("before out "+bean);
	}

	@Test
	public void test() {
		Globals bean = ApplicationContextHolder.context.getBean(Globals.class);
		System.out.println(bean);
		bean.setUrl("google.com");


		bean = ApplicationContextHolder.context.getBean(Globals.class);
		System.out.println(bean);
	}
}
