package com.abc.dao.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import  java.util.Date;
@Data

@NoArgsConstructor
public class Emp {
    private  int empno;
    private  String ename;
    private  Date hiredate;
    private  BigDecimal sal;

    public Emp(int empno,String ename, Date hiredate, BigDecimal sal) {
        this.empno=empno;
        this.ename = ename;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }
}
