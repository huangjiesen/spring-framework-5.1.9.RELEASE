package com.sen.learn;

import com.sen.learn.config.AppConfig;
import com.sen.learn.dao.DogDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author HuangJS
 * @date 2019-08-28 5:50 PM
 */
public class IocApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DogDao dogDao = context.getBean(DogDao.class);
		System.out.println("save result:" + dogDao.save("name", 33));

		//CatDao bean = context.getBean(CatDao.class);
		//bean.save("tomo",2);
	}
}
