package com.abc.ssm.spring;

import org.springframework.stereotype.Repository;

@Repository
//默认为@Repository("personDao")
public class PersonDao {
    public void print(){
        System.out.println("最强程序员啊");
    }
}
