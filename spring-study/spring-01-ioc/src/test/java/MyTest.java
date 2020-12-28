import com.example.config.BaiConfig;
import com.example.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/26 11:16 上午
 * @desc
 */
public class MyTest {
    @Test
    public void test1(){
        //如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象进行加载
        ApplicationContext  context = new AnnotationConfigApplicationContext(BaiConfig.class);
        User getUser = (User) context.getBean("getUser");

        System.out.println(getUser.getName());
    }
}
