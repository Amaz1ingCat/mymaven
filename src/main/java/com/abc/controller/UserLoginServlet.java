package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.User;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = { "/UserLoginServlet", "/login" })
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        resp.setContentType("text/plain");
        response.setContentType("application/json"); //定义为JSON类型
        //取值
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        //处理

        User user = new User(username,password);
        IUserService userService = (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res<User> res = userService.login(user);
        HttpSession session =request.getSession();
        session.setAttribute(Comm.CURRENT_USER,res.getData());
        //反馈
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //调用了类库fastjson
        Object resJson = JSON.toJSONString(res);
        System.out.println(resJson);
        out.println(resJson);
        out.close();

    }


}
