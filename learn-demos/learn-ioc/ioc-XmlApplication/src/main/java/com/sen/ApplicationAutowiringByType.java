package com.sen;

import com.sen.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author HuangJS
 * @date 2020-01-06 2:28 下午
 */
public class ApplicationAutowiringByType {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowiring-by-type-spring.xml");
        //UserDao userDao = applicationContext.getBean(UserDao.class);

        UserService userService = applicationContext.getBean(UserService.class);
        userService.save();
    }

}
