<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司管理明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrsyscompanyService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrsyscompanyService.getISysCompayByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var isyscompay = data.resultList[0];
            DWRUtil.setValue("provinceCode",isyscompay.provinceCode);
            DWRUtil.setValue("districtCode",isyscompay.districtCode);
            DWRUtil.setValue("companyArea",isyscompay.companyArea);
            DWRUtil.setValue("companyInfoName",isyscompay.companyInfoName);
            DWRUtil.setValue("companyShortName",isyscompay.companyShortName);
            DWRUtil.setValue("companyInfoAdder",isyscompay.companyInfoAdder);
            DWRUtil.setValue("companyInfoEmployee",isyscompay.companyInfoEmployee);
            DWRUtil.setValue("adviseCare",isyscompay.adviseCare);
            DWRUtil.setValue("companyInfoPhone",isyscompay.companyInfoPhone);
            DWRUtil.setValue("companyInfoEmail",isyscompay.companyInfoEmail);
            DWRUtil.setValue("dr",isyscompay.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示公司管理相关信息！</label></div>
    <div class="detailtitle">公司管理明细</div>
    <table class="detailtable">
        <tr>
            <th>省份</th>
            <td id="provinceCode" class="detailtabletd"></td>
            <th>市区</th>
            <td id="districtCode" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>区</th>
            <td id="companyArea" class="detailtabletd"></td>
            <th>公司全名</th>
            <td id="companyInfoName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>公司简称</th>
            <td id="companyShortName" class="detailtabletd"></td>
            <th>详细地址</th>
            <td id="companyInfoAdder" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>联系人</th>
            <td id="companyInfoEmployee" class="detailtabletd"></td>
            <th>职务</th>
            <td id="adviseCare" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>联系电话</th>
            <td id="companyInfoPhone" class="detailtabletd"></td>
            <th>E-amil</th>
            <td id="companyInfoEmail" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>删除</th>
            <td id="dr" class="detailtabletd"></td>
            <th></th><td></td>
        </tr>
    </table>
</body>
</html>
