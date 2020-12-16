package com.abc.dao.idao;

//6.


//创建Idao 层接口
//定义方法让 Daoimpl实现类进行实现

import com.abc.dao.entity.User;

public interface IUserDao {
     int exist(String username)throws  Exception;

    User login(User user) throws  Exception;
}
