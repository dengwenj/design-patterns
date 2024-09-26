package vip.dengwj2.dao.impl;

import vip.dengwj2.dao.UserDao;

public class UserDaoImpl implements UserDao {
    // 依赖注入
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void add() {
        System.out.println("UserDaoImpl..." + " -> " + username + " -> " + password);
    }
}
