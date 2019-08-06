<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <%@ include file="/inc.jsp" %>
    <title>神龙OA</title>
    <script src="${pageContext.request.contextPath}/static/js/require.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
    <!--权限资源-->
    <%--<script src="${pageContext.request.contextPath}/resource" charset="utf-8"></script>--%>
    <script type='text/javascript'>
        (function (w) {
            <%--var resourceKey = ${keys};--%>
            /**
             * 工具栏的权限过滤
             * @param tools
             * @returns
             */
            function authToolBar(tools) {
                var resourceKey = $("#resourceKey").val();
                var toolbars = [];
                $.each(tools, function (key, btn) {
                    if (resourceKey.indexOf(key) != -1) {
                        toolbars.push(btn);
                    }
                });
                if (arguments.length > 1) {
                    for (var i = 1; i < arguments.length; i++) {
                        toolbars.push(arguments[i])
                    }
                }
                return toolbars;
            }

            w.authToolBar = authToolBar;
        })(window);
    </script>
</head>
<body class="easyui-layout">
<input type="hidden" id="resourceKey" value="${keys}">
<%--<div data-options="region:'north'" style="height: 70px;overflow: hidden;padding: 0 10px;" class="viewui-navheader">--%>
<div data-options="region:'north',split:false,border:false,border:false" class="viewui-navheader">
    <%--<h1>神龙科技智能办公系统</h1>--%>
    <!-- header start -->
    <div class="sys-logo">
        <a href="javascript:;" class="logo_title">logo名称</a>
        <a href="javascript:;" class="e">logo副标题</a>
    </div>
    <!-- 菜单横栏 -->
    <ul class="viewui-navmenu" style="display: block">
        <li class="navmenu-item"><a class="item" href="http://hbslkj.com:89/mygpsonline/" target="_blank" onfocus="this.blur();"><i class="fa fa-trophy"></i><span
                class="title">网上查车</span></a></li>
        <li class="navmenu-item"><a class="item" href="https://www.gghypt.net/" target="_blank" onfocus="this.blur();"><i class="fa fa-inbox"></i><span
                class="title">全国货运平台</span></a></li>
    </ul>
    <div class="user-info">
        <span class="item" id="public_change_info"><i class="fa fa-user"></i> ${user.account}</span>
        <span class="item" id="public_change_password"><i class="fa fa-user"></i> 修改密码</span>
        <a class="item" href="logout"><i class="fa fa-out"></i> 注销</a>
    </div>

</div>
<div title="菜单" data-options="region:'west',iconCls:'fa fa-list'" style="width: 200px">
    <div class="easyui-accordion" data-options="fit:true">
        <c:if test="${not empty menus}">
            <c:forEach items="${menus}" var="menu">
                <div title="${menu.menuname}" data-options="iconCls:'fa fa-cogs'">
                        <%--<ul class="crm-menu">--%>
                    <ul class="easyui-tree" data-options="lines: true">
                        <c:forEach items="${menu.menus}" var="child">
                            <%--<li data-url="${child.url}">${child.menuname}</li>--%>
                            <li><a way="${child.url}">${child.menuname}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
        </c:if>

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