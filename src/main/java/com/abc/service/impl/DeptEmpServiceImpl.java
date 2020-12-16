package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DeptEmpVO;
import com.abc.dao.entity.Dept;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IReportDao;
import com.abc.service.dto.DeptEmpDTO;
import com.abc.service.iservice.IDeptService;
import com.abc.service.iservice.IReportService;

import java.util.List;

public class DeptEmpServiceImpl implements IReportService {
    IReportDao iReportDaol;

    public DeptEmpServiceImpl() {
        iReportDaol= (IReportDao) DaoFactory.getInstance(Comm.DEPT_EMP_REPORT);
    }


    @Override
    public Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO) {
        List<DeptEmpDTO> result = null;
        try {
            result = iReportDaol.makeReportForDeptEmp(deptEmpVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (result != null&& result.size()>0)?Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
