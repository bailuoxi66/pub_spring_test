package com.example.demo02;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/29 1:13 上午
 * @desc
 */
public class UserServiceImpl implements UserService{
    public void add() {
        System.out.println("add了一个用户");
    }

    public void delete() {
        System.out.println("delete了一个用户");
    }

    public void update() {
        System.out.println("update了一个用户");
    }

    public void query() {
        System.out.println("query了一个用户");
    }

    //改动原有的代码，在公司是大忌
}
