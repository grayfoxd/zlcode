<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员综合查询明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrIarchivesallService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrIarchivesallService.getIArchivesStartByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchivesall = data.resultList[0];
            DWRUtil.setValue("memberId",iarchivesall.memberId);
            DWRUtil.setValue("contractId",iarchivesall.contractId);
            DWRUtil.setValue("memberName",iarchivesall.memberName);
            DWRUtil.setValue("memberSex",iarchivesall.memberSex);
            DWRUtil.setValue("memberAge",iarchivesall.memberAge);
            DWRUtil.setValue("memberBirthday",iarchivesall.memberBirthday);
            DWRUtil.setValue("memberCountry",iarchivesall.memberCountry);
            DWRUtil.setValue("memberBirthplace",iarchivesall.memberBirthplace);
            DWRUtil.setValue("memberOriginplace",iarchivesall.memberOriginplace);
            DWRUtil.setValue("memberNation",iarchivesall.memberNation);
            DWRUtil.setValue("memberIdcard",iarchivesall.memberIdcard);
            DWRUtil.setValue("memberIsmarry",iarchivesall.memberIsmarry);
            DWRUtil.setValue("memberAddress",iarchivesall.memberAddress);
            DWRUtil.setValue("memberPhone",iarchivesall.memberPhone);
            DWRUtil.setValue("memberJointime",iarchivesall.memberJointime);
            DWRUtil.setValue("diseaseName",iarchivesall.diseaseName);
            DWRUtil.setValue("drugAllergy",iarchivesall.drugAllergy);
            DWRUtil.setValue("bloodType",iarchivesall.bloodType);
            DWRUtil.setValue("rh",iarchivesall.rh);
            DWRUtil.setValue("dr",iarchivesall.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员综合查询相关信息！</label></div>
    <div class="detailtitle">会员综合查询明细</div>
    <table class="detailtable">
        <tr>
            <th>会员id</th>
            <td id="memberId" class="detailtabletd"></td>
            <th>合同id</th>
            <td id="contractId" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>会员姓名</th>
            <td id="memberName" class="detailtabletd"></td>
            <th>会员性别</th>
            <td id="memberSex" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>会员年龄</th>
            <td id="memberAge" class="detailtabletd"></td>
            <th>出生日期</th>
            <td id="memberBirthday" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>国籍</th>
            <td id="memberCountry" class="detailtabletd"></td>
            <th>出生地</th>
            <td id="memberBirthplace" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>籍贯</th>
            <td id="memberOriginplace" class="detailtabletd"></td>
            <th>民族</th>
            <td id="memberNation" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>身份证号</th>
            <td id="memberIdcard" class="detailtabletd"></td>
            <th>婚姻</th>
            <td id="memberIsmarry" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>住址</th>
            <td id="memberAddress" class="detailtabletd"></td>
            <th>电话</th>
            <td id="memberPhone" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>入会时间</th>
            <td id="memberJointime" class="detailtabletd"></td>
            <th>确诊疾病</th>
            <td id="diseaseName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>药物过敏</th>
            <td id="drugAllergy" class="detailtabletd"></td>
            <th>血型</th>
            <td id="bloodType" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>RH</th>
            <td id="rh" class="detailtabletd"></td>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
        </tr>
    </table>
</body>
</html>
