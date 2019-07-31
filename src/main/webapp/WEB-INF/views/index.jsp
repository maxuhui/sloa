<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <%@ include file="/inc.jsp" %>
    <title>神龙OA</title>
    <script src="static/js/require.js"></script>
    <script src="static/js/app.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height: 70px;overflow: hidden;padding: 0 10px;">
    <div class="user-info">
        <span class="item" id="public_change_info"><i class="fa fa-user"></i> ${user.account}</span>
        <span class="item" id="public_change_password"><i class="fa fa-user"></i> 修改密码</span>
        <a class="item" href="/logout"><i class="fa fa-out"></i> 注销</a>
    </div>
    <h1>神龙科技智能办公系统</h1>
</div>
<div title="菜单" data-options="region:'west',iconCls:'fa fa-list'" style="width: 200px">
    <div class="easyui-accordion" data-options="fit:true">
        <div title="系统管理">
            <ul class="easyui-tree" data-options="lines: true">
                <li>角色管理</li>
                <li><a way="system/user/index">用户管理</a></li>
                <li>权限管理</li>
            </ul>
        </div>
        <div title="流程管理">
            <ul class="easyui-tree" data-options="lines: true">
                <li>流程预定义</li>
                <li>流程监控</li>
            </ul>
        </div>
        <div title="系统集成管理" data-options="lines: true">
            <ul class="easyui-tree">
                <li>手动同步数据</li>
                <li>数据同步日志</li>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'center',href:'desktop.jsp'">

</div>
<div id="footer" data-options="region:'south'"
     style="height:20px;text-align: center;line-height: 20px;overflow: hidden;">
    Copyright © 2019 神龙办公 v1.2 Powered by 河北神龙物流信息科技有限公司
</div>
</body>
</html>