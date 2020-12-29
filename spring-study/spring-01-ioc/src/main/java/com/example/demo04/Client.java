package com.example.demo04;

import com.example.demo02.UserService;
import com.example.demo02.UserServiceImpl;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/30 1:33 上午
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);
        //生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.add();
    }
}
