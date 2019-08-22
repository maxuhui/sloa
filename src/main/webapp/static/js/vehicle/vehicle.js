$(function () {
    var vehicleGrid = $("#vehicleGrid");
    var searchFrom = $("#vehicle_search_from");
    vehicleGrid.datagrid({
        fit: true,
        border: false,
        url: 'vehicle/list',
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        columns: [[
            {field: 'carNumber', title: '车牌号', halign: 'center'},
            {field: 'carVin', title: 'VIN号', halign: 'center'},
            {field: 'companyName', title: '公司名称', halign: 'center', width: 200},
            {
                field: 'plateColor', title: '车牌颜色', halign: 'center', align: 'center', formatter: function (val) {
                    if (val == '1') {
                        return "蓝色";
                    }
                    if (val == '2') {
                        return "黄色";
                    }
                    if (val == '3') {
                        return "浅绿";
                    }
                    if (val == '4') {
                        return "黄绿";
                    }
                    if (val == '9') {
                        return "其他";
                    }
                }
            },
            {field: 'equitment', title: '终端ID', halign: 'center', width: 100},
            {field: 'simNumber', title: '通讯SIM卡号', halign: 'center', width: 100},
            {field: 'contacts', title: '联系人', halign: 'center', width: 80},
            {field: 'contactsTel', title: '联系电话', halign: 'center', width: 100},
            {
                field: 'arrears', title: '状态', halign: 'center', width: 80, align: 'center', formatter: function (val) {
                    return val == 1 ? "正常" : "欠费";
                }, styler: function (val, row, index) {
                    return val == 1 ? "正常" : 'background-color:read;';
                }

            },
            {field: 'networkNo', title: '入网协议号', halign: 'center', width: 80},
            {field: 'svrStartTime', title: '服务开始时间', halign: 'center', width: 80},
            {field: 'svrEndTime', title: '服务结束时间', halign: 'center', width: 80},
            {
                field: 'edit',
                title: '操作',
                halign: 'center',
                width: 130,
                align: 'center',
                formatter: function (val, row) {
                    return '<a data-id="\' + row.id + \'" class="actions fa fa-info info">详细</a>';

                }
            }
        ]],
        toolbar: authToolBar({
            "vehicle:add": {
                iconCls: 'fa fa-plus-square', text: "添加", handler: function () {
                    createForm();
                }
            },
            "vehicle:edit": {
                iconCls: 'fa fa-pencil-square-o', text: "编辑", handler: function () {
                    var row = vehicleGrid.datagrid('getSelected');
                    createForm(row.id);
                }
            },
            "vehicle:delete": {
                iconCls: 'fa fa-trash-o', text: "删除", handler: function () {
                    $.messager.confirm('提示', '删除后该车辆相关信息将丢失。', function (r) {
                        if (r) {
                            var row = vehicleGrid.datagrid('getSelected');
                            $.ajax({
                                url: "vehicle/delete?id=" + row.id,
                                success: function (data) {
                                    if (data.success) {
                                        vehicleGrid.datagrid('reload');
                                    } else {
                                        $.messager.alert("系统提醒", data.success);
                                    }
                                }
                            });
                        }
                    });

                }
            }
        })
    });
    /**
     * 搜索区域事件
     */
    searchFrom.on('click', 'a.searcher', function () {//检索
        vehicleGrid.datagrid('load', searchFrom.formToJson());
    }).on('click', 'a.reset', function () {//重置
        searchFrom.form('reset');
        vehicleGrid.datagrid('load', {});
    });

    /**
     * 创建表单窗口
     *
     * @returns
     */
    function createForm(id) {
        var dialog = $("<div/>", {class: 'noflow'}).dialog({
            title: (id ? "编辑" : "创建") + "车辆信息",
            iconCls: 'fa ' + (id ? "fa-edit" : "fa-plus-square"),
            height: 450,
            width: 1000,
            href: 'vehicle/' + (id ? 'load?id=' + id : 'form'),
            modal: true,
            onClose: function () {
                $(this).dialog("destroy");
            },
            onLoad: function () {
                //窗口表单加载成功时执行
                form = $("#vehicle-form");
            },
            buttons: [{
                iconCls: 'fa fa-save',
                text: '保存',
                handler: function () {
                    if (form.form('validate')) {
                        $.post("vehicle/form/save", form.serialize(), function (res) {
                            if (!res.success) {
                                $.messager.alert('提示',res.msg,'warning');
                            } else {
                                vehicleGrid.datagrid('reload');
                                dialog.dialog('close');
                            }
                        })
                    }
                }
            }, {
                iconCls: 'fa fa-close',
                text: '关闭',
                handler: function () {
                    dialog.dialog('close');
                }
            }]
        });
    }
});