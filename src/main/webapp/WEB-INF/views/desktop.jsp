<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    //检索
    $(function () {
        $('#sbtn').bind('click', function () {
            // $("#employeeRegForm").submit();
            var currentTab = $('#tabs').tabs('getSelected');
            $('#tabs').tabs('update', {
                tab: currentTab,
                options: {
                    href: "desktop?carNumber=" + $("#carNumber").val()
                }
            });
            currentTab.panel('refresh');
        });
    });
</script>
<form action="desktop" method="post" id="employeeRegForm" style="padding: 20px 20px 0px 20px">
    <table style="width: 100%" class="infoTable">
        <tr>
            <td style="text-align: center;border-top:0px" colspan="3">
                <input id="carNumber" autocomplete="off" class="easyui-textbox" data-options="prompt:'请输入车牌号'"
                       style="margin-top: 10px;width: 200px;" name="carNumber"/>
                <a id="sbtn" href="#" class="easyui-linkbutton" style="width:80px">查询</a>

            </td>
        </tr>
        <c:choose>
            <c:when test="${not empty vehicleData}">
                <tr>
                    <td><span style="margin-left: 20px;">车牌号码：</span>
                        <span style="margin-left: 2px;"> ${vehicleData.carNumber}
                            <c:choose>
                                <c:when test="${vehicleData.arrears == 1 }">
                                   <span style="width: 40px;background-color:gray;text-align:center;margin:0px;padding:0px;color:#00CD00;">正常</span>
                                    <%--正常--%>
                                </c:when>
                                <c:otherwise>
                                    <span style="width: 40px;background-color:gray;text-align:center;margin:0px;padding:0px;color:#FFFFFF;">欠费</span>
                                    <%--欠费--%>
                                </c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td><span style="margin-left: 10px;">公司名称：</span>
                        <span style="margin-left: 2px;">${vehicleData.companyName}</span></td>
                    <td><span style="margin-left: 10px;">车牌颜色：</span>
                        <span style="margin-left: 2px;">${vehicleData.plateColor}</span></td>
                </tr>
                <tr>
                    <td><span style="margin-left: 20px;">VIN号：</span>
                        <span style="margin-left: 2px;"> ${vehicleData.carVin}</span></td>
                    <td><span style="margin-left: 10px;">终端ID：</span>
                        <span style="margin-left: 2px;">${vehicleData.equitment}</span></td>
                    <td><span style="margin-left: 10px;">通讯SIM卡号：</span>
                        <span style="margin-left: 2px;">${vehicleData.simNumber}</span></td>
                </tr>
                <tr>
                    <td><span style="margin-left: 20px;">车主：</span>
                        <span style="margin-left: 2px;"> ${vehicleData.carOwner}</span></td>
                    <td><span style="margin-left: 10px;">联系人：</span>
                        <span style="margin-left: 2px;">${vehicleData.contacts}</span></td>
                    <td><span style="margin-left: 10px;">联系电话：</span>
                        <span style="margin-left: 2px;">${vehicleData.contactsTel}</span></td>
                </tr>
                <tr>
                    <td><span style="margin-left: 10px;">入网协议号：</span>
                        <span style="margin-left: 2px;">${vehicleData.networkNo}</span></td>
                    <td><span style="margin-left: 10px;">服务开始时间：</span>
                        <span style="margin-left: 2px;">${vehicleData.svrStartTime}</span></td>
                    <td><span style="margin-left: 10px;">服务结束时间：</span>
                        <span style="margin-left: 2px;">${vehicleData.svrEndTime}</span></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align: center;">
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">缴费</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="width:80px">维修</a>
                        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px">查看定位</a>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="3" style="text-align: center;" >查无此车，请确认输入正确车牌号！</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</form>
