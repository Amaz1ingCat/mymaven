package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class DeptServiceImpl implements IDeptService {
    IDeptDao iDeptDao;

    public DeptServiceImpl() {
        iDeptDao = (IDeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts =  iDeptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(depts.size()>0){
            return Res.success(ResEnum.SUCCESS,depts);
        }else {
            return Res.error();
        }
    }
}
