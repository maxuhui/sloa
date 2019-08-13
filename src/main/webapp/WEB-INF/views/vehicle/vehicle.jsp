<%--
  Created by IntelliJ IDEA.
  User: maxuh
  Date: 2019-08-08
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" fit="true">
    <div data-options="region:'north',border:false,collapsible:false" style="height: 80px;padding: 10px;overflow: hidden;" title="车辆管理">
        <form id="vehicle_search_from" class="searcher-form">
            <input name="account" class="easyui-textbox field" label="车牌号：" labelWidth="65">
            <input name="userName" class="easyui-textbox field" label="VIN号：" labelWidth="65">
            <input name="tel" class="easyui-textbox field" label="车主姓名：" labelWidth="75">
            <a class="easyui-linkbutton searcher" data-options="iconCls:'fa fa-search'">检索</a>
            <a class="easyui-linkbutton reset" data-options="iconCls:'fa fa-repeat'">重置</a>
        </form>
    </div>
    <div data-options="region:'center',border:false" style="border-top: 1px solid #D3D3D3">
        <table id="vehicleGrid"></table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/vehicle/vehicle.js"></script>