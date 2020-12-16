package com.abc.dao.impl;

import com.abc.dao.entity.User;
import com.abc.dao.idao.IUserDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//8

//创建Daoimpl 实现层
//该层主要负责与数据库的操作
//连接数据库
//将数据库语句写入并接收返回值

public class UserDaoImpl implements IUserDao {


    @Override
    public int exist(String username) throws Exception {
        //DBUtil 实现数据库的连接

        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "select count(1) from user where username=?";
//        String sql = "select count(1) from user ";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.setString(1,username);
        ResultSet set = pst.executeQuery();
        int flag= 0 ;
        if (set.next()){
            flag = set.getInt(1);

        }
        DBUtil.close(set,pst,con);
        //返回flag 根据flag的值来判定用户名是否存在
        return flag;
    }

    @Override
    public User login(User user) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "SELECT id,username,password,pri FROM user where username=? and password=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,user.getUsername());
        ps.setObject(2,user.getPassword());
        ResultSet rs = ps.executeQuery();
        User result = null;
        if (rs.next()){
            result = new User(rs.getInt(1),rs.getString(2)
                    ,rs.getString(3),rs.getInt(4));
        }
        DBUtil.close(rs,ps,con);
        return result;
    }
}
