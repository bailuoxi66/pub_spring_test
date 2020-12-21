import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/20 10:58 上午
 * @desc
 */
public class MyTest {
    public static void main(String[] args) {

        //获取ApplicationContext：拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //容器在手，天下我有，需要什么，就直接get什么！
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();

//        //获取Spring的上下文对象！
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        //我们的对象现在都在Spring中管理了，我们要使用，直接去里面取出来就可以了
//        Hello hello = (Hello) context.getBean("hello");
//        System.out.println(hello.toString());
    }
}
