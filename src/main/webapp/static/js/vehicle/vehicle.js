$(function () {
    var vehicleGrid = $("#vehicleGrid");
    var searchFrom = $("#member_search_from");
    vehicleGrid.datagrid({
        fit: true,
        border: false,
        url: 'vehicle/list',
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        columns: [[
            {field: 'companyName', title: '公司名称', halign: 'center', width: 200},
            {field: 'carNumber', title: '车牌号', halign: 'center'},
            {
                field: 'plateColor', title: '车牌颜色', halign: 'center', align: 'center', formatter: function (val) {

                    if (val == '1') {
                        return "黄色";
                    }
                }
            },
            {field: 'carOwner', title: '终端ID', halign: 'center', width: 100},
            {field: 'carOwner', title: '通讯SIM卡号', halign: 'center', width: 100},
            {field: 'carOwner', title: '车主', halign: 'center', width: 60},
            {
                field: 'enables', title: '状态', halign: 'center', width: 80, align: 'center', formatter: function (val) {
                    return val ? "正常" : "欠费";
                }
            },
            {field: 'carOwner', title: '服务开始时间', halign: 'center', width: 80},
            {field: 'carOwner', title: '服务结束时间', halign: 'center', width: 80},
            {
                field: 'edit',
                title: '操作',
                halign: 'center',
                width: 130,
                align: 'center',
                formatter: function (val, row) {
                    return authToolBar({
                        "vehicle:edit": '<a data-id="' + row.id + '" class="actions fa fa-pencil-square-o edit">编辑</a>',
                        "vehicle:delete": '<a data-id="' + row.id + '" class="actions fa fa-trash-o delete">删除</a>'
                    }).join(" ")+'  <a data-id="\' + row.id + \'" class="actions fa fa-info info">详细</a>';

                }
            }
        ]],
        toolbar: authToolBar({
            "vehicle:add": {
                iconCls: 'fa fa-plus-square',
                text: "添加",
                handler: function () {
                    createForm();
                }
            }
        })
    });
});