package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    IUserService userService;
    private static Logger log = Logger.getLogger(UserServiceImplTest.class);
    @BeforeEach
    void setUp() {
        userService = (IUserService) ServiceFactory.getInstance(Comm.USER);
    }

    @Test
    void userExist() {
        Res res = userService.userExist("root");
        log.info("************************"+res);
    }
}