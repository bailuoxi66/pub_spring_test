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

<img src="/Users/liangzhengtao/Library/Application Support/typora-user-images/image-20201221105814073.png" alt="image-20201221105814073" style="zoom:50%;" />

我们使用一个Set接口实现。已经发生了革命性的变化！！！

```java
    private UserDao userDao;

    //利用set进行动态实现值的注入；
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
 		}
```

```java
				//用户实际调用的是业务层，dao层不需要直接接触！
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoSqlserverImpl());

        userService.getUser();
```



<img src="/Users/liangzhengtao/Library/Application Support/typora-user-images/image-20201221105934393.png" style="zoom:50%;" />

- 之前，程序是主动创建对象！控制权在程序员手上
- 使用set注入后，程序不在具有主动性，而是变成了被动接受对象！

这种思想，从本质上解决了问题，我们程序员不用再去管理对象的创建了。系统的耦合性大大降低，可以更加专注的在业务的实现上！这是IOC的原型！

## 2.1 IOC本质

**控制反转IoC(Inversion of Control)，是一种设计思想，DI(依赖注入)是实现IoC的一种方法**，也有人认为DI只是IoC的另一种说法。没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，个人认为所谓控制反转就是：获得依赖对象的方式反转了。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3S3REaWFPcUZ5NW91cmxKOEZUVlYyRkZ1WWlibWF2bEJIcTllNGNEcWljbHBZU0c4VlQ0RWljVnNucUtwNjV5SktRZU5pYnNWZFRpYWhRaWJKU2cvNjQw?x-oss-process=image/format,png)

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

**控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection,DI）**

# 3、HelloSpring

思考问题？

- Hello对象是谁创建的？ Spring创建

- Hello对象的属性是怎么设置的？ 属性是由Spring容器设置的

```xml
<!--    使用Spring来创建对象，在Spring这些都称为Bean

    类型 变量名= new 类型();
    Hello hello = new Hello();
    id = 变量名
    class = 类型
    property 相当于给对象中的属性设置一个值！
    -->

    <bean id="hello" class="com.example.pojo.Hello">
        <property name="str" value="Spring"/>
    </bean>
```

这个过程就叫控制反转：

控制：谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的

反转：程序本身不创建对象，而变成被动的接收对象

依赖注入：就是利用set方法进行注入的

IOC是一种编程思想，由主动的编程变成被动的接收

可以通过newClassPathXmlApplicationContext去浏览一下底层源码。

<img src="/Users/liangzhengtao/Library/Application Support/typora-user-images/image-20201221150906793.png" alt="image-20201221150906793" style="zoom:50%;" />

Ok！到了现在，我们彻底不用再去程序中改动去了，要实现不同的操作，只需要在xml配置文件中进行修改，所谓的IoC，一句话搞定：对象由Spring来创建，管理，装配

```java
    <bean id="mysqlImpl" class="com.example.dao.UserDaoMysqlImpl"/>
    <bean id="oracleImpl" class="com.example.dao.UserDaoOracleImpl"/>
    <bean id="SqlserverImpl" class="com.example.dao.UserDaoSqlserverImpl"/>

    <bean id="UserServiceImpl" class="com.example.service.UserServiceImpl">
<!--        ref: 引用Spring容器中创建好的对象-->
<!--        val: 具体的值，如：基本类型-->
        <property name="userDao" ref="SqlserverImpl"/>
    </bean>
```

# 4、IOC创建对象的方式

1、使用无参构造创建对象，默认！

2、假设我们使用有参构造创建对象

- 下标赋值

```java
    <bean id="user" class="com.example.pojo.User">
        <constructor-arg index="0" value="小白和小鱼"/>
    </bean>
```

- 类型(不建议使用)

```java
    <bean id="user" class="com.example.pojo.User">
        <constructor-arg type="java.lang.String" value="小白"/>
    </bean>
```

- 参数名

```java
    <bean id="user" class="com.example.pojo.User">
        <constructor-arg name="name" value="小鱼"/>
    </bean>
```

总结：在配置文件加载的时候，容器中管理的对象就已经初始化了

# 5、Spring配置

## 5.1 别名

```xml
<!--    别名，如果添加了别名，我们也可以使用别名获取到这个对象-->
    <alias name="user" alias="userNew"/>
```

## 5.2 Bean的配置

```java
<!--
    id: bean的唯一标示符，也就是相当于我们学的对象名
    class：bean对象所对应的全限定名：包名+类型
    name：也是别名,而且name 可以同时取多个别名,允许使用多种分隔符进行分割
-->
    <bean id="userT" class="com.example.pojo.UserT" name="user2,u2 u3;u4">
        <property name="name" value="哈哈哈"/>
    </bean>
```

## 5.3 import

这个import，一般用于团队开发使用，他可以将多个配置文件，导入合并为一个

假设，现在项目中有多个人开发，这三个人复制不同的类的开发，不同的类需要注册在不同的bean中，我们可以利用import将其合并

```xml
    <import resource="beans.xml"/>
    <import resource="beans2.xml"/>
    <import resource="beans3.xml"/>
```

总的是：applicationContext.xml

# 6、依赖注入

## 6.1、构造器注入

前面已经讲过

## 6.2、Set方式注入【重点】

- 依赖注入：Set注入！
  - 依赖：bean对象的创建依赖于容器！
  - 注入：bean对象中的所有属性，由容器来注入！

【环境搭建】

1. 普通类型

   ```java
   public class Address {
       private String address;
   }
   ```

2. 复杂类型

   ```java
   public class Student {
       private String name;
       private Address address;
       private String[] books;
       private List<String> hobby;
       private Map<String, String> card;
       private Set<String> games;
       private String wife;
       private Properties info;
   }
   ```

3. beans.xml

   ```xml
       <bean id="student" class="com.example.pojo.Student">
           <!--第一种，普通注入-->
           <property name="name" value="小白"/>
       </bean>
   ```

4. 测试

   ```java
   public class MyTest {
       public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
           Student student = (Student) context.getBean("student");
           System.out.println(student.getName());
       }
   }
   ```

5、完善注入信息

```xml
    <bean id="address" class="com.example.pojo.Address">
        <property name="address" value="西安"/>
    </bean>

    <bean id="student" class="com.example.pojo.Student">
        <!--value-->
        <property name="name" value="小白"/>

        <!--ref-->
        <property name="address" ref="address"/>

        <!--数组-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
                <value>三国演义</value>
            </array>
        </property>

        <!--list-->
        <property name="hobby">
            <list>
                <value>听歌</value>
                <value>敲代码</value>
                <value>看电影</value>
            </list>
        </property>

        <!--Map-->
        <property name="card">
            <map>
                <entry key="身份证" value="123121212121212"/>
                <entry key="银行卡" value="12928372919893839"/>
            </map>
        </property>

        <!--Set-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>COC</value>
                <value>BOB</value>
            </set>
        </property>

        <!--null-->
        <property name="wife">
            <null/>
        </property>

        <!--Properties-->
        <property name="info">
            <props>
                <prop key="driver">20190526</prop>
                <prop key="url">男</prop>
                <prop key="username">root</prop>
                <prop key="password">12345666</prop>
            </props>
        </property>
    </bean>
```

## 6.3、拓展注入

https://docs.spring.io/spring-framework/docs/4.3.30.RELEASE/spring-framework-reference/htmlsingle/#beans

<img src="/Users/liangzhengtao/Library/Application Support/typora-user-images/image-20201227113552911.png" alt="image-20201227113552911" style="zoom:50%;" />

使用：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入，可以直接注入简单属性：property-->
    <bean id="user" class="com.example.pojo.User" p:name="小白" p:age="18"/>

    <!--c命名空间注入，通过构造器注入：construct-args-->
    <bean id="user2" class="com.example.pojo.User" c:age="18" c:name="小白白"/>
</beans>
```

测试：

```java
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);

        System.out.println(user);
    }
```

注意点：p命名和c命名不能直接输入，需要导入依赖

       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"