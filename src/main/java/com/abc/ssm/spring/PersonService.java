package com.abc.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@Service("personService")
public class PersonService {
    @Autowired
    //自动扫描生成get set
    private PersonDao personDao;
    public void print(){
        personDao.print();
    }


}
