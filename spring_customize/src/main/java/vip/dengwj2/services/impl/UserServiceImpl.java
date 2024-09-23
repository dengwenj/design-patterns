package vip.dengwj2.services.impl;

import vip.dengwj2.dao.UserDao;
import vip.dengwj2.services.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserServiceImpl");
        userDao.add();
    }
}
