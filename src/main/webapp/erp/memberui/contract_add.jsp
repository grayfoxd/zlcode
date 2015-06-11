<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的新建合同！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑新建合同信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>新建合同</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrContractService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrContractService.getIContractByPk(pk,setContract);
    }
}

function setContract(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var contract = data.resultList[0];
            DWRUtil.setValue("contractCode",contract.contractCode);
            DWRUtil.setValue("contractName",contract.contractName);
            DWRUtil.setValue("contractLimitType",contract.contractLimitType);
            DWRUtil.setValue("contractStatus",contract.contractStatus);
            DWRUtil.setValue("contractTypeId",contract.contractTypeId);
            DWRUtil.setValue("contractBegindate",contract.contractBegindate);
            DWRUtil.setValue("contractEnddate",contract.contractEnddate);
            DWRUtil.setValue("contractContent",contract.contractContent);
            DWRUtil.setValue("contractFile",contract.contractFile);
            DWRUtil.setValue("memberId",contract.memberId);
            DWRUtil.setValue("servicePackageId",contract.servicePackageId);
            DWRUtil.setValue("contractPrice",contract.contractPrice);
            DWRUtil.setValue("signedDate",contract.signedDate);
            DWRUtil.setValue("processInstanceId",contract.processInstanceId);
            DWRUtil.setValue("firstOperator",contract.firstOperator);
            DWRUtil.setValue("firstOperatorTime",contract.firstOperatorTime);
            DWRUtil.setValue("lastOperator",contract.lastOperator);
            DWRUtil.setValue("lastOperatorTime",contract.lastOperatorTime);
            DWRUtil.setValue("memo",contract.memo);
            DWRUtil.setValue("dr",contract.dr);
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
            dwrContractService.updateIContract(getContract(),updateCallback);
        }else{
            dwrContractService.saveIContract(getContract(),saveCallback);
        }
    }
}
function getContract(){
    var contract = new Object();
    if(<%=isedit%>){
        contract.primaryKey = '<%=pk%>';
    }
    contract.contractCode = DWRUtil.getValue("contractCode");
    contract.contractName = DWRUtil.getValue("contractName");
    contract.contractLimitType = DWRUtil.getValue("contractLimitType");
    contract.contractStatus = DWRUtil.getValue("contractStatus");
    contract.contractTypeId = DWRUtil.getValue("contractTypeId");
    contract.contractBegindate = DWRUtil.getValue("contractBegindate");
    contract.contractEnddate = DWRUtil.getValue("contractEnddate");
    contract.contractContent = DWRUtil.getValue("contractContent");
    contract.contractFile = DWRUtil.getValue("contractFile");
    contract.memberId = DWRUtil.getValue("memberId");
    contract.servicePackageId = DWRUtil.getValue("servicePackageId");
    contract.contractPrice = DWRUtil.getValue("contractPrice");
    contract.signedDate = DWRUtil.getValue("signedDate");
    contract.processInstanceId = DWRUtil.getValue("processInstanceId");
    contract.firstOperator = DWRUtil.getValue("firstOperator");
    contract.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    contract.lastOperator = DWRUtil.getValue("lastOperator");
    contract.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    contract.memo = DWRUtil.getValue("memo");
    contract.dr = DWRUtil.getValue("dr");
    return contract;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加新建合同成功！是否想继续添加新建合同？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>新建合同</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;合同编码</th>
                <td>
                    <input type="text" id="contractCode" must="合同编码不能为空!" formust="contractCodeMust"></input><label id="contractCodeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;合同名称</th>
                <td>
                    <input type="text" id="contractName" must="合同名称不能为空!" formust="contractNameMust"></input><label id="contractNameMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;期限类型</th>
                <td>
                    <input type="text" id="contractLimitType" must="期限类型不能为空!" formust="contractLimitTypeMust"></input><label id="contractLimitTypeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;合同状态</th>
                <td>
                    <input type="text" id="contractStatus" must="合同状态不能为空!" formust="contractStatusMust"></input><label id="contractStatusMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;合同类型</th>
                <td>
                    <input type="text" id="contractTypeId" must="合同类型不能为空!" formust="contractTypeIdMust"></input><label id="contractTypeIdMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;开始日期</th>
                <td>
                    <input type="text" id="contractBegindate" must="开始日期不能为空!" formust="contractBegindateMust"></input><label id="contractBegindateMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;结束日期</th>
                <td>
                    <input type="text" id="contractEnddate" must="结束日期不能为空!" formust="contractEnddateMust"></input><label id="contractEnddateMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;合同内容</th>
                <td>
                    <input type="text" id="contractContent" must="合同内容不能为空!" formust="contractContentMust"></input><label id="contractContentMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;附件地址</th>
                <td>
                    <input type="text" id="contractFile" must="附件地址不能为空!" formust="contractFileMust"></input><label id="contractFileMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;会员ID</th>
                <td>
                    <input type="text" id="memberId" must="会员ID不能为空!" formust="memberIdMust"></input><label id="memberIdMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;套餐类型</th>
                <td>
                    <input type="text" id="servicePackageId" must="套餐类型不能为空!" formust="servicePackageIdMust"></input><label id="servicePackageIdMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;合同金额</th>
                <td>
                    <input type="text" id="contractPrice" must="合同金额不能为空!" formust="contractPriceMust"></input><label id="contractPriceMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;签订日期</th>
                <td>
                    <input type="text" id="signedDate" must="签订日期不能为空!" formust="signedDateMust"></input><label id="signedDateMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;流程ID</th>
                <td>
                    <input type="text" id="processInstanceId" must="流程ID不能为空!" formust="processInstanceIdMust"></input><label id="processInstanceIdMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;添加人</th>
                <td>
                    <input type="text" id="firstOperator" must="添加人不能为空!" formust="firstOperatorMust"></input><label id="firstOperatorMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;添加时间</th>
                <td>
                    <input type="text" id="firstOperatorTime" must="添加时间不能为空!" formust="firstOperatorTimeMust"></input><label id="firstOperatorTimeMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;最后修改人</th>
                <td>
                    <input type="text" id="lastOperator" must="最后修改人不能为空!" formust="lastOperatorMust"></input><label id="lastOperatorMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;最后修改时间</th>
                <td>
                    <input type="text" id="lastOperatorTime" must="最后修改时间不能为空!" formust="lastOperatorTimeMust"></input><label id="lastOperatorTimeMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;备注</th>
                <td>
                    <input type="text" id="memo" must="备注不能为空!" formust="memoMust"></input><label id="memoMust"></label>
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
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存新建合同信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
