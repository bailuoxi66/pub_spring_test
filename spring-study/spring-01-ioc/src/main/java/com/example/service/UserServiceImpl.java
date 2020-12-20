package com.example.service;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import com.example.dao.UserDaoMysqlImpl;
import com.example.dao.UserDaoOracleImpl;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/19 11:50 上午
 * @desc
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //利用set进行动态实现值的注入；
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
