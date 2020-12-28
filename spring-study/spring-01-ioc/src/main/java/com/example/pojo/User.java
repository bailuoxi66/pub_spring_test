package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/28 8:04 下午
 * @desc
 */
//等价于<bean id="user" class="com.example.pojo.User"/>
//Component 组建

@Component
@Scope("prototype")
public class User {

    public String name;
    //相当于 <property name="name" value="xiaoyuer"/>
    @Value("xiaoyuer")
    public void setName(String name) {
        this.name = name;
    }
}
