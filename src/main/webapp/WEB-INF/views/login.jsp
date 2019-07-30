<%--
  Created by IntelliJ IDEA.
  User: maxuh
  Date: 2019-07-14
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>神龙OA系统</title>
    <!-- 第一脚本：jquery，必须是在第一位 -->
    <script src="static/easyui/jquery.min.js" charset="utf-8"></script>
    <link rel="stylesheet" href="static/css/login.css">
    <link rel="stylesheet" href="static/font-awesome/css/font-awesome.min.css">
</head>
<body>
<div class="logo_box">
    <h1>河北神龙物流信息科技有限公司</h1>
    <form id="loginForm" action="doLogin" method="post" autocomplete="off">
        <div class="input_outer">
            <i class="fa fa-user-o u_user"></i>
            <input required="required" name="account" class="text" placeholder="输入账号" type="text">
        </div>
        <div class="input_outer">
            <i class="fa fa-eye u_user"></i>
            <input required="required" placeholder="请输入密码" name="password" class="text" type="password">
        </div>
        <div class="mb2">
            <button id="loginBtn" class="act-but submit" style="color: #FFFFFF">登录</button>
        </div>
        <div style="text-align:center;padding: 10px;">${error}</div>
    </form>
</div>
<script>
    $(function () {
        $('#loginBtn').on('click', function () {
            $("#loginForm").submit();
        });
    });
</script>
</body>
</html>
