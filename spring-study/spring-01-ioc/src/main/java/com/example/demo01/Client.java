package com.example.demo01;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/29 12:21 上午
 * @desc
 */
public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //代理，中介帮房东找人，但是呢？代理角色一般会有一些附加操作
        Proxy proxy = new Proxy(host);

        //用户不用面对房东，直接找中介租房子
        proxy.rent();
    }
}
