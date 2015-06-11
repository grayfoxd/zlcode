<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrI_memberService.js"></script>
<script type="text/javascript">
window.onload = function(){
	dwrI_memberService.getIMemberByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var imember = data.resultList[0];
            DWRUtil.setValue("memberId",imember.memberId);
            DWRUtil.setValue("memberName",imember.memberName);
            DWRUtil.setValue("memberSex",imember.memberSex);
            DWRUtil.setValue("memberAge",imember.memberAge);
            DWRUtil.setValue("memberBirthday",imember.memberBirthday);
            DWRUtil.setValue("memberCountry",imember.memberCountry);
            DWRUtil.setValue("memberBirthplace",imember.memberBirthplace);
            DWRUtil.setValue("memberOriginplace",imember.memberOriginplace);
            DWRUtil.setValue("memberNation",imember.memberNation);
            DWRUtil.setValue("memberIdcard",imember.memberIdcard);
            DWRUtil.setValue("memberIsmarry",imember.memberIsmarry);
            DWRUtil.setValue("memberAddress",imember.memberAddress);
            DWRUtil.setValue("memberPhone",imember.memberPhone);
            DWRUtil.setValue("memberJointime",imember.memberJointime);
            DWRUtil.setValue("bloodType",imember.bloodType);
            DWRUtil.setValue("rh",imember.rh);
            DWRUtil.setValue("companyId",imember.companyId);
            DWRUtil.setValue("firstOperator",imember.firstOperator);
            DWRUtil.setValue("firstOperatorTime",imember.firstOperatorTime);
            DWRUtil.setValue("lastOperator",imember.lastOperator);
            DWRUtil.setValue("lastOperatorTime",imember.lastOperatorTime);
            DWRUtil.setValue("memo",imember.memo);
            DWRUtil.setValue("dr",imember.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员信息相关信息！</label></div>
    <div class="detailtitle">会员信息明细</div>
    <table class="detailtable">
        <tr>
            <th>会员ID</th>
            <td id="memberId" class="detailtabletd"></td>
            <th>会员姓名</th>
            <td id="memberName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>会员性别</th>
            <td id="memberSex" class="detailtabletd"></td>
            <th>会员年龄</th>
            <td id="memberAge" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>出生日期</th>
            <td id="memberBirthday" class="detailtabletd"></td>
            <th>国籍</th>
            <td id="memberCountry" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>出生地</th>
            <td id="memberBirthplace" class="detailtabletd"></td>
            <th>籍贯</th>
            <td id="memberOriginplace" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>民族</th>
            <td id="memberNation" class="detailtabletd"></td>
            <th>身份证号</th>
            <td id="memberIdcard" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>婚姻</th>
            <td id="memberIsmarry" class="detailtabletd"></td>
            <th>住址</th>
            <td id="memberAddress" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>电话</th>
            <td id="memberPhone" class="detailtabletd"></td>
            <th>入会时间</th>
            <td id="memberJointime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>血型</th>
            <td id="bloodType" class="detailtabletd"></td>
            <th>rh</th>
            <td id="rh" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>公司ID</th>
            <td id="companyId" class="detailtabletd"></td>
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
