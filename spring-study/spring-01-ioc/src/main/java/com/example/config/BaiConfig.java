package com.example.config;

import com.example.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/28 8:53 下午
 * @desc
 */

//这个也会被Spring容器托管，注册到容器中，因为他本来就是一个@Component
//也代表这是一个配置类，就和我们之前看的beans.xml一样
@Configuration
@ComponentScan("com.example.pojo")
@Import(BaiConfig2.class)
public class BaiConfig {

    //注册一个bean，就相当于我们之前写的一个bean标签
    //这个方法的名字，就相当于bean标签中的id属性
    //这个方法的返回值，就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();   //就是返回注入到bean的对象！！！
    }
}
