package com.yl.business.test.domain;

import com.yl.business.test.bo.UserBo;

/**
 * Created by yaoliao on 2017/7/23.
 */
public interface TestDomain {

    void save();

    UserBo get(Integer ID);

}
