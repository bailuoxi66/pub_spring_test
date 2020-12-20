import com.example.dao.UserDaoMysqlImpl;
import com.example.dao.UserDaoOracleImpl;
import com.example.dao.UserDaoSqlserverImpl;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

/**
 * @author <a href="mailto:liangzhengtao.lzt@lazada.com">liangzhengtao.lzt</a>
 * @version 1.0
 * @date 2020/12/20 10:58 上午
 * @desc
 */
public class MyTest {
    public static void main(String[] args) {

        //用户实际调用的是业务层，dao层不需要直接接触！
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoSqlserverImpl());

        userService.getUser();
    }
}
