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
            <span class="control-container">
                <label id="IsServicePay_text">服务是否缴费 </label>
                <select id="IsServicePay" name="IsServicePay.SelectedValue" style="width:50px">
                    <option value="-1"></option>
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </span>
            <span>
            服务到期时间
            <input type="text" name="CommercialEndTime.StartTime" autocomplete="off" class="Wdate" onclick="WdatePicker()" style="width:100px;">
            -
            <input type="text" name="CommercialEndTime.EndTime" autocomplete="off" class="Wdate" onclick="WdatePicker();" style="width:100px;"> 
            </span>
            <a class="easyui-linkbutton searcher" data-options="iconCls:'fa fa-search'">检索</a>
            <a class="easyui-linkbutton reset" data-options="iconCls:'fa fa-repeat'">重置</a>
        </form>
    </div>
    <div data-options="region:'center',border:false" style="border-top: 1px solid #D3D3D3">
        <table id="feesGrid"></table>
    </div>
</div>
<script>
    $(function () {
        var vehicleGrid = $("#feesGrid");
        var searchFrom = $("#member_search_from");
        vehicleGrid.datagrid({
            fit: true,
            border: false,
            url: 'serviceFees/list',
            singleSelect: true,
            pagination: true,
            rownumbers: true,
            columns: [[
                {field: 'carNumber', title: '车牌号', halign: 'center'},
                {field: 'owner', title: '所属企业', halign: 'center', width: 260},
                {field: 'startTime', title: '服务开始时间', halign: 'center', width: 80},
                {field: 'endTime', title: '服务结束时间', halign: 'center', width: 80},
                {field: 'svrstate', title: '服务状态', halign: 'center', width: 80},
                {field: 'riqi', title: '付费时间', halign: 'center', width: 100},
                {field: 'number', title: '入网协议', halign: 'center', width: 100},
                {
                    field: 'colAmounts', title: '缴费(元)', halign: 'center', align: 'right', width: 100,
                    formatter: function (value, row, index) {
                        if (row != null) {
                            // return (parseFloat(value).toFixed(2) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
                            return value.replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
                        }
                    }
                },
                {field: 'inspector', title: '代收人', halign: 'center', width: 90},
                {field: 'agent', title: '收费人', halign: 'center', width: 90},
                {
                    field: 'fees', title: '状态', halign: 'center', width: 60,
                    formatter: function (value, row, index) {
                        if (row.fees == 0) {
                            return "<div  style='background-color:gray;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>待确认</div>";
                        } else if (row.fees == 1) {
                            return "<div  style='background-color:green;text-align:center;margin:0px;padding:0px;color:#FFFFFF;'>已入网</div>";
                        }
                    }
                }
            ]],
            toolbar: authToolBar({
                "": {
                    iconCls: 'fa fa-plus-square',
                    text: "导出",
                    handler: function () {
                        createForm();
                    }
                }
            })
        });
    });
</script>