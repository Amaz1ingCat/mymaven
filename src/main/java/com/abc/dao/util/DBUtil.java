package com.abc.dao.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


//9.

//创建Util 层
//建议与数据库的连接
public class DBUtil {
    //这里使用了连接池
    private  static DataSource ds = new ComboPooledDataSource("dao_c3p0");

    public  static  DataSource getDs(){
        return  ds;
    } //这里使用一个单例模式


    public  static Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");//类反射 让mysql的驱动启动起来
        return  ds.getConnection();
    }

    public  static  void  close(ResultSet set, Statement pst, Connection con) throws  Exception{
        if (set!=null) set.close();
        if (pst!=null) pst.close();
        if (con!=null) con.close();
    }
}
