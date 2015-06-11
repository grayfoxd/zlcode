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
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>

<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
}

function save(){
    var warnArr = new Array();
    warnArr[0] = "packageNameMust";
	warnArr[1] = "marketPriceMust";
	warnArr[1] = "actualPriceMust";
	warnArr[1] = "compnayIdMust";
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项
		dwrPhyPackageService.saveIPhyPackage(getIPhyPackage(),DWRUtil.getValue("itemId"),saveCallback);
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
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加体检套餐成功！是否想继续添加体检套餐？","reset();","继续添加","closePage();","关闭页面");
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
function getPhyItemId() {
	var box = SEL.getPhyItemIdsForPackage("check", "itemName","itemId","getPhyItemIdCallback()");
	box.show();
}

function getPhyItemIdCallback(){
	var itemIds =document.getElementById("itemId").value;
	if(itemIds.length==0){
		return;
	}
	dwrPhyItemService.getIPhyItemsByPks(itemIds, getItemsCallback);
}

function getItemsCallback(data){
	var tab = document.getElementById("phyitems");
	if(data.success==true){
		var rlen = tab.rows.length;	
		for(var i=rlen-1;i>=1;i--){
			tab.deleteRow(i);
		}
		if(data.resultList.length > 0){
			for ( var i = 0; i < data.resultList.length; i++) {
				var item = data.resultList[i];
				//只有页子节点才可被使用
				if(item.isLeaf==1){
					var otr = tab.insertRow(-1);
					otr.id="tr"+item.primaryKey;
					var td1=document.createElement("td");
		        	td1.innerHTML = "<input type='checkbox' name='userchk' value='"+item.primaryKey+"'/>";
		        	var td2=document.createElement("td");
		        	td2.innerHTML = item.itemCode;
		        
		        	var td3=document.createElement("td");
		        	td3.innerHTML = item.itemName;
		        	var td4=document.createElement("td");
		        	if(item.gender == <%=EnumUtil.PHY_ITEM_GENDER.Male.value%>){
		        		td4.innerHTML = '<%=EnumUtil.PHY_ITEM_GENDER.valueOf(EnumUtil.PHY_ITEM_GENDER.Male.value)%>';
                	}else if(item.gender == <%=EnumUtil.PHY_ITEM_GENDER.Female.value%>){
                		td4.innerHTML = '<%=EnumUtil.PHY_ITEM_GENDER.valueOf(EnumUtil.PHY_ITEM_GENDER.Female.value)%>';
                	}else{
                		td4.innerHTML = '<%=EnumUtil.PHY_ITEM_GENDER.valueOf(EnumUtil.PHY_ITEM_GENDER.Both.value)%>';
                	}
		        
					var td5=document.createElement("td");
					td5.style.cssText ="text-align:center";
					td5.innerHTML="<a href='javascript:void(0)' onclick=\"delrow('"+item.primaryKey+"')\">删除</a>";

					otr.appendChild(td1);
		        	otr.appendChild(td2);
		        	otr.appendChild(td3);
		        	otr.appendChild(td4);
		        	otr.appendChild(td5);
				}
	        }
        }
	}else{
		alertmsg(data);
	}
}

function delrow(i){
	var tab = document.getElementById("phyitems");
	var row = document.getElementById("tr"+i);
	var rIndex = row.rowIndex;
	tab.deleteRow(rIndex);
	
	var itemId =DWRUtil.getValue("itemId");
	var itemIds = itemId.split(",");
	var tmpid="";
	for(var j=0;j<itemIds.length;j++){
		if(itemIds[j].length>0&&itemIds[j] != i){
			tmpid+= itemIds[j]+",";
		}
	}
	DWRUtil.setValue("itemId", tmpid);
}

function deletebatch(){
	var ids = getCheckedValues("userchk");
	for(var i=0;i<ids.length;i++){
		delrow(ids[i]);
	}
}


</script>
</head>
<body class="inputcls">
<input type="hidden" id="itemName" />
<input type="hidden" id="itemId" />
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
                    <input type="text" id="compnayId" must="公司ID不能为空!" formust="compnayIdMust"></input><label id="compnayIdMust"></label>
                </td>
            </tr>
            <tr>
				<th>
					备注
				</th>
				<td colspan="2">
					<textarea id="memo" style="width: 100%"></textarea>
				</td>
			</tr>
			<tr>
			<td><br/></td>
			</tr>
			<tr>
				<th valign="top">体检项目明细</th>
				<td valign="top" colspan="3">
					<div style="border: 1px solid #A6D0E8; width: 80%">
						<label id="phyitems1"></label>
						<table cellpadding='0' cellspacing='0' border='0' align='center'
							width='100%' />
							
							<tr
								style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/wbg.gif');"
								height="24px">
								<td align='left' style='padding-left: 10px; font-weight: bold;'></td>
								<td style="text-align: right;" nowrap="nowrap" align="right">
									<div class='div_btn'
										onmouseover='this.className ="div_btn_hover"'
										onmouseout='this.className ="div_btn"'
										onclick="deletebatch();">&nbsp;删除选中项目&nbsp;</div>
									<div class='div_btn'
										onmouseover='this.className ="div_btn_hover"'
										onmouseout='this.className ="div_btn"' onclick="getPhyItemId()">&nbsp;选择项目&nbsp;</div>
								</td>
							</tr>
							<tr>
								<td valign="top" colspan="2" height="240">
									<div style="overflow: auto; height: 100%; vertical-align: top;">
										<table class='tablerowStyleColor' cellSpacing='0'
											cellPadding='3' width='100%' align='center' border='1'
											id='phyitems'>
											<tr
												style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/fhbg.gif');">
												<td class='tableTitle1' style="text-align: center;"
													width="10px">
													<input type='checkbox' onclick="selectAll(this,'userchk')" title='全选/取消'></td>
												<td class='tableTitle1' style="text-align: center;">项目编码</td>
												<td class='tableTitle1' style="text-align: center;">项目名称</td>
												<td class='tableTitle1' style="text-align: center;">适用性别</td>
												<td class='tableTitle1' style="text-align: center;">操作</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
						</table>
					</div>
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
