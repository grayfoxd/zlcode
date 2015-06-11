<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员消费明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrImemberconsumptionService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrImemberconsumptionService.getIMemberConsumptionByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var imemberconsumption = data.resultList[0];
            DWRUtil.setValue("memberId",imemberconsumption.memberId);
            DWRUtil.setValue("memberName",imemberconsumption.memberName);
            DWRUtil.setValue("consumptionContent",imemberconsumption.consumptionContent);
            DWRUtil.setValue("consumptionTime",imemberconsumption.consumptionTime);
            DWRUtil.setValue("firstOperator",imemberconsumption.firstOperator);
            DWRUtil.setValue("firstOperatorTime",imemberconsumption.firstOperatorTime);
            DWRUtil.setValue("lastOperator",imemberconsumption.lastOperator);
            DWRUtil.setValue("lastOperatorTime",imemberconsumption.lastOperatorTime);
            DWRUtil.setValue("memo",imemberconsumption.memo);
            DWRUtil.setValue("dr",imemberconsumption.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员消费相关信息！</label></div>
    <div class="detailtitle">会员消费明细</div>
    <table class="detailtable">
        <tr>
            <th>会员ID</th>
            <td id="memberId" class="detailtabletd"></td>
            <th>会员姓名</th>
            <td id="memberName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>消费明细</th>
            <td id="consumptionContent" class="detailtabletd"></td>
            <th>消费时间</th>
            <td id="consumptionTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>添加人</th>
            <td id="firstOperator" class="detailtabletd"></td>
            <th>添加时间</th>
            <td id="firstOperatorTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>最后修改人</th>
            <td id="lastOperator" class="detailtabletd"></td>
            <th>最后修改时间</th>
            <td id="lastOperatorTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>备注</th>
            <td id="memo" class="detailtabletd"></td>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
        </tr>
    </table>
</body>
</html>
