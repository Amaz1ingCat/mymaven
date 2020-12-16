<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2020/12/2
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        table{

            border-radius: 4px;
            border-collapse: collapse;

        }
        td{
            width: 120px;
            height: 30px;
            text-align: center;
            border: 2px solid antiquewhite;

        }
        td:hover{
            box-shadow:3px 3px 5px lightblue;

        }
        tr:nth-child(even){
            background-color: skyblue;
        }
    </style>
	<link rel="stylesheet" type="text/css" href="js/bootstrap3.3.7.min.css"/>
</head>
<br>
<table  id="empsInfo" class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
		    <th>编号</th>
		    <th>姓名</th>
		    <th>入职日期</th>
		    <th>薪水</th>
		    <th>operation</th>
		</tr>
	</thead>
  <tbody>
  	<c:forEach items="${empsFromServer}" var="emp">
  	    <tr>
  	        <td>${emp.empno}</td>
  	        <td>${emp.ename}</td>
  	        <td>${emp.hiredate}</td>
  	        <td>${emp.sal}</td>
  	        <td><a href="${pageContext.request.contextPath}/empbyid?empno=${emp.empno}">修改</a>
  	            <a href="${pageContext.request.contextPath}/delete?empno=${emp.empno}"
  	                                  onclick="return confirm('111')" >删除</a></td>
  	    </tr>
  	</c:forEach>
  </tbody>
  
</table>
    <a href="${pageContext.request.contextPath}/newemp.jsp">新增</a>
<hr>
    <form action="${pageContext.request.contextPath}/empbyid" method="post">
        EMPNO:<input type="text" name="empno" placeholder="请输入员工编号">
        <input type="submit" value="精确查询">
    </form>
<hr>
<form action="${pageContext.request.contextPath}/empbyname" method="post">
    ENAME:<input type="text" name="ename" placeholder="请输入员工姓名">
    <input type="submit" value="模糊查询">
</form>
<script src="js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap3.3.7.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/emps.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
