<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/images/favicon.ico" type="image/gif" />
<!-- 导入主题样式文件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/gray/easyui.css">
<!-- 图标 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/easyui/themes/icon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css">
<!-- 项目公共样式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/app.css">
<!-- 第一脚本：jquery，必须是在第一位 -->
<script src="${pageContext.request.contextPath}/static/easyui/jquery.min.js" charset="utf-8"></script>
<!-- easyui的核心 -->
<script src="${pageContext.request.contextPath}/static/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<!-- Easyui的扩展 -->
<script src="${pageContext.request.contextPath}/static/easyui/jquery.edatagrid.js" charset="utf-8"></script>
<!-- Easyui的国际化 -->
<script src="${pageContext.request.contextPath}/static/easyui/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- Easyui的bug修复包 -->
<script src="${pageContext.request.contextPath}/static/easyui/fixed.js" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/js/lib/xss.js" charset="utf-8"></script>
<!--webSocket的支持-->
<%--<script src="${pageContext.request.contextPath}/static/js/lib/sockjs.min.js" charset="utf-8"></script>--%>
<%--<script src="${pageContext.request.contextPath}/static/js/lib/vue.js" charset="utf-8"></script>--%>
<%--EasyUI combotree扩展支持自定义idField和textField--%>
<script src="${pageContext.request.contextPath}/static/js/lib/combotreeExtend.js" charset="utf-8"></script>
