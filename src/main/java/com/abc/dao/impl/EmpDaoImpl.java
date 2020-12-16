package com.abc.dao.impl;

import com.abc.common.Comm;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.idao.IUserDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {


    @Override
    public List<Emp> finByPage(int start, int size) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "select empno,ename,hiredate,sal from emp limit ?,?";

        PreparedStatement pst= con.prepareStatement(sql);
        pst.setInt(1,start);
        pst.setInt(2,size);
        ResultSet set = pst.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (set.next()){
            Emp emp = new Emp(set.getInt(1),set.getString(2)
                    ,set.getDate(3),set.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(set,pst,con);
        //返回flag 根据flag的值来判定用户名是否存在
        System.out.println(emps);
        return emps;
    }

    @Override
    public List<Emp> finByName(String ename) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "select empno,ename,hiredate,sal from emp where ename like ?";

        PreparedStatement pst= con.prepareStatement(sql);
        pst.setString(1,"%"+ename+"%");
        ResultSet set = pst.executeQuery();
        List<Emp> emps = new ArrayList<Emp>();
        while (set.next()){
            Emp emp = new Emp(set.getInt(1),set.getString(2)
                    ,set.getDate(3),set.getBigDecimal(4));
            emps.add(emp);
        }
        DBUtil.close(set,pst,con);
        //返回flag 根据flag的值来判定用户名是否存在
        System.out.println(emps);
        return emps;
    }

    @Override
    public Emp finById(Integer empno) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "select empno,ename,hiredate,sal from emp where empno = ?";

        PreparedStatement pst= con.prepareStatement(sql);
        pst.setInt(1,empno);
        ResultSet set = pst.executeQuery();
        Emp emps =new Emp();
        while (set.next()){
             emps = new Emp(set.getInt(1),set.getString(2)
                    ,set.getDate(3),set.getBigDecimal(4));

        }
        DBUtil.close(set,pst,con);
        //返回flag 根据flag的值来判定用户名是否存在
        System.out.println(emps);
        return emps;
    }

    @Override
    public void delete(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "delete FROM emp where  empno=?";

        PreparedStatement pst= con.prepareStatement(sql);
        pst.setInt(1,emp.getEmpno());
        pst.executeUpdate();
        DBUtil.close(null,pst,con);

    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "insert into emp(empno,ename,hiredate,sal) values(?,?,?,?)";
        PreparedStatement pst= con.prepareStatement(sql);
        pst.setInt(1,emp.getEmpno());
        pst.setString(2,emp.getEname());
        pst.setDate(3,new java.sql.Date(emp.getHiredate().getTime()));
        pst.setBigDecimal(4,emp.getSal());
        pst.executeUpdate();
        DBUtil.close(null,pst,con);

    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con = DBUtil.getConnection();

        //写入sql语句
        String sql = "update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement pst= con.prepareStatement(sql);

        pst.setString(1,emp.getEname());
        pst.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        pst.setBigDecimal(3,emp.getSal());
        pst.setInt(4,emp.getEmpno());
        pst.executeUpdate();
        DBUtil.close(null,pst,con);
    }


    //事务
    @Override
    public void delBatch(List<DelVO> delVOList) throws Exception {

        //方案1,动态SQL语句拼接
        Connection con = DBUtil.getConnection();
        StringBuilder  builder = new StringBuilder("delete from emp where empno in (");
        for (int i = 0 ; i< delVOList.size();i++){
            if(i == delVOList.size()-1){
                builder.append(delVOList.get(i).getEmpno()+")");

            }
            else {
                builder.append(delVOList.get(i).getEmpno()+",");
            }
        }
        String sql = builder.toString();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate();
        DBUtil.close(null,pst,con);


        //方案2,批处理
//        Connection con = DBUtil.getConnection();
//        con.setAutoCommit(false); //关闭自动提交功能
//
//        Statement ps = con.createStatement();
//        try {
//            for (DelVO dv:delVOList){
//                String sql = "delete from emp where empno="+dv.getEmpno();
//                //获取所有要删除的sql语句
//                //存入到addBatch中,进行批处理
//                ps.addBatch(sql);
//            }
//            ps.executeBatch();
//            con.commit(); //如果执行成功,手动提交
//
//        }catch (Exception e){
//            e.printStackTrace();
//            con.rollback(); //执行批处理时出现异常,数据库回滚
//        }
//
//
//        DBUtil.close(null,ps,con);
    }
}
