# 1、Spring

## 1.1 简介

- Spring：春天，给软件行业带来了春天！
- 2002，首次推出了Spring框架的雏形：interface21框架
- Spring框架以interface21框架为基础，经过重新设计，并不断丰富其内涵，于2004年3月24日，发布了1.0正式版本。
- Rod Johnson，Srping FrameWork创始人，著名作者。很难想象Rod Johnson的学历？他是悉尼大学的博士，然而他的专业不是计算机，而是音乐学
- Spring理念：使现有的技术更加容易使用，本身是一个大杂烩，整合了现有的技术框架！
- SSH：Struct2+Spring+Hibernate
- SSM：SpringMVC+Spring+Mybatis

官网：https://spring.io/projects/spring-framework#overview

官网下载地址：https://repo.spring.io/release/org/springframework/spring/

GitHub:https://github.com/spring-projects/spring-framework

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

## 1.2 优点

- spring是一个免费的开源的框架（容器）
- spring是一个轻量级的、非入侵式的框架
- 控制反转（IOC），面向切面编程（AOP）
- 支持事务的处理，对框架整合的支持

总结一句话：Spring就是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架！

## 1.3 组成

<img src="/Users/liangzhengtao/Library/Application Support/typora-user-images/image-20201217174109765.png" alt="image-20201217174109765" style="zoom:50%;" />

## 1.4 拓展

在Spring的官网中有这个介绍：现代化的java开发，说白就是基于spring的开发

<img src="/Users/liangzhengtao/Desktop/截屏2020-12-17 下午5.42.43.png" alt="截屏2020-12-17 下午5.42.43" style="zoom:50%;" />

- Sprint Boot
  - 一个快速开发的脚手架
  - 基于SpringBoot可以快速的开发单个微服务
  - 约定大于配置
- Spring Cloud
  - SpringCloud是基于SpringBoot实现的

因为现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提，需要完全掌握Spring及SpringMVC！承上启下的作用

**弊端：发展了太久之后，违背了原来的理念！配置十分繁琐，人称“配置地狱”！**

# 2、IOC理论指导

1、UserDao接口

2、UserDaoImpl实现类

3、UserService业务接口

4、UserServiceImpl业务实现类

在我们之前的业务中，用户的需求可能会影响我们原来的代码，我们需要根据用户的需求去修改原代码，如果程序代码量十分大，修改一次的成本代价十分昂贵！

```java
    private UserDao userDao = new UserDaoSqlserverImpl();
```



我们使用一个Set接口实现。已经发生了革命性的变化！！！

```java
    private UserDao userDao;

    //利用set进行动态实现值的注入；
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
```

- 之前，程序是主动创建对象！控制权在程序员手上
- 使用set注入后，程序不在具有主动性，而是变成了被动接受对象！

这种思想，从本质上解决了问题，我们程序员不用再去管理对象的创建了。系统的耦合性大大降低，可以更加专注的在业务的实现上！这是IOC的原型！



