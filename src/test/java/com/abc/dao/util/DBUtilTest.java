package com.abc.dao.util;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    @org.junit.jupiter.api.Test
    void getConnection() throws Exception {
        Connection con = DBUtil.getConnection();
        System.out.println(con);
    }
}