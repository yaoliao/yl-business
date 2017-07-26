import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yl.business.test.bo.UserBo;
import com.yl.business.test.domain.TestDomain;
import org.junit.Test;

/**
 * Created by yaoliao on 2017/7/23.
 */
public class MyTest {

//    @Autowired
//    private TestService testService;

    public <T> T getService(Class<T> clazz) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("testDomainTest");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://104.224.155.89:2181");
        ReferenceConfig<T> reference = new ReferenceConfig<T>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能�?�成内存和连接泄�?
        reference.setInterface(clazz);
        reference.setVersion("1.0");
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setProtocol("dubbo");
        return reference.get();
    }


    @Test
    public void save() {
        TestDomain testDomain = getService(TestDomain.class);
        testDomain.save();
    }

    @Test
    public void get() {
        TestDomain testDomain = getService(TestDomain.class);
        UserBo userBo = testDomain.get(1);
        System.out.println(userBo.getName());
    }

}
