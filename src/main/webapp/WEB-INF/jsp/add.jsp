<%--
  Created by IntelliJ IDEA.
  User: I_CAN_PLAY
  Date: 2018/5/10
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>新增内容</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}addlist" method="post">
        <h1 align="center">添加新的指令</h1>
        <table border="0" align="center">
            <tr>
                <td>指令名称：<br></td>
                <td><input type="text" name="command" width="400"></td>
            </tr>
            <tr>
                <td>指令描述：<br></td>
                <td><textarea  name="description"></textarea> </td>
            </tr>
            <tr>
                <td>指令内容：<br></td>
                <td><textarea name="content"></textarea> </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="提   交"/>
                    <input type="reset" value="取   消"/>
                </td>
            </tr>
        </table>

        <div class="text" style="text-align: center"> ${result}<br/></div>
        <div class="text" style="text-align: center">  <a href="${pageContext.request.contextPath}/list">查看指令列表</a></div>

    </form>

</body>
</html>
