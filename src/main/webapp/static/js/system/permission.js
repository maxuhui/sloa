$(function () {
    var types = {
        MENU: "菜单",
        FUNCTION: "功能",
        BLOCK: "区域",
    };
    var permissionGrid = $("#permissionGrid");
    permissionGrid.treegrid({
        fit: true,
        border: false,
        url: 'system/permission/list',
        idField: 'id',
        treeField: 'name',
        columns: [[
            {field: 'name', title: '名称', width: 150},
            {field: 'permissionKey', title: '标识', width: 150},
            {
                field: 'type', title: '类型', align: 'center', width: 60, formatter: function (val) {
                    return types[val];
                }
            },
            {field: 'path', title: '路径', width: 200},
            {
                field: 'resource', title: '资源', width: 200, formatter: function (value) {
                    return "<span title='" + value + "'>" + value + "</span>";
                }
            },
            {field: 'weight', title: '权重', align: 'center', width: 40},
            {
                field: 'description', title: '描述', width: 200, formatter: function (value) {
                    return "<span title='" + value + "'>" + value + "</span>";
                }
            },
            {
                field: 'enable', title: '状态', width: 60, align: 'center', formatter: function (val) {
                    return val ? "可用" : "禁用";
                }
            },
            {
                field: 'edit', title: '操作', width: 100, align: 'center', formatter: function (value, row) {
                    // var btns = [];
                    // btns.push('<a data-id="' + row.id + '" class="actions fa fa-pencil-square-o edit">编辑</a>');
                    // btns.push('<a data-id="' + row.id + '" class="actions fa fa-trash-o delete">删除</a>');
                    // return btns.join("");
                    return authToolBar({
                        "system:permission:edit": '<a data-id="' + row.id + '" class="actions fa fa-pencil-square-o edit">编辑</a>',
                        "system:permission:delete": '<a data-id="' + row.id + '" class="actions fa fa-trash-o delete">删除</a>'
                    }).join("");
                }
            }
        ]],
        toolbar: [{
            iconCls: 'fa fa-plus',
            text: '创建权限',
            handler: function () {
                createForm();
            }
        }]
    });
    //给操作按钮绑定事件
    permissionGrid.datagrid("getPanel").on('click', "a.edit", function () {// 编辑按钮事件
        createForm.call(this, this.dataset.id)
    }).on('click', "a.ctr-delete", function () {// 删除按钮事件
        var id = this.dataset.id;
        $.messager.confirm("删除提醒", "确认删除此资源?", function (r) {
            if (r) {
                $.get("system/permission/delete", {id: id}, function () {
                    // 数据操作成功后，对列表数据，进行刷新
                    permissionGrid.treegrid("reload");
                });
            }
        });
    });

    /**
     * 创建表单窗口
     *
     * @returns
     */
    function createForm(id) {
        var dialog = $("<div/>", {class: 'noflow'}).dialog({
            title: (id ? "编辑" : "创建") + "资源",
            iconCls: 'fa ' + (id ? "fa-edit" : "fa-plus-square"),
            height: 480,
            width: 420,
            href: 'system/permission/form',
            queryParams: {
                id: id
            },
            modal: true,
            onClose: function () {
                $(this).dialog("destroy");
            },
            onLoad: function () {
                //窗口表单加载成功时执行
                form = $("#resource-form");

            },
            buttons: [{
                iconCls: 'fa fa-save',
                text: '保存',
                handler: function () {

                    if (form.form('validate')) {
                        $.post("system/permission/save", form.serialize(), function (res) {
                            permissionGrid.treegrid('reload');
                            dialog.dialog('close');
                        })
                    }
                }
            }]
        });
    }
});