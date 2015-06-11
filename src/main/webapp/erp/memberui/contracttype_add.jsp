<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员分类管理！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员分类管理信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员分类管理</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrContracttypeService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrContracttypeService.getIContractTypeByPk(pk,setContracttype);
    }
}

function setContracttype(data){
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
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrContracttypeService.updateIContractType(getContracttype(),updateCallback);
        }else{
            dwrContracttypeService.saveIContractType(getContracttype(),saveCallback);
        }
    }
}
function getContracttype(){
    var contracttype = new Object();
    if(<%=isedit%>){
        contracttype.primaryKey = '<%=pk%>';
    }
    contracttype.contractTypeCode = DWRUtil.getValue("contractTypeCode");
    contracttype.contractTypeName = DWRUtil.getValue("contractTypeName");
    contracttype.firstOperator = DWRUtil.getValue("firstOperator");
    contracttype.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    contracttype.lastOperator = DWRUtil.getValue("lastOperator");
    contracttype.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    contracttype.memo = DWRUtil.getValue("memo");
    contracttype.dr = DWRUtil.getValue("dr");
    return contracttype;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员分类管理成功！是否想继续添加会员分类管理？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>会员分类管理</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;分类编码</th>
                <td>
                    <input type="text" id="contractTypeCode" must="分类编码不能为空!" formust="contractTypeCodeMust"></input><label id="contractTypeCodeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;分类名称</th>
                <td>
                    <input type="text" id="contractTypeName" must="分类名称不能为空!" formust="contractTypeNameMust"></input><label id="contractTypeNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;备注</th>
                <td colspan="1">
                    <input type="text" id="memo" must="备注不能为空!" formust="memoMust"></input><label id="memoMust"></label>
                </td>
            </tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员分类管理信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
