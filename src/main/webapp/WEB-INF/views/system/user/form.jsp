<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="app-form" id="member-form">
    <input type="hidden" name="id">
    <div class="field">
        <input id="user_userName" class="easyui-textbox" name="account" style="width:100%" data-options="label:'账号：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="userName" style="width:100%" data-options="label:'姓名：',required:true">
    </div>
    <div class="field">
        <input class="easyui-textbox" name="tel" style="width:100%" data-options="label:'电话：',required:true">
    </div>
    <div class="field">
        <input id="role_box" class="easyui-combobox" style="width:100%" name="roles"
               data-options="label:'用户角色：',valueField:'id',panelMaxHeight:200,panelHeight:'auto',textField:'roleName',url:'system/user/roles',editable:false,multiple:true"
        >
        </select>
    </div>
    <div class="field">
        <label class="textbox-label textbox-label-before">状态：</label>
        <input class="easyui-switchbutton" name="enable" data-options="onText:'启用',offText:'禁用',checked:true" value="true">
    </div>
    <div class="field">
        新建用户，默认密码：0000
    </div>
</form>
<script>
    <c:if test="${not empty userBean}">
    $(function () {
        //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
        setTimeout(function () {
            var user = ${userBean};
            if (user.roles) {
                var roles = [];
                $.each(user.roles, function () {
                    roles.push(this.id);
                });
                user.roles = roles.join(",");
            }
            $("#member-form").form("load", user);
        }, 200);
    });
    </c:if>

</script>