<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员分类管理明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrContracttypeService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrContracttypeService.getIContractTypeByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var contracttype = data.resultList[0];
            DWRUtil.setValue("contractTypeCode",contracttype.contractTypeCode);
            DWRUtil.setValue("contractTypeName",contracttype.contractTypeName);
            DWRUtil.setValue("firstOperator",contracttype.firstOperator);
            DWRUtil.setValue("firstOperatorTime",contracttype.firstOperatorTime);
            DWRUtil.setValue("lastOperator",contracttype.lastOperator);
            DWRUtil.setValue("lastOperatorTime",contracttype.lastOperatorTime);
            DWRUtil.setValue("memo",contracttype.memo);
            DWRUtil.setValue("dr",contracttype.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员分类管理相关信息！</label></div>
    <div class="detailtitle">会员分类管理明细</div>
    <table class="detailtable">
        <tr>
            <th>分类编码</th>
            <td id="contractTypeCode" class="detailtabletd"></td>
            <th>分类名称</th>
            <td id="contractTypeName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>添加人</th>
            <td id="firstOperator" class="detailtabletd"></td>
            <th>最后修改人</th>
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
        </tr>
    </table>
</body>
</html>
