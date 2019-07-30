<%--
 Created by IntelliJ IDEA.
 User: maxuh
 Date: 2019-07-24
 Time: 8:03
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="easyui-layout" fit="true">
    <div data-options="region:'north',border:false,collapsible:false" style="height: 80px;padding: 10px;overflow: hidden;" title="用户管理">
        <form id="member_search_from" class="searcher-form">
            <input name="account" class="easyui-textbox field" label="账号：" labelWidth="45">
            <input name="userName" class="easyui-textbox field" label="姓名：" labelWidth="45">
            <input name="tel" class="easyui-textbox field" label="电话：" labelWidth="45">
            <a class="easyui-linkbutton searcher" data-options="iconCls:'fa fa-search'">检索</a>
            <a class="easyui-linkbutton reset" data-options="iconCls:'fa fa-repeat'">重置</a>
        </form>
    </div>
    <div data-options="region:'center',border:false" style="border-top: 1px solid #D3D3D3">
        <table id="userGrid"></table>
    </div>
</div>

<div id="userGridAction" style="display: none;">
    <c:if test="${fn:contains(keys,'system:user:edit')}"><a class="actions fa fa-pencil-square-o edit">编辑</a></c:if>
    <c:if test="${fn:contains(keys,'system:user:delete')}"> <a class="actions fa fa-trash-o delete">删除</a></c:if>
</div>
<div id="userGridToolbar" style="display: none;">
    <c:if test="${fn:contains(keys,'system:user:create')}"><a class="easyui-linkbutton actions create" iconCls="fa fa-plus" plain="true">创建用户</a></c:if>
</div>
<script src="${pageContext.request.contextPath}/static/js/system/user.js"></script>