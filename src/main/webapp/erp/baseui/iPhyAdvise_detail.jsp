<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诊断建议库明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrAdviseService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrAdviseService.getIPhyAdviseByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iphyadvise = data.resultList[0];
            DWRUtil.setValue("iPhyDiseaseId",iphyadvise.iPhyDiseaseId);
            DWRUtil.setValue("diseaseName",iphyadvise.diseaseName);
            DWRUtil.setValue("adviseDiet",iphyadvise.adviseDiet);
            DWRUtil.setValue("adviseSport",iphyadvise.adviseSport);
            DWRUtil.setValue("adviseLifestyle",iphyadvise.adviseLifestyle);
            DWRUtil.setValue("adviseCare",iphyadvise.adviseCare);
            DWRUtil.setValue("dr",iphyadvise.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示诊断建议库相关信息！</label></div>
    <div class="detailtitle">诊断建议库明细</div>
    <table class="detailtable">
        <tr>
            <th>疾病主键</th>
            <td id="iPhyDiseaseId" class="detailtabletd"></td>
            <th>疾病名称</th>
            <td id="diseaseName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>合理饮食</th>
            <td id="adviseDiet" class="detailtabletd"></td>
            <th>坚持运动</th>
            <td id="adviseSport" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>生活方式</th>
            <td id="adviseLifestyle" class="detailtabletd"></td>
            <th>跟进检测</th>
            <td id="adviseCare" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
            <th></th><td></td>
        </tr>
    </table>
</body>
</html>
