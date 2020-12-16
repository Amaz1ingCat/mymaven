package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.User;

//4.

//创建IService层
//该层为接口

//Service永远只有一个返回值,则为之再Common中定义的对象类 Res
public interface IUserService {
   Res userExist(String username);  //创建方法,传参 该方法会被会被工厂所返回对应的实现类使用

    Res<User> login(User user);
}
