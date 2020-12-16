package com.abc.dao.idao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import java.util.List;

public interface IEmpDao {
    List<Emp> finByPage(int start,int size) throws Exception;
    List<Emp> finByName(String ename) throws Exception;
    Emp finById(Integer empno) throws Exception;


    void delete(Emp emp) throws  Exception;
    void save(Emp emp) throws  Exception;
    void update(Emp emp) throws  Exception;

    void delBatch(List<DelVO> delVOList) throws Exception;
}
