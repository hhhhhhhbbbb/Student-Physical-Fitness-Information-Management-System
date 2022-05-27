<%--
  Created by IntelliJ IDEA.
  User: 28939
  Date: 24/4/2022
  Time: 上午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>条件查询信息页面</title>
</head>
<body>
<form action="find" method="post">
    <table border="0" width="238" height="252">
        <tr><td>学号</td><td><input type="text" name="id"></td></tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="查  询"> &nbsp;&nbsp;&nbsp;
                <input type="reset" value="取  消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
