package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//1.
//第一顶层servlet 获得前端传来的值
//保存对值进行处理
//进行反馈

@WebServlet(urlPatterns = {"/UserExistServlet","/userexist"})
public class UserExistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取值
        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/plain");
        resp.setContentType("application/json");

        String username = req.getParameter("username");

        //处理

        //必然有一个IUserService对值进行处理
        //建立一个ServiceFactory 实现分配对应的实现类
        IUserService userService = (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res res =userService.userExist(username);

        //反馈
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String resJson = JSON.toJSONString(res); //JSON转换
        System.out.println(resJson);
        out.println(resJson);
        out.close();
    }
}
