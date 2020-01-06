package com.sen.service;

import com.sen.dao.UserDao;

/**
 * @author HuangJS
 * @date 2020-01-06 2:30 下午
 */
public class UserService {
    private UserDao userDao;
    private UserDao sssss;

    public void setSssss(UserDao sssss) {
        this.sssss = sssss;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("com.sen.service.UserService:save user info");
        userDao.save();

        System.out.println("----sssss");
        sssss.save();
    }
}
