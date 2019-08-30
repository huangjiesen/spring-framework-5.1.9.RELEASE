package com.sen.learn;

import com.sen.learn.config.AppConfig;
import com.sen.learn.dao.CatDao;
import com.sen.learn.dao.DogDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author HuangJS
 * @date 2019-08-28 5:50 PM
 */
public class IocApp {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DogDao dogDao = context.getBean(DogDao.class);
		dogDao.query("二哈", 10);
		System.out.println();
		dogDao.query("小哈", 10);

		System.out.println();
		CatDao catDao = context.getBean(CatDao.class);
		catDao.select("tomo",22);
	}
}
