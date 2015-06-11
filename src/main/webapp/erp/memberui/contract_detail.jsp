<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建合同明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrContractService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrContractService.getIContractByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var contract = data.resultList[0];
            DWRUtil.setValue("contractCode",contract.contractCode);
            DWRUtil.setValue("contractName",contract.contractName);
            DWRUtil.setValue("contractLimitType",contract.contractLimitType);
            DWRUtil.setValue("contractStatus",contract.contractStatus);
            DWRUtil.setValue("contractTypeId",contract.contractTypeId);
            DWRUtil.setValue("contractBegindate",contract.contractBegindate);
            DWRUtil.setValue("contractEnddate",contract.contractEnddate);
            DWRUtil.setValue("contractContent",contract.contractContent);
            DWRUtil.setValue("contractFile",contract.contractFile);
            DWRUtil.setValue("memberId",contract.memberId);
            DWRUtil.setValue("servicePackageId",contract.servicePackageId);
            DWRUtil.setValue("contractPrice",contract.contractPrice);
            DWRUtil.setValue("signedDate",contract.signedDate);
            DWRUtil.setValue("processInstanceId",contract.processInstanceId);
            DWRUtil.setValue("firstOperator",contract.firstOperator);
            DWRUtil.setValue("firstOperatorTime",contract.firstOperatorTime);
            DWRUtil.setValue("lastOperator",contract.lastOperator);
            DWRUtil.setValue("lastOperatorTime",contract.lastOperatorTime);
            DWRUtil.setValue("memo",contract.memo);
            DWRUtil.setValue("dr",contract.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示新建合同相关信息！</label></div>
    <div class="detailtitle">新建合同明细</div>
    <table class="detailtable">
        <tr>
            <th>合同编码</th>
            <td id="contractCode" class="detailtabletd"></td>
            <th>合同名称</th>
            <td id="contractName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>期限类型</th>
            <td id="contractLimitType" class="detailtabletd"></td>
            <th>合同状态</th>
            <td id="contractStatus" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>合同类型</th>
            <td id="contractTypeId" class="detailtabletd"></td>
            <th>开始日期</th>
            <td id="contractBegindate" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>结束日期</th>
            <td id="contractEnddate" class="detailtabletd"></td>
            <th>合同内容</th>
            <td id="contractContent" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>附件地址</th>
            <td id="contractFile" class="detailtabletd"></td>
            <th>会员ID</th>
            <td id="memberId" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>套餐类型</th>
            <td id="servicePackageId" class="detailtabletd"></td>
            <th>合同金额</th>
            <td id="contractPrice" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>签订日期</th>
            <td id="signedDate" class="detailtabletd"></td>
            <th>流程ID</th>
            <td id="processInstanceId" class="detailtabletd"></td>
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
