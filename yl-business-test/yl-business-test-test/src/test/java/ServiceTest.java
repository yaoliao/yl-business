import com.yl.business.test.model.User;
import com.yl.business.test.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yaoliao on 2017/7/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
//@ContextConfiguration(locations={"file:yl-business-center/target/yl-business-center/WEB-INF/classes/applicationContext.xml"})
public class ServiceTest {

    @Resource
    private TestService testService;

    @Test
    public void save() {
        User user = new User();
        user.setName("jack");
        user.setAge(233);
        Integer save = testService.save(user);
        System.out.println(save);
    }

    @Test
    public void get() {
        User user = testService.get(1);
        System.out.println(user.getName());
    }

}
