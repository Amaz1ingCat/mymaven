package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.User;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IUserDao;
import com.abc.service.iservice.IUserService;

//5.

//创建所对应的实现类
//这里需要引入dao层


public class UserServiceImpl implements IUserService {
    IUserDao userDao;

    public UserServiceImpl() {
        //分配方法写再无参构造器里,不用调用也可以直接执行
        //跟service一样,dao层也需要一个工厂来放分配实现类
      userDao=(IUserDao) DaoFactory.getInstance(Comm.USER);
    }

    @Override
    public Res userExist(String username) {
        //Dao层已经写完sql语句
        //因为该为判断用户民是否存在,所以返回一个flag来表明用户名是否存在
        int flag = 0;
        try {
            flag  = userDao.exist(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(flag);
        return  flag>0?Res.success(ResEnum.SUCCESS_USER_EXIST):Res.error(ResEnum.ERROR_USER_EXIST);
    }

    @Override
    public Res<User> login(User user) {
        User result = null;
        try{
            result = userDao.login(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (result!=null){
            result.setPassword("");
            return Res.success(ResEnum.SUCCESS,result);
        }
        return Res.error(ResEnum.ERROR);
    }

    //实现IServiece层的方法,并把赢实现的功能写入里边


}
