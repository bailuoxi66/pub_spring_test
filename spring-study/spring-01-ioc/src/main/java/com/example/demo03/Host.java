package com.example.demo03;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/29 12:20 上午
 * @desc
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要租房子！");
    }
}
