<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的体检套餐！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑体检套餐信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>体检套餐</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrPhyPackageService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    dwrPhyPackageService.getIPhyPackageByPk('<%=pk%>', setPageValue);
}

function setPageValue(data) {
	if (data != null && data.resultList.length > 0) {
		var info = data.resultList[0];
		DWRUtil.setValue("packageName", info.packageName);
		DWRUtil.setValue("marketPrice", info.marketPrice);
		DWRUtil.setValue("actualPrice", info.actualPrice);
      	DWRUtil.setValue("gender", info.gender);
		DWRUtil.setValue("companyId", info.compnayId);
		DWRUtil.setValue("memo", info.memo);

		//get all related phy items
		
	}

}

function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项
		dwrPhyPackageService.updateIPhyPackage(getIPhyPackage(),DWRUtil.getValue("itemId"),updateCallback);
    }
}
function getIPhyPackage(){
    var iPhyPackage = new Object();
    
    iPhyPackage.packageName = DWRUtil.getValue("packageName");
    iPhyPackage.marketPrice = DWRUtil.getValue("marketPrice");
    iPhyPackage.actualPrice = DWRUtil.getValue("actualPrice");
    iPhyPackage.gender = getRadioValueByName("gender");
    iPhyPackage.compnayId = DWRUtil.getValue("compnayId");
    iPhyPackage.memo = DWRUtil.getValue("memo");
    return iPhyPackage;
}
function updateCallback(data){
	if (data.success) {
		alertmsg(data, "reset()");
	} else {
		alertmsg(data);
	}
}

function reset(){
    Sys.reload();
}
function closePage(){
    closeMDITab(<%=tab%>);
}
function getPhyItemId() {
	var box = SEL.getPhyItemIdsForPackage("check", "itemName",
			"itemId");
	box.show();
}
</script>
</head>
<body class="inputcls">
    <div class="formDetail">
        <div class="requdiv"><label id="helpTitle"></label></div>
        <div class="formTitle"><%=saveOrEdit%>体检套餐</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;套餐名称</th>
                <td>
                    <input type="text" id="packageName" must="套餐名称不能为空!" formust="packageNameMust"></input><label id="packageNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;市场价格</th>
                <td>
                    <input type="text" id="marketPrice" must="市场价格不能为空!" formust="marketPriceMust"></input><label id="marketPriceMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;实际价格</th>
                <td>
                    <input type="text" id="actualPrice" must="实际价格不能为空!" formust="actualPriceMust"></input><label id="actualPriceMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;适用性别</th>
                <td>
					<%=UtilTool.getRadioOptionsByEnum(EnumUtil.PHY_ITEM_GENDER.getSelectAndText(""),"gender")%>
				</td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;公司ID</th>
                <td>
                    <input type="text" id="companyId" must="公司ID不能为空!" formust="companyIdMust"></input><label id="companyIdMust"></label>
                </td>
            </tr>
            
            <tr>
            	<th>
					体检项目
				</th>
				<td>
					<input type="text" id=itemName class="takeform" readonly="readonly" linkclear="itemId" onclick="getPhyItemId()" style="color: #999">
					<input type="hidden" id="itemId" >
				</td>
            </tr>
            
            <tr>
				<th>
					备注
				</th>
				<td colspan="3">
					<textarea id="memo" style="width: 100%"></textarea>
				</td>
			</tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存体检套餐信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
