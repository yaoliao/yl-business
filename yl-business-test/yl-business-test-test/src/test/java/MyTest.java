import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.yl.business.test.domain.TestDomain;
import com.yl.business.test.model.User;
import com.yl.business.test.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        registry.setAddress("zookeeper://127.0.0.1:2181");
        ReferenceConfig<T> reference = new ReferenceConfig<T>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能�?�成内存和连接泄�?
        reference.setInterface(clazz);
        reference.setVersion("1.0.0.0");
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

}
