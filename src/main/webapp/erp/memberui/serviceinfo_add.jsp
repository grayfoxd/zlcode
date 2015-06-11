<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的服务项目维护！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑服务项目维护信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>服务项目维护</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrService_infoService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrService_infoService.getIServiceInfoByPk(pk,setServiceinfo);
    }
}

function setServiceinfo(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var serviceinfo = data.resultList[0];
            DWRUtil.setValue("serviceInfoCode",serviceinfo.serviceInfoCode);
            DWRUtil.setValue("serviceInfoName",serviceinfo.serviceInfoName);
            DWRUtil.setValue("crowd",serviceinfo.crowd);
            DWRUtil.setValue("measuringUnit",serviceinfo.measuringUnit);
            DWRUtil.setValue("measuringUnitPrice",serviceinfo.measuringUnitPrice);
            DWRUtil.setValue("firstOperator",serviceinfo.firstOperator);
            DWRUtil.setValue("firstOperatorTime",serviceinfo.firstOperatorTime);
            DWRUtil.setValue("lastOperator",serviceinfo.lastOperator);
            DWRUtil.setValue("lastOperatorTime",serviceinfo.lastOperatorTime);
            DWRUtil.setValue("memo",serviceinfo.memo);
            DWRUtil.setValue("dr",serviceinfo.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrService_infoService.updateIServiceInfo(getServiceinfo(),updateCallback);
        }else{
            dwrService_infoService.saveIServiceInfo(getServiceinfo(),saveCallback);
        }
    }
}
function getServiceinfo(){
    var serviceinfo = new Object();
    if(<%=isedit%>){
        serviceinfo.primaryKey = '<%=pk%>';
    }
    serviceinfo.serviceInfoCode = DWRUtil.getValue("serviceInfoCode");
    serviceinfo.serviceInfoName = DWRUtil.getValue("serviceInfoName");
    serviceinfo.crowd = DWRUtil.getValue("crowd");
    serviceinfo.measuringUnit = DWRUtil.getValue("measuringUnit");
    serviceinfo.measuringUnitPrice = DWRUtil.getValue("measuringUnitPrice");
    serviceinfo.firstOperator = DWRUtil.getValue("firstOperator");
    serviceinfo.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    serviceinfo.lastOperator = DWRUtil.getValue("lastOperator");
    serviceinfo.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    serviceinfo.memo = DWRUtil.getValue("memo");
    serviceinfo.dr = DWRUtil.getValue("dr");
    return serviceinfo;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加服务项目维护成功！是否想继续添加服务项目维护？","reset();","继续添加","closePage();","关闭页面");
    }else{
        alertmsg(data);
    }
}
function updateCallback(data){
    //Btn.open();
    if(data.success){
        alertmsg(data,"closePage();");
    }else{
        alertmsg(data);
    }
}
function reset(){
    Sys.reload();
}
function closePage(){
    closeMDITab(<%=tab%>);
}
</script>
</head>
<body class="inputcls">
    <div class="formDetail">
        <div class="requdiv"><label id="helpTitle"></label></div>
        <div class="formTitle"><%=saveOrEdit%>服务项目维护</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;编码</th>
                <td>
                    <input type="text" id="serviceInfoCode" must="编码不能为空!" formust="serviceInfoCodeMust"></input><label id="serviceInfoCodeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;名称</th>
                <td>
                    <input type="text" id="serviceInfoName" must="名称不能为空!" formust="serviceInfoNameMust"></input><label id="serviceInfoNameMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;适用人群</th>
                <td>
                    <input type="text" id="crowd" must="适用人群不能为空!" formust="crowdMust"></input><label id="crowdMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;计量单位</th>
                <td>
                    <input type="text" id="measuringUnit" must="计量单位不能为空!" formust="measuringUnitMust"></input><label id="measuringUnitMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;计量单价</th>
                <td>
                    <input type="text" id="measuringUnitPrice" must="计量单价不能为空!" formust="measuringUnitPriceMust"></input><label id="measuringUnitPriceMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;添加人</th>
                <td>
                    <input type="text" id="firstOperator" must="添加人不能为空!" formust="firstOperatorMust"></input><label id="firstOperatorMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;添加时间</th>
                <td>
                    <input type="text" id="firstOperatorTime" must="添加时间不能为空!" formust="firstOperatorTimeMust"></input><label id="firstOperatorTimeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;最后修改人</th>
                <td>
                    <input type="text" id="lastOperator" must="最后修改人不能为空!" formust="lastOperatorMust"></input><label id="lastOperatorMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;最后修改时间</th>
                <td>
                    <input type="text" id="lastOperatorTime" must="最后修改时间不能为空!" formust="lastOperatorTimeMust"></input><label id="lastOperatorTimeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;备注</th>
                <td>
                    <input type="text" id="memo" must="备注不能为空!" formust="memoMust"></input><label id="memoMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;是否删除</th>
                <td>
                    <input type="text" id="dr" must="是否删除不能为空!" formust="drMust"></input><label id="drMust"></label>
                </td>
                <th></th><td></td>
            </tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存服务项目维护信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
