<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="app-form" id="resource-form">
    <input type="hidden" name="id">
    <div class="field">
        <select id="resource-form-parent"  name="parent_id"
                data-options="label:'父资源：',url:'system/permission/combox',idField: 'id',textField: 'name'"
                style="width:100%"></select>
    </div>
    <div class="field">
        <input class="easyui-textbox" name="name" style="width:100%" data-options="label:'资源名称：',required:true">
    </div>

    <div class="field">
        <input class="easyui-textbox" name="permissionKey" style="width:100%" data-options="label:'资源标识：',required:true">
    </div>
    <div class="field">
        <select class="easyui-combobox" name="type" panelHeight="auto" editable="false" label="资源类型：" style="width:100%">
            <option value="MENU">菜单</option>
            <option value="FUNCTION">功能</option>
            <option value="BLOCK">区块</option>
        </select>
    </div>
    <div class="field">
        <input class="easyui-textbox" name="path" style="width:100%" data-options="label:'菜单URL：'">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="resource" style="width:100%;height:60px" data-options="label:'功能URLS：',multiline:true">
    </div>
    <div class="field">
        <input class="easyui-numberbox" name="weight" style="width:100%" data-options="label:'权重：'">
    </div>
    <div class="field">
        <label class="textbox-label textbox-label-before">状态：</label>
        <input class="easyui-switchbutton" name="enable" data-options="onText:'启用',offText:'禁用',checked:true" value="true">
    </div>
</form>

<script>
    $("#resource-form-parent").combotree({
        onLoadSuccess:function(){
            $("#resource-form").form("load",${permission})
        }
    })
</script>
