$(function () {
    var userGrid = $("#userGrid");
    var searchFrom = $("#member_search_from");
    var userGridAction = $("#userGridAction");

    userGrid.datagrid({
        fit: true,
        border: false,
        url: 'system/user/list',
        singleSelect: true,
        pagination: true,
        rownumbers: true,
        columns: [[
            {field: 'account', title: '账号', width: 180},
            {field: 'userName', title: '姓名', width: 150},
            {field: 'tel', title: '电话', width: 200},
            {
                field: 'roles', title: '角色', width: 200, formatter: function (val) {
                    var roles = [];
                    $.each(val, function () {
                        roles.push(this.roleName);
                    });
                    return roles.join(",");
                }
            },
            {
                field: 'enable', title: '状态', width: 80, align: 'center', formatter: function (val) {
                    return val ? "可用" : "禁用";
                }
            },
            {
                field: 'edit', title: '操作', width: 100, align: 'center', formatter: function (val, row) {
                    // return userGridAction.children("a.actions").attr('data-id', row.id).end().html();
                    return authToolBar({
                        "system:user:edit": '<a data-id="' + row.id + '" class="ctr ctr-edit">编辑</a>',
                        "system:user:delete": '<a data-id="' + row.id + '" class="ctr ctr-delete">删除</a>'
                    }).join("");
                }
            }
        ]],
        toolbar: "#userGridToolbar"
    });


    var gridPanel = userGrid.datagrid("getPanel");

    //给操作按钮绑定事件
    gridPanel.on("click", "a.edit", function () {
        var id = this.dataset.id;
        createForm(id);
    }).on("click", "a.delete", function () {
        var id = this.dataset.id;
        $.messager.confirm("提示", "是否删除？", function (r) {
            if (r) {
                $.get("system/user/delete?id=" + id).success(function () {
                    //删除成功
                    userGrid.datagrid("reload");
                });
            }
        })
    }).on("click", "a.create", function () {
        createForm();
    });
    /**
     * 搜索区域事件
     */
    searchFrom.on('click', 'a.searcher', function () {//检索
        userGrid.datagrid('load', searchFrom.formToJson());
    }).on('click', 'a.reset', function () {//重置
        searchFrom.form('reset');
        userGrid.datagrid('load', {});
    });

    /**
     * 创建表单窗口
     *
     * @returns
     */
    function createForm(id) {
      var  furl= 'system/user/' + (id ? 'load?id=' + id : 'form');
        var dialog = $("<div/>", {class: 'noflow'}).dialog({
            title: (id ? "编辑" : "创建") + "用户",
            iconCls: 'fa ' + (id ? "fa-edit" : "fa-plus-square"),
            height: 380 ,
            width: 420,
            href: 'system/user/' + (id ? 'load?id=' + id : 'form'),
            modal: true,
            onClose: function () {
                $(this).dialog("destroy");
            },
            onLoad: function () {
                //窗口表单加载成功时执行
                form = $("#member-form");
                //这个字段比较特殊，有比较多的校验，所以单独拿出来实例化
                // $("#user_userName").textbox({
                //     label: '账号：',
                //     required: true,
                //     validType: ['account', 'length[4, 10]', "remote['system/user/check','account']"]
                // })
            },
            buttons: [{
                iconCls: 'fa fa-save',
                text: '保存',
                handler: function () {
                    if (form.form('validate')) {
                        $.post("system/user/save", form.serialize(), function (res) {
                            userGrid.datagrid('reload');
                            dialog.dialog('close');
                        })
                    }
                }
            }]
        });
    }
});