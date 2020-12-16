package com.abc.service.factory;

import com.abc.common.Comm;
import com.abc.dao.impl.DeptDapImpl;
import com.abc.service.impl.DeptEmpServiceImpl;
import com.abc.service.impl.DeptServiceImpl;
import com.abc.service.impl.EmpServiceImpl;
import com.abc.service.impl.UserServiceImpl;


//3.

//创建ServiceFactory 根据Comm接口类传来的数值,给IService返回对应的实现类
public class ServiceFactory {
    public  static  Object getInstance(String serviceName){
        //如果表的数量多 , 用switch来分发
        //少则用如果
        switch (serviceName){
            case  Comm.USER:
                return new UserServiceImpl();

            case Comm.EMP:
                return new EmpServiceImpl();
            case Comm.DEPT:
                return new DeptServiceImpl();
            case Comm.DEPT_EMP_REPORT:
                return new DeptEmpServiceImpl();


            default:
                return null;
        }


    }
}
