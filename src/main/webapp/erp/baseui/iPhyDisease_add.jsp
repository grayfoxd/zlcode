<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的疾病仓库维护！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑疾病仓库维护信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>疾病仓库维护</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrDiseaseService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrDiseaseService.getIPhyDiseaseByPk(pk,setIphydisease);
    }
}

function setIphydisease(data){
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
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrDiseaseService.updateIPhyDisease(getIphydisease(),updateCallback);
        }else{
            dwrDiseaseService.saveIPhyDisease(getIphydisease(),saveCallback);
        }
    }
}
function getIphydisease(){
    var iphydisease = new Object();
    if(<%=isedit%>){
        iphydisease.primaryKey = '<%=pk%>';
    }
    iphydisease.diseaseName = DWRUtil.getValue("diseaseName");
    iphydisease.diseaseComment = DWRUtil.getValue("diseaseComment");
    iphydisease.diseaseClinical = DWRUtil.getValue("diseaseClinical");
    iphydisease.diseaseAdvise = DWRUtil.getValue("diseaseAdvise");
    iphydisease.conditions = DWRUtil.getValue("conditions");
    iphydisease.conditionsDetail = DWRUtil.getValue("conditionsDetail");
    iphydisease.dr = DWRUtil.getValue("dr");
    return iphydisease;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加疾病仓库维护成功！是否想继续添加疾病仓库维护？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>疾病仓库维护</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;诊断名称</th>
                <td>
                    <input type="text" id="diseaseName" must="诊断名称不能为空!" formust="diseaseNameMust"></input><label id="diseaseNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;解说</th>
                <td>
                    <input type="text" id="diseaseComment" must="解说不能为空!" formust="diseaseCommentMust"></input><label id="diseaseCommentMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;临床意义</th>
                <td>
                    <input type="text" id="diseaseClinical" must="临床意义不能为空!" formust="diseaseClinicalMust"></input><label id="diseaseClinicalMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;建议</th>
                <td>
                    <input type="text" id="diseaseAdvise" must="建议不能为空!" formust="diseaseAdviseMust"></input><label id="diseaseAdviseMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;条件</th>
                <td>
                    <input type="text" id="conditions" must="条件不能为空!" formust="conditionsMust"></input><label id="conditionsMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;条件细节</th>
                <td>
                    <input type="text" id="conditionsDetail" must="条件细节不能为空!" formust="conditionsDetailMust"></input><label id="conditionsDetailMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;是否删除</th>
                <td>
                    <input type="text" id="dr" must="是否删除不能为空!" formust="drMust"></input><label id="drMust"></label>
                </td>
                <th></th><td></td>
            </tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存疾病仓库维护信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
