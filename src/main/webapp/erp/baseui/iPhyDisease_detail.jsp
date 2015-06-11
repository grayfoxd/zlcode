<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>疾病仓库维护明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrDiseaseService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrDiseaseService.getIPhyDiseaseByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iphydisease = data.resultList[0];
            DWRUtil.setValue("diseaseName",iphydisease.diseaseName);
            DWRUtil.setValue("diseaseComment",iphydisease.diseaseComment);
            DWRUtil.setValue("diseaseClinical",iphydisease.diseaseClinical);
            DWRUtil.setValue("diseaseAdvise",iphydisease.diseaseAdvise);
            DWRUtil.setValue("conditions",iphydisease.conditions);
            DWRUtil.setValue("conditionsDetail",iphydisease.conditionsDetail);
            DWRUtil.setValue("dr",iphydisease.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示疾病仓库维护相关信息！</label></div>
    <div class="detailtitle">疾病仓库维护明细</div>
    <table class="detailtable">
        <tr>
            <th>诊断名称</th>
            <td id="diseaseName" class="detailtabletd"></td>
            <th>解说</th>
            <td id="diseaseComment" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>临床意义</th>
            <td id="diseaseClinical" class="detailtabletd"></td>
            <th>建议</th>
            <td id="diseaseAdvise" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>条件</th>
            <td id="conditions" class="detailtabletd"></td>
            <th>条件细节</th>
            <td id="conditionsDetail" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
            <th></th><td></td>
        </tr>
    </table>
</body>
</html>
