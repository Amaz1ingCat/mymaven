<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2020/12/2
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
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
</head>
<body>
<table  id="empsInfo">

    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>入职日期</td>
        <td>薪水</td>
    </tr>
</table>
<script src="jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="first.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
