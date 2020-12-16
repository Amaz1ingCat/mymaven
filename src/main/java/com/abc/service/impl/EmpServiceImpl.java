package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IEmpDao;
import com.abc.service.iservice.IEmpService;
import com.abc.service.iservice.IUserService;

import java.util.List;

public class EmpServiceImpl implements IEmpService {
    IEmpDao empDao;

    public EmpServiceImpl() {
        empDao = (IEmpDao) DaoFactory.getInstance(Comm.EMP);
    }

    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> emps = null;
        try {

                emps =empDao.finByPage((page-1)*size,size);

        }catch (Exception e){
            e.printStackTrace();
        }

        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) {
        List<Emp> emps = null;
        try {

            emps =empDao.finByName(ename);

        }catch (Exception e){
            e.printStackTrace();
        }

        return emps;
    }

    @Override
    public Emp findById(Integer empno) {
       Emp emps = null;
        try {

            emps =empDao.finById(empno);

        }catch (Exception e){
            e.printStackTrace();
        }

        return emps;
    }

    @Override
    public String delete(Emp emp) {
        String msg=Comm.ERROR; //默认返回错误
        try {
            empDao.delete(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String svae(Emp emp) {
        String msg=Comm.ERROR; //默认返回错误
        try {
            empDao.save(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Emp emp) {
        String msg=Comm.ERROR; //默认返回错误
        try {
            empDao.update(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Res delBatch(List<DelVO> delVOList) {
        if (delVOList==null || delVOList.size()==0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }

        try {
            empDao.delBatch(delVOList);
            return Res.success(ResEnum.SUCCESS_DEL_BATCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Res.error();
    }


}
