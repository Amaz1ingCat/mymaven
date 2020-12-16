package com.abc.dao.impl;

import com.abc.dao.entity.Dept;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IDeptDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDapImpl implements IDeptDao {
    @Override
    public List<Dept> findAll() throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "select dname,deptno from dept";

        PreparedStatement pst= con.prepareStatement(sql);

        ResultSet set = pst.executeQuery();
        List<Dept> depts = new ArrayList<Dept>();
        while (set.next()){
            Dept dept = new Dept();
            dept.setDeptno(set.getInt(2));
            dept.setDname(set.getString(1));
            depts.add(dept);
        }
        DBUtil.close(set,pst,con);
        return depts;
    }
}
