 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'center'">
        <table id="roleGrid"></table>
    </div>
    <div id="rolePermissionPanel" data-options="region:'east',collapsible:false,tools:'#rolePermissionTools'" style="width: 200px;" title="请选择角色">
        <ul id="rolePermissionTree"></ul>
    </div>
</div>
<div id="rolePermissionTools">
    <a id="rolePermissionSave" class="fa fa-save"></a>
</div>
<script src="${pageContext.request.contextPath}/static/js/system/role.js"></script>