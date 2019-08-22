<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="vehicle-form" class="app-form" >
    <div class="easyui-panel" title="基本信息(重要*)" style="float:left; width:100%;">
        <input type="hidden" name="id">
        <table class="editor-table" cellspacing="0">
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>车牌号</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="carNumber" value="" style="width:175px;"/> <span class="editor-required">*</span>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>车牌颜色</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <select name="plateColor" style="width:179px;">
                        <option value="1">蓝色</option>
                        <option value="2">黄色</option>
                        <option value="3">黑色</option>
                        <option value="4">白色</option>
                        <option value="9">其他</option>

                    </select>
                    <span class="editor-required">*</span>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>所属组织</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" name="companyName" value="" style="width:175px;"/>
                </td>
            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>车辆类型</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <select name="carType" style="width:179px;">
                        <option value="10">客车</option>
                        <option value="11">　大型客车</option>
                        <option value="12">　中型客车</option>
                        <option value="13">　小型客车</option>
                        <option value="14">　轿车</option>
                        <option value="15">　大型卧铺客车</option>
                        <option value="16">　中型卧铺客车</option>
                        <option value="20">普通货车</option>
                        <option value="21">　大型普通货车</option>
                        <option value="22">　中型普通货车</option>
                        <option value="23">　小型普通货车</option>
                        <option value="30">专用运输车</option>
                        <option value="31">　集装箱车</option>
                        <option value="32">　大件运输车</option>
                        <option value="33">　保温冷藏车</option>
                        <option value="34">　商品车运输专用车辆</option>
                        <option value="35">　罐车</option>
                        <option value="36">　牵引车</option>
                        <option value="37">　挂车</option>
                        <option value="38">　平板车</option>
                        <option value="39">　其他专用车</option>
                        <option value="40">危险品运输车</option>
                        <option value="50">农用车</option>
                        <option value="60">拖拉机</option>
                        <option value="61">　轮式拖拉机</option>
                        <option value="62">　手扶拖拉机</option>
                        <option value="63">　履带拖拉机</option>
                        <option value="64">　特种拖拉机</option>
                        <option value="90">其他车辆</option>
                        <option value="100">专项作业车</option>
                        <option value="101">　大型专项作业车</option>
                        <option value="102">　中型专项作业车</option>
                        <option value="103">　小型专项作业车</option>
                        <option value="104">　微型专项作业车</option>
                        <option value="105">　重型专项作业车</option>
                        <option value="106">　轻型专项作业车</option>
                        <option value="110">电车</option>
                        <option value="111">　无轨电车</option>
                        <option value="112">　有轨电车</option>
                        <option value="120">摩托车</option>
                        <option value="121">　普通正三轮摩托车</option>
                        <option value="122">　轻便正三轮摩托车</option>
                        <option value="123">　正三轮载客摩托车</option>
                        <option value="124">　正三轮载货摩托车</option>
                        <option value="125">　侧三轮摩托车</option>
                        <option value="126">　普通二轮摩托车</option>
                        <option value="127">　轻便二轮摩托车</option>
                        <option value="130">三轮汽车</option>
                        <option value="140">轮式机械</option>
                        <option value="141">　轮式装载机械</option>
                        <option value="142">　轮式挖掘机械</option>
                        <option value="143">　轮式平地机械</option>

                    </select>
                    <span class="editor-required">*</span>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>车籍地</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="hidden" id="HomeCity" name="HomeCity" value="" style="width:175px;"/>
                    <select id="province" name="province" style="width:60px">
                        <option value=""></option>
                        <option value="110000">北京市</option>
                        <option value="120000">天津市</option>
                        <option value="130000">河北省</option>
                        <option value="140000">山西省</option>
                        <option value="150000">内蒙古自治区</option>
                        <option value="210000">辽宁省</option>
                        <option value="220000">吉林省</option>
                        <option value="230000">黑龙江省</option>
                        <option value="310000">上海市</option>
                        <option value="320000">江苏省</option>
                        <option value="330000">浙江省</option>
                        <option value="340000">安徽省</option>
                        <option value="350000">福建省</option>
                        <option value="360000">江西省</option>
                        <option value="370000">山东省</option>
                        <option value="410000">河南省</option>
                        <option value="420000">湖北省</option>
                        <option value="430000">湖南省</option>
                        <option value="440000">广东省</option>
                        <option value="450000">广西壮族自治区</option>
                        <option value="460000">海南省</option>
                        <option value="500000">重庆市</option>
                        <option value="510000">四川省</option>
                        <option value="520000">贵州省</option>
                        <option value="530000">云南省</option>
                        <option value="540000">西藏自治区</option>
                        <option value="610000">陕西省</option>
                        <option value="620000">甘肃省</option>
                        <option value="630000">青海省</option>
                        <option value="640000">宁夏回族自治区</option>
                        <option value="650000">新疆维吾尔自治区</option>
                        <option value="710000">台湾省</option>
                        <option value="810000">香港特别行政区</option>
                        <option value="820000">澳门特别行政区</option>
                    </select><select id="City" name="City" style="width:60px">
                    <option value=""></option>
                </select><select id="County" name="County" style="width:60px">
                    <option value=""></option>
                </select>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>车辆品牌</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" name="carBrand" value="" style="width:175px;"/>
                </td>
            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>终端ID</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="equitment" value="" style="width:175px;"/>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>SIM卡号</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="simNumber" value="" style="width:175px;"/>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>联系人</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="contacts" value="" style="width:175px;"/>
                </td>

            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>车辆颜色</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="carColor" value="" style="width:175px;"/>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>车架号</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="carVin" value="" style="width:175px;"/>
                    <span class="editor-required">*</span>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>联系人电话</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" name="contactsTel" value="" style="width:175px;"/>
                </td>
            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>发动机号</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" id="EngineNo" name="EngineNo" value="" style="width:175px;"/>
                </td>

                <td class="editor-label" style="width:110px;">
                    <label>道路运输证号</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" name="carEngNum" value="" style="width:175px;"/>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>年审日期</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" ame="produce" class="Wdate" onclick="WdatePicker({ dateFmt: 'yyyy-MM-dd'});" style="width:174px;"/>

                </td>

            </tr>

        </table>
    </div>
    <div class="easyui-panel" title="管理信息" style="float:left; width:100%;">
        <table class="editor-table" cellspacing="0">
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>是否欠费</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="checkbox" id="arrears" name="arrears"/>是
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>服务开始时间</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text" id="SVRStartTime" name="svrStartTime" class="Wdate"
                           onclick="WdatePicker({ dateFmt: 'yyyy-MM-dd', maxDate: '#F{$dp.$D(\'SVREndTime\')}', autoUpdateOnChanged: false });" style="width:174px;"/>
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>服务到期时间</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" id="SVREndTime" name="svrEndTime" class="Wdate"
                           onclick="WdatePicker({ dateFmt: 'yyyy-MM-dd', minDate: '#F{$dp.$D(\'SVRStartTime\')}', autoUpdateOnChanged: false });"
                           style="width:174px;"/>
                </td>
            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>服务费缴纳时间</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" id="ServicePayTime" name="ServicePayTime" class="Wdate" onclick="WdatePicker({ dateFmt: 'yyyy-MM-dd'});" style="width:174px;"/>

                </td>
                <td class="editor-label" style="width:110px;">
                    <label>服务费</label>
                </td>
                <td class="editor-field" colspan="1" style="width:203px;">
                    <input type="text"  name="serviceFee" value="" style="width:175px;"/> 元
                </td>
                <td class="editor-label" style="width:110px;">
                    <label>入网协议号</label>
                </td>
                <td class="editor-field" colspan="1" style="">
                    <input type="text" name="networkNo" value="" style="width:175px;"/>
                </td>

            </tr>
            <tr>
                <td class="editor-label" style="width:110px;">
                    <label>车辆备注</label>
                </td>
                <td class="editor-field" colspan="5" style="width:203px;">
                    <textarea  name="remark" style="width:750px;"></textarea>
                </td>
            </tr>

        </table>
    </div>
</form>
<script>
    <c:if test="${not empty vehicle}">
    $(function () {
        //需要延迟一点执行，等待页面所有组件都初始化好，再执行数据初始化
        setTimeout(function () {
            var vehicle = ${vehicle};
          
            $("#vehicle-form").form("load", vehicle);
        }, 200);
    });
    </c:if>

</script>
 