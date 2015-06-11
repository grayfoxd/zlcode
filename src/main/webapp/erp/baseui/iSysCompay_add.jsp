<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的公司管理！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑公司管理信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>公司管理</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrsyscompanyService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrsyscompanyService.getISysCompayByPk(pk,setIsyscompay);
    }
}

function setIsyscompay(data){
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
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrsyscompanyService.updateISysCompay(getIsyscompay(),updateCallback);
        }else{
            dwrsyscompanyService.saveISysCompay(getIsyscompay(),saveCallback);
        }
    }
}
function getIsyscompay(){
    var isyscompay = new Object();
    if(<%=isedit%>){
        isyscompay.primaryKey = '<%=pk%>';
    }
    isyscompay.provinceCode = DWRUtil.getValue("provinceCode");
    isyscompay.districtCode = DWRUtil.getValue("districtCode");
    isyscompay.companyArea = DWRUtil.getValue("companyArea");
    isyscompay.companyInfoName = DWRUtil.getValue("companyInfoName");
    isyscompay.companyShortName = DWRUtil.getValue("companyShortName");
    isyscompay.companyInfoAdder = DWRUtil.getValue("companyInfoAdder");
    isyscompay.companyInfoEmployee = DWRUtil.getValue("companyInfoEmployee");
    isyscompay.adviseCare = DWRUtil.getValue("adviseCare");
    isyscompay.companyInfoPhone = DWRUtil.getValue("companyInfoPhone");
    isyscompay.companyInfoEmail = DWRUtil.getValue("companyInfoEmail");
    isyscompay.dr = DWRUtil.getValue("dr");
    return isyscompay;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加公司管理成功！是否想继续添加公司管理？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>公司管理</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;省份</th>
                <td>
               		<div class="selectdiv"  style="float: left;margin-right: 5px;"><SELECT name=province id="province"></SELECT></div>
                </td>
                <th><em>*</em>&nbsp;&nbsp;市区</th>
                <td>
                <div class="selectdiv"  style="float: left;margin-right: 5px;"><SELECT name=city id="city"></SELECT></div>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;区</th>
                <td>
                	<div class="selectdiv"  style="float: left"><SELECT name=area id="area"></SELECT></div>
                </td>
                <th><em>*</em>&nbsp;&nbsp;公司全名</th>
                <td>
                    <input type="text" id="companyInfoName" must="公司全名不能为空!" formust="companyInfoNameMust"></input><label id="companyInfoNameMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;公司简称</th>
                <td>
                    <input type="text" id="companyShortName" must="公司简称不能为空!" formust="companyShortNameMust"></input><label id="companyShortNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;详细地址</th>
                <td>
                    <input type="text" id="companyInfoAdder" must="详细地址不能为空!" formust="companyInfoAdderMust"></input><label id="companyInfoAdderMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;联系人</th>
                <td>
                    <input type="text" id="companyInfoEmployee" must="联系人不能为空!" formust="companyInfoEmployeeMust"></input><label id="companyInfoEmployeeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;职务</th>
                <td>
                    <input type="text" id="adviseCare" must="职务不能为空!" formust="adviseCareMust"></input><label id="adviseCareMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;联系电话</th>
                <td>
                    <input type="text" id="companyInfoPhone" must="联系电话不能为空!" formust="companyInfoPhoneMust"></input><label id="companyInfoPhoneMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;E-amil</th>
                <td>
                    <input type="text" id="companyInfoEmail" must="E-amil不能为空!" formust="companyInfoEmailMust"></input><label id="companyInfoEmailMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;删除</th>
                <td>
                    <input type="text" id="dr" must="删除不能为空!" formust="drMust"></input><label id="drMust"></label>
                </td>
                <th></th><td></td>
            </tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存公司管理信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
