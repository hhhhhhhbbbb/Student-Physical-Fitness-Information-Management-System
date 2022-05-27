<%--
  Created by IntelliJ IDEA.
  User: 28939
  Date: 24/4/2022
  Time: 上午10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>删除信息提页面</title>
</head>
<body>
<form action="delete" method="post">
    <table border="0" width="238" height="252">
        <tr><td>姓名</td><td><input type="text" name="name"></td></tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="删  除"> &nbsp;&nbsp;&nbsp;
                <input type="reset" value="取  消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
