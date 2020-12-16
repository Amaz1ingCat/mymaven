package com.abc.common;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

public class 转账 {
    public static void main(String[] args) throws Exception {
        //在数据库中已经定义好了 转账的存储过程 ,这里直接调用就好
        Connection connection = DBUtil.getConnection();
        String sql="call proc_transfer_money1(?,?,?)";

        //调用存储过程
        CallableStatement ct = connection.prepareCall(sql);
        ct.setString(1,"FORD");
        ct.setString(2,"MILLER");
        ct.setBigDecimal(3,new BigDecimal(2000));
        ct.executeUpdate();
        DBUtil.close(null,ct,connection);


    }
}
