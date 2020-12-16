package com.abc.dao.factory;

import com.abc.common.Comm;
import com.abc.dao.idao.IUserDao;
import com.abc.dao.impl.DeptDapImpl;
import com.abc.dao.impl.DeptEmpDaoImpl;
import com.abc.dao.impl.EmpDaoImpl;
import com.abc.dao.impl.UserDaoImpl;
import com.abc.service.impl.EmpServiceImpl;
import com.abc.service.impl.UserServiceImpl;


//7.

//创建dao factory,分配dao的实现类
//原理和service factory一样
public class DaoFactory {
    public static Object getInstance(String daoName) {
        switch (daoName){
            case  Comm.USER:
                return new UserDaoImpl();
            case Comm.EMP:
                return  new  EmpDaoImpl();
            case Comm.DEPT:
                return  new DeptDapImpl();
            case Comm.DEPT_EMP_REPORT:
                return  new DeptEmpDaoImpl();

            default:
                return null;
        }
    }
}


