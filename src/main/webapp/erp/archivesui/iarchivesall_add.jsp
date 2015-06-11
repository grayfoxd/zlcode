<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员综合查询！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员综合查询信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员综合查询</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrIarchivesallService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrIarchivesallService.getIArchivesStartByPk(pk,setIarchivesall);
    }
}

function setIarchivesall(data){
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
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrIarchivesallService.updateIArchivesStart(getIarchivesall(),updateCallback);
        }else{
            dwrIarchivesallService.saveIArchivesStart(getIarchivesall(),saveCallback);
        }
    }
}
function getIarchivesall(){
    var iarchivesall = new Object();
    if(<%=isedit%>){
        iarchivesall.primaryKey = '<%=pk%>';
    }
    iarchivesall.memberId = DWRUtil.getValue("memberId");
    iarchivesall.contractId = DWRUtil.getValue("contractId");
    iarchivesall.memberName = DWRUtil.getValue("memberName");
    iarchivesall.memberSex = DWRUtil.getValue("memberSex");
    iarchivesall.memberAge = DWRUtil.getValue("memberAge");
    iarchivesall.memberBirthday = DWRUtil.getValue("memberBirthday");
    iarchivesall.memberCountry = DWRUtil.getValue("memberCountry");
    iarchivesall.memberBirthplace = DWRUtil.getValue("memberBirthplace");
    iarchivesall.memberOriginplace = DWRUtil.getValue("memberOriginplace");
    iarchivesall.memberNation = DWRUtil.getValue("memberNation");
    iarchivesall.memberIdcard = DWRUtil.getValue("memberIdcard");
    iarchivesall.memberIsmarry = DWRUtil.getValue("memberIsmarry");
    iarchivesall.memberAddress = DWRUtil.getValue("memberAddress");
    iarchivesall.memberPhone = DWRUtil.getValue("memberPhone");
    iarchivesall.memberJointime = DWRUtil.getValue("memberJointime");
    iarchivesall.diseaseName = DWRUtil.getValue("diseaseName");
    iarchivesall.drugAllergy = DWRUtil.getValue("drugAllergy");
    iarchivesall.bloodType = DWRUtil.getValue("bloodType");
    iarchivesall.rh = DWRUtil.getValue("rh");
    iarchivesall.dr = DWRUtil.getValue("dr");
    return iarchivesall;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员综合查询成功！是否想继续添加会员综合查询？","reset();","继续添加","closePage();","关闭页面");
    }else{
        alertmsg(data);
    }
}
function updateCallback(data){
    //Btn.open();
    if(data.success){
        alertmsg(data,"closePage();");
    }else{
        alertmsg(data);
    }
}
function reset(){
    Sys.reload();
}
function closePage(){
    closeMDITab(<%=tab%>);
}
</script>
</head>
<body class="inputcls">
    <div class="formDetail">
        <div class="requdiv"><label id="helpTitle"></label></div>
        <div class="formTitle"><%=saveOrEdit%>会员综合查询</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;会员id</th>
                <td>
                    <input type="text" id="memberId" must="会员id不能为空!" formust="memberIdMust"></input><label id="memberIdMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;合同id</th>
                <td>
                    <input type="text" id="contractId" must="合同id不能为空!" formust="contractIdMust"></input><label id="contractIdMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input><label id="memberNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;会员性别</th>
                <td>
                    <input type="text" id="memberSex" must="会员性别不能为空!" formust="memberSexMust"></input><label id="memberSexMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;会员年龄</th>
                <td>
                    <input type="text" id="memberAge" must="会员年龄不能为空!" formust="memberAgeMust"></input><label id="memberAgeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;出生日期</th>
                <td>
                    <input type="text" id="memberBirthday" must="出生日期不能为空!" formust="memberBirthdayMust"></input><label id="memberBirthdayMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;国籍</th>
                <td>
                    <input type="text" id="memberCountry" must="国籍不能为空!" formust="memberCountryMust"></input><label id="memberCountryMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;出生地</th>
                <td>
                    <input type="text" id="memberBirthplace" must="出生地不能为空!" formust="memberBirthplaceMust"></input><label id="memberBirthplaceMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;籍贯</th>
                <td>
                    <input type="text" id="memberOriginplace" must="籍贯不能为空!" formust="memberOriginplaceMust"></input><label id="memberOriginplaceMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;民族</th>
                <td>
                    <input type="text" id="memberNation" must="民族不能为空!" formust="memberNationMust"></input><label id="memberNationMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;身份证号</th>
                <td>
                    <input type="text" id="memberIdcard" must="身份证号不能为空!" formust="memberIdcardMust"></input><label id="memberIdcardMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;婚姻</th>
                <td>
                    <input type="text" id="memberIsmarry" must="婚姻不能为空!" formust="memberIsmarryMust"></input><label id="memberIsmarryMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;住址</th>
                <td>
                    <input type="text" id="memberAddress" must="住址不能为空!" formust="memberAddressMust"></input><label id="memberAddressMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;电话</th>
                <td>
                    <input type="text" id="memberPhone" must="电话不能为空!" formust="memberPhoneMust"></input><label id="memberPhoneMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;入会时间</th>
                <td>
                    <input type="text" id="memberJointime" must="入会时间不能为空!" formust="memberJointimeMust"></input><label id="memberJointimeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;确诊疾病</th>
                <td>
                    <input type="text" id="diseaseName" must="确诊疾病不能为空!" formust="diseaseNameMust"></input><label id="diseaseNameMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;药物过敏</th>
                <td>
                    <input type="text" id="drugAllergy" must="药物过敏不能为空!" formust="drugAllergyMust"></input><label id="drugAllergyMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;血型</th>
                <td>
                    <input type="text" id="bloodType" must="血型不能为空!" formust="bloodTypeMust"></input><label id="bloodTypeMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;RH</th>
                <td>
                    <input type="text" id="rh" must="RH不能为空!" formust="rhMust"></input><label id="rhMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;是否删除</th>
                <td>
                    <input type="text" id="dr" must="是否删除不能为空!" formust="drMust"></input><label id="drMust"></label>
                </td>
            </tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员综合查询信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
