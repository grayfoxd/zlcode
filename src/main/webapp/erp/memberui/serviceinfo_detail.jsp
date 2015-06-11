<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务项目维护明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrService_infoService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrService_infoService.getIServiceInfoByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
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
</script>
</head>
<body class="inputdetail">
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示服务项目维护相关信息！</label></div>
    <div class="detailtitle">服务项目维护明细</div>
    <table class="detailtable">
        <tr>
            <th>编码</th>
            <td id="serviceInfoCode" class="detailtabletd"></td>
            <th>名称</th>
            <td id="serviceInfoName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>适用人群</th>
            <td id="crowd" class="detailtabletd"></td>
            <th>计量单位</th>
            <td id="measuringUnit" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>计量单价</th>
            <td id="measuringUnitPrice" class="detailtabletd"></td>
            <th>添加人</th>
            <td id="firstOperator" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>添加时间</th>
            <td id="firstOperatorTime" class="detailtabletd"></td>
            <th>最后修改人</th>
            <td id="lastOperator" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>最后修改时间</th>
            <td id="lastOperatorTime" class="detailtabletd"></td>
            <th>备注</th>
            <td id="memo" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
            <th></th><td></td>
        </tr>
    </table>
</body>
</html>
