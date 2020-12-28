package com.example.demo01;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/29 12:23 上午
 * @desc
 */
public class Proxy implements Rent{
    Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        seeHouse();
        this.host = host;
        hetong();
        fare();
    }

    public void rent() {
        host.rent();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带看房子！");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费！");
    }

    //签合同
    public void hetong(){
        System.out.println("签租赁合同！");
    }
}
