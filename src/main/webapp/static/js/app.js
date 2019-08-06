/**
 * 系统公共，js。理论上只存放公共业务代码。
 */
$(function () {
    //全局ajax设置
    $.ajaxSetup({
        statusCode: {
            401: function () {
                $.messager.alert("登录提醒", "您没有权限访问此资源，或刷新页面！", 'info', function () {
                    location.replace("/toLogin");
                });
            },
            402: function () {
                $.messager.alert("登录提醒", "登录超时，请重新登录！", 'info', function () {
                    location.replace("/toLogin");
                });
            }
        }
    });
    var center = $("body").layout("panel", "center");
    $('.easyui-accordion li a').click(function () {
        /**
         *处理tab切换问题：将"href"修改成"way"。
         */
        var url = $(this).attr("way");
        // 刷新center区域
        center.panel("refresh", url);
        $('.easyui-accordion li div').removeClass("selected");
        $(this).parent().addClass("selected");
    }).hover(function () {
        $(this).parent().addClass("hover");
    }, function () {
        $(this).parent().removeClass("hover");
    });
    // 绑定菜单事件
    $(".crm-menu").on('click', 'li', function () {
        if (!$(this).hasClass('selected')) {
            // 获取center对应的panel对象
            // 刷新center区域
            center.panel("refresh", this.dataset.url);
            // 选中状态
            $(this).siblings('.selected').toggleClass().end().addClass('selected');
        }
    });

    //查看和修改用户信息
    $("#public_change_info").on('click', function () {
        var form;
        var dialog = $("<div/>", {class: 'noflow'}).dialog({
            title: "我的资料",
            iconCls: 'fa fa-user',
            height: 320,
            width: 420,
            href: '/change/info',
            modal: true,
            onClose: function () {
                $(this).dialog("destroy");
            },
            onLoad: function () {
                //窗口表单加载成功时执行
                form = $("#public_change_info_form", this);
            },
            buttons: [{
                iconCls: 'fa fa-save',
                text: '保存',
                handler: function () {
                    if (form.form('validate')) {
                        $.post("/change/info", form.serialize(), function (res) {
                            if (res.success) {
                                dialog.dialog('close');
                                location.replace('/');
                            } else {
                                $.messager.alert("系统提示", res.message);
                            }
                        })
                    }
                }
            }]
        });

        /**
         * 上传头像
         */
        dialog.on('click', '#avatar-file', function () {
            //清除上一轮已经选择的文件
            this.value = "";
        }).on('change', '#avatar-file', function () {
            //上传头像，h5的搞法
            var formData = new FormData();
            formData.append('file', this.files.item(0));
            formData.append('type', "AVATAR");
            $.ajax("/attachment/upload", {
                type: 'post',
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                complete: function (res) {
                    var result = res.responseJSON;
                    if (result.success) {
                        $(".avatar-set", dialog).attr('src', result.data.filePath);
                        $("#member-avatar", dialog).val(result.data.filePath);
                    } else {
                        $.messager.alert("系统提示", result.message);
                    }
                }
            })
        });
    });

    //修改密码
    $("#public_change_password").on('click', function () {
        var form;
        var dialog = $("<div/>", {class: 'noflow'}).dialog({
            title: "修改密码",
            iconCls: 'fa fa-lock',
            height: 220,
            width: 420,
            href: '/change/password',
            modal: true,
            onClose: function () {
                $(this).dialog("destroy");
            },
            onLoad: function () {
                //窗口表单加载成功时执行
                form = $("#public_change_password_form", this);
            },
            buttons: [{
                iconCls: 'fa fa-repeat',
                text: '确认修改',
                handler: function () {
                    if (form.form('validate')) {
                        $.post("/change/password", form.serialize(), function (res) {
                            if (res.success) {
                                dialog.dialog('close');
                                location.replace('/logout');
                            } else {
                                $.messager.alert("系统提示", res.message);
                            }
                        })
                    }
                }
            }]
        });
    });
    /**
     * 扩展一个jq组件，获取一个json格式的表单值
     * @param ignoreNull 是否排除空值
     * @returns {*}
     */
    (function ($) {
        $.fn.formToJson = function (ignoreNull) {
            //默认剔除空值
            if (typeof ignoreNull === 'undefined') {
                ignoreNull = true
            }

            if (this.length <= 1) {
                return buildJson(this[0]);
            } else {
                //多表单的情况
                var forms = {};
                this.forEach(function (form, index) {
                    var fName = $(form).attr('name');
                    var key = fName ? fName : 'form' + index;
                    forms[key] = buildJson(form);
                });
                return forms;
            }

            function buildJson(form) {
                var formData = new FormData(form);
                var json = {};
                formData.forEach(function (val, key) {
                    if (!val && ignoreNull) {
                        return
                    }
                    if (json[key]) {
                        if (!$.isArray(json[key])) {
                            json[key] = [json[key]]
                        }
                        json[key].push(val);
                    } else {
                        json[key] = val;
                    }
                });
                return json;
            }
        };
    })(jQuery);
});