import com.cn.kg.entity.User;
import com.cn.kg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: mvc-template
 * @description: TODO
 * @author: konggang
 * @create: 2019-11-02 01:03
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@Slf4j
public class BastTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){

//        List<User> users = userService.list();
//        users.forEach(o-> log.info(o.toString()));
        User user = userService.getById(1);
        log.info(user.toString());
    }

}
