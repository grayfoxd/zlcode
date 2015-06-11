<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的项目！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑新建项目信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加项目目录</title>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>
<script type="text/javascript">

window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}

function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrPhyItemService.getIPhyItemByPk(pk,setPageValue);
    }
}

	function savePhyItem() {
		var warnArr = new Array();
		warnArr[0] = "itemCodeMust";
		warnArr[1] = "itemNameMust";
		warnInit(warnArr);
		var bl = validvalue('helpTitle');

		if (bl) {
			var desc = DWRUtil.getValue("memo");
			if (desc.length > 100) {
				setMustWarn("memoMust", "备注不能超过100字符");
				return;
			}
			Btn.close();
			if(<%=isedit%>){
				dwrPhyItemService.updatePhyItem(getPhyItem(),
					updateCallback);
			}else{
				dwrPhyItemService.saveIPhyItem(getPhyItem(), saveCallback) 
			}
		}
	}


	function saveCallback(data){
		Btn.open();//开放按钮
		if (data.success) {
			alertmsg(data, "reload()");
		} else {
			alertmsg(data);
		}
	}
	
	function updateCallback(data) {
		Btn.open();//开放按钮
		if (data.success) {
			alertmsg(data, "reload()");
		} else {
			alertmsg(data);
		}
	}
	
	function reload() {
		closeMDITab(<%=request.getParameter("tab")%>, "", "tree");
	}

	function getPhyItem() {
		var info = new Object();
		info.itemCode = DWRUtil.getValue("itemCode");
		info.itemName = DWRUtil.getValue("itemName");
		info.gender = getRadioValueByName("gender");
		info.displaySequence = DWRUtil.getValue("displaySequence");
		info.retrieveCode = DWRUtil.getValue("retrieveCode");
		info.parentId = DWRUtil.getValue("parentId");
		info.isLeaf = getRadioValueByName("isLeaf");
		info.memo = DWRUtil.getValue("memo");
		return info;
	}

	function setPageValue(data) {
		if (data != null && data.resultList.length > 0) {
			var info = data.resultList[0];
			DWRUtil.setValue("itemCode", info.itemCode);
			DWRUtil.setValue("itemName", info.itemName);
			DWRUtil.setValue("gender", info.gender);
			DWRUtil.setValue("displaySequence", info.displaySequence);
			DWRUtil.setValue("retrieveCode", info.retrieveCode);
			DWRUtil.setValue("parentId", info.parentId);
			DWRUtil.setValue("isLeaf", info.isLeaf);
			DWRUtil.setValue("memo", info.memo);

		}

	}

	function getPhyItemUpid() {
		var box = SEL.getPhyItemIds("radio", "parentName",
				"parentId");
		box.show();
	}

	/*
	function getImg() {
		var box = SEL.getImg("projectimg", "imageSrc");
		box.show();
	}
	*/
</script>
</head>
<body class="inputcls">
		<div class="formDetail">
			<div class="requdiv">
				<label id="helpTitle"></label>
			</div>
			<div class="formTitle">
				添加项目信息
			</div>
			<div>
				<table class="inputtable" border="0">
					<tr>
						
						<th width="15%">
							<em>* </em>项目编码
						</th>
						<td>
							<input type="text" id="itemCode" maxlength="50" must="项目编码不能为空。" formust="itemCodeMust">
							<label id="itemCodeMust"></label>
						</td>
					</tr>
					
					<tr>
						<th>
							<em>* </em>项目名称
						</th>
						<td>
							<input type="text" id="itemName" maxlength="9" formust="itemNameMust" must="项目名称不能为空">
							<label id="itemNameMust"></label>
						</td>
						<th>
							<em>* </em>显示顺序
						</th>
						<td>
							<input type="text" id="displaySequence" maxlength="9" class="numform" >
							
						</td>
						
					</tr>
					
					<tr>
						<th>
							<em>* </em>适用性别
						</th>
						<td>
							 <%=UtilTool.getRadioOptionsByEnum(EnumUtil.PHY_ITEM_GENDER.getSelectAndText(""),"gender")%>
						</td>
						<th>
							<em>* </em>检索编码
						</th>
						<td>
							<input type="text" id="retrieveCode" maxlength="50" >
							
						</td>
						
					</tr>
					
					<tr>
						<th>
							上级项目
						</th>
						<td>
						<input type="text" id=parentName class="takeform" readonly="readonly" linkclear="parentId" onclick="getPhyItemUpid()" style="color: #999">
							<input type="hidden" id="parentId" >
						</td>
						
						<th>
							是否叶子结点
						</th>
						<td>
							 <%=UtilTool.getRadioOptionsByEnum(EnumUtil.PHY_ITEM_IS_LEAF.getSelectAndText(""),"isLeaf")%>
						</td>
					</tr>

					<tr>
						<th></th>
						<td colspan="3" id="memoMust"></td>
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
				<br />
			</div>
		</div>
		<br />
		<table align="center">
			<tr>
				<td>
					<btn:btn onclick="savePhyItem();" value="保 存 "
						imgsrc="../../images/png-1718.png" title="保存功能目录"></btn:btn>
				</td>
				<td style="width: 10px;"></td>
				<td>
					<btn:btn onclick="reload()" value="关 闭 "
						imgsrc="../../images/winclose.png" title="关闭当前页面"></btn:btn>
				</td>
			</tr>
		</table>
	</body>
</html>