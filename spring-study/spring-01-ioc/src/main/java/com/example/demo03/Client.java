package com.example.demo03;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/29 12:21 上午
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色，现在没有
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象
        pih.setRent(host);
        //这里的proxy就是动态生成的，我们并没有实现
        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
    }
}
