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

//这里这个注解的意思，就是说明这个类被Spring接管了，注册到了容器中
@Component
public class User {

    public String name;

    public String getName() {
        return name;
    }

    //属性注入值
    @Value("小白白")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
