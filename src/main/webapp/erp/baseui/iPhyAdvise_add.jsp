<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的诊断建议库！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑诊断建议库信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>诊断建议库</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrAdviseService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrAdviseService.getIPhyAdviseByPk(pk,setIphyadvise);
    }
}

function setIphyadvise(data){
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
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrAdviseService.updateIPhyAdvise(getIphyadvise(),updateCallback);
        }else{
            dwrAdviseService.saveIPhyAdvise(getIphyadvise(),saveCallback);
        }
    }
}
function getIphyadvise(){
    var iphyadvise = new Object();
    if(<%=isedit%>){
        iphyadvise.primaryKey = '<%=pk%>';
    }
    iphyadvise.iPhyDiseaseId = DWRUtil.getValue("iPhyDiseaseId");
    iphyadvise.diseaseName = DWRUtil.getValue("diseaseName");
    iphyadvise.adviseDiet = DWRUtil.getValue("adviseDiet");
    iphyadvise.adviseSport = DWRUtil.getValue("adviseSport");
    iphyadvise.adviseLifestyle = DWRUtil.getValue("adviseLifestyle");
    iphyadvise.adviseCare = DWRUtil.getValue("adviseCare");
    iphyadvise.dr = DWRUtil.getValue("dr");
    return iphyadvise;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加诊断建议库成功！是否想继续添加诊断建议库？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>诊断建议库</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;疾病主键</th>
                <td>
                    <input type="text" id="iPhyDiseaseId" must="疾病主键不能为空!" formust="iPhyDiseaseIdMust"></input><label id="iPhyDiseaseIdMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;疾病名称</th>
                <td>
                    <input type="text" id="diseaseName" must="疾病名称不能为空!" formust="diseaseNameMust"></input><label id="diseaseNameMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;合理饮食</th>
                <td>
                    <input type="text" id="adviseDiet" must="合理饮食不能为空!" formust="adviseDietMust"></input><label id="adviseDietMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;坚持运动</th>
                <td>
                    <input type="text" id="adviseSport" must="坚持运动不能为空!" formust="adviseSportMust"></input><label id="adviseSportMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;生活方式</th>
                <td>
                    <input type="text" id="adviseLifestyle" must="生活方式不能为空!" formust="adviseLifestyleMust"></input><label id="adviseLifestyleMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;跟进检测</th>
                <td>
                    <input type="text" id="adviseCare" must="跟进检测不能为空!" formust="adviseCareMust"></input><label id="adviseCareMust"></label>
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
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存诊断建议库信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
