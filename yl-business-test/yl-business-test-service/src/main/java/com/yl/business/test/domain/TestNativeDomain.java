package com.yl.business.test.domain;

import com.yl.business.test.bo.UserBo;
import com.yl.business.test.model.User;
import com.yl.business.test.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoliao on 2017/7/23.
 */
@Service("testDomain")
public class TestNativeDomain implements TestDomain{

    @Resource
    private TestService testService;

    public void save() {
        User user = new User();
        user.setName("Rose");
        user.setAge(21);
        Integer save = testService.save(user);
    }

    public UserBo get(Integer ID) {
        User user = testService.get(ID);
        UserBo userBo = new UserBo();
        userBo.setAge(user.getAge());
        userBo.setId(user.getId());
        userBo.setName(user.getName());
        return userBo;
    }
}
