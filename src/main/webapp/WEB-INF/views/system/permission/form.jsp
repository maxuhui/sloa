<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<form id="permissionForm" class="form">--%>
    <%--<input type="hidden" name="id" value="${permission.id}">--%>
    <%--<div class="form-line">--%>
        <%--<label for="parent">父资源</label>--%>
        <%--<select id="parent" name="parent" class="easyui-combotree" data-options="'editable:false,url:\'/system/permission/combo\',value:'+${permission.parent.id}"></select>--%>
    <%--</div>--%>
    <%--<div class="form-line required">--%>
        <%--<label for="name">资源名称</label>--%>
        <%--<input id="name" name="name" type="text" class="easyui-textbox" data-options="required:true" value="${permission.name}">--%>
    <%--</div>--%>
    <%--<div class="form-line required">--%>
        <%--<label for="permissionKey">资源标识</label>--%>
        <%--<input id="permissionKey" name="permissionKey" type="text" class="easyui-textbox" data-options="required:true" value="${permission.permissionKey}">--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="type">资源类型</label>--%>
        <%--<select id="type" name="type" class="easyui-combobox"--%>
                <%--data-options="'editable:false,panelHeight:\'auto\',value:\''+${permission.type==null?'MENU':permission.type.name()}+'\''">--%>
            <%--<option value="MENU">菜单</option>--%>
            <%--<option value="FUNCTION">功能</option>--%>
            <%--<option value="BLOCK">区域</option>--%>
        <%--</select>--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="path">菜单路径</label>--%>
        <%--<input id="path" type="text" name="path" class="easyui-textbox" value="${permission.path}">--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="resource">资源</label>--%>
        <%--<input id="resource" type="text" name="resource" class="easyui-textbox" data-options="multiline:true" value="${permission.resource}">--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="description">描述</label>--%>
        <%--<input id="description" name="description" type="text" class="easyui-textbox" data-options="multiline:true" value="${permission.description}">--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="weight">权重</label>--%>
        <%--<input id="weight" name="weight" type="text" class="easyui-textbox" value="${permission.weight}">--%>
    <%--</div>--%>
    <%--<div class="form-line">--%>
        <%--<label for="enable">状态</label>--%>
        <%--<input id="enable" name="enable" class="easyui-switchbutton"--%>
               <%--data-options="'onText:\'启用\',offText:\'禁用\',value:\'1\',checked:'+${permission.enable==null || permission.enable?'true':'false'}">--%>
    <%--</div>--%>
<%--</form>--%>
<form class="app-form" id="resource-form">
    <input type="hidden" name="id">
    <div class="field">
        <select id="resource-form-parent"  name="parent" url="/system/resource/parent/tree" label="父资源：" style="width:100%"></select>
    </div>
    <div class="field">
        <input class="easyui-textbox" name="resName" style="width:100%" data-options="label:'资源名称：',required:true">
    </div>

    <div class="field">
        <input class="easyui-textbox" name="resKey" style="width:100%" data-options="label:'资源标识：',required:true">
    </div>
    <div class="field">
        <select class="easyui-combobox" name="resType" panelHeight="auto" editable="false" label="资源类型：" style="width:100%">
            <option value="MENU">菜单</option>
            <option value="FUNCTION">功能</option>
            <option value="BLOCK">区块</option>
        </select>
    </div>
    <div class="field">
        <input class="easyui-textbox" name="menuUrl" style="width:100%" data-options="label:'菜单URL：'">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="funUrls" style="width:100%;height:60px" data-options="label:'功能URLS：',multiline:true">
    </div>
    <div class="field">
        <input class="easyui-numberbox" name="weight" style="width:100%" data-options="label:'权重：'">
    </div>
    <div class="field">
        <label class="textbox-label textbox-label-before">状态：</label>
        <input class="easyui-switchbutton" name="status" data-options="onText:'启用',offText:'禁用',checked:true" value="true">
    </div>
</form>

<script>
    $("#resource-form-parent").combotree({
        onLoadSuccess:function(){
            $("#resource-form").form("load",${resource})
        }
    })
</script>
