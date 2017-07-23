package com.yl.business.test.service;

import com.yl.business.test.mapper.UserMapper;
import com.yl.business.test.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yaoliao on 2017/7/23.
 */
@Service
public class TestService {

    @Resource
    private UserMapper testMapper;

    public Integer save(User t) {
        int insert = testMapper.insertSelective(t);
        return insert;
    }

    public User get(Integer id) {
        User user = testMapper.get(id);
        return user;
    }

}
