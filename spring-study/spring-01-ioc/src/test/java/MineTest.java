import com.example.pojo.User;
import com.example.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/24 11:04 上午
 * @desc
 */
public class MineTest {
    public static void main(String[] args) {
        //Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserT user = (UserT) context.getBean("u5");
        user.show();
    }
}
