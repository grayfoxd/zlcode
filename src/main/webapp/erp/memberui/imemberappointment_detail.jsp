<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员预约明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrImemberappointmentService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrImemberappointmentService.getIMemberAppointmentByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var imemberappointment = data.resultList[0];
            DWRUtil.setValue("memberId",imemberappointment.memberId);
            DWRUtil.setValue("memberName",imemberappointment.memberName);
            DWRUtil.setValue("appointmentType",imemberappointment.appointmentType);
            DWRUtil.setValue("appointmentContent",imemberappointment.appointmentContent);
            DWRUtil.setValue("expectedTime",imemberappointment.expectedTime);
            DWRUtil.setValue("endTime",imemberappointment.endTime);
            DWRUtil.setValue("processInstanceId",imemberappointment.processInstanceId);
            DWRUtil.setValue("firstOperator",imemberappointment.firstOperator);
            DWRUtil.setValue("firstOperatorTime",imemberappointment.firstOperatorTime);
            DWRUtil.setValue("lastOperator",imemberappointment.lastOperator);
            DWRUtil.setValue("lastOperatorTime",imemberappointment.lastOperatorTime);
            DWRUtil.setValue("memo",imemberappointment.memo);
            DWRUtil.setValue("dr",imemberappointment.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员预约相关信息！</label></div>
    <div class="detailtitle">会员预约明细</div>
    <table class="detailtable">
        <tr>
            <th>会员ID</th>
            <td id="memberId" class="detailtabletd"></td>
            <th>会员姓名</th>
            <td id="memberName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>预约类型</th>
            <td id="appointmentType" class="detailtabletd"></td>
            <th>预约详情</th>
            <td id="appointmentContent" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>预约时间</th>
            <td id="expectedTime" class="detailtabletd"></td>
            <th>预约终结时间</th>
            <td id="endTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>流程ID</th>
            <td id="processInstanceId" class="detailtabletd"></td>
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
