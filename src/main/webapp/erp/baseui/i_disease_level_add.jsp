<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的异常等级！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑新建异常等级信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加异常等级目录</title>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrDiseaseLevelService.js"></script>
<script type="text/javascript">

window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
}
	function saveDiseaseLevel() {
		var warnArr = new Array();
		warnArr[0] = "diseaseLevelNameMust";
		warnArr[1] = "diseaseLevelNameMust";
		warnInit(warnArr);
		var bl = validvalue('helpTitle');

		if (bl) {
			var desc = DWRUtil.getValue("memo");
			if (desc.length > 100) {
				setMustWarn("memoMust", "备注不能超过100字符");
				return;
			}
			Btn.close();
			
			dwrDiseaseLevelService.saveIDiseaseLevel(getDiseaseLevel(), saveCallback) 
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

	function getDiseaseLevel() {
		var info = new Object();
		info.diseaseLevelName = DWRUtil.getValue("diseaseLevelName");
		info.diseaseLevelValue = DWRUtil.getValue("diseaseLevelValue");
		info.gender = getRadioValueByName("gender");
		info.ageRange = DWRUtil.getValue("ageRange");
		info.refMinMale = DWRUtil.getValue("refMinMale");
		info.refMinFemale = DWRUtil.getValue("refMinFemale");
		info.refMaxMale = DWRUtil.getValue("refMaxMale");
		info.refMaxFemale = DWRUtil.getValue("refMaxFemale");
		info.refResult = DWRUtil.getValue("refResult");
		info.phyItemId = DWRUtil.getValue("phyItemId");
		info.memo = DWRUtil.getValue("memo");
		return info;
	}

	function getPhyItemUpid() {
		var box = SEL.getPhyItemIdForDisease("radio", "phyItemName",
				"phyItemId");
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
				添加异常等级信息
			</div>
			<div>
				<table class="inputtable" border="0">
					<tr>
						
						<th width="15%">
							<em>* </em>异常等级名称
						</th>
						<td>
							<input type="text" id="diseaseLevelName" maxlength="50" must="异常等级名称不能为空。" formust="diseaseLevelNameMust">
							<label id="diseaseLevelNameMust"></label>
						</td>
						
						<th>
							<em>* </em>异常等级值
						</th>
						<td>
							<input type="text" id="diseaseLevelValue" maxlength="9" formust="diseaseLevelValueMust" must="异常等级值不能为空">
							<label id="diseaseLevelValueMust"></label>
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
							<em>* </em>年龄范围
						</th>
						<td>
							<input type="text" id="ageRange" maxlength="50" >
							
						</td>
						
					</tr>
					
					<tr>
						<th>
							<em>* </em>参考下限(男)
						</th>
						<td>
							<input type="text" id="refMinMale" maxlength="50" >
							
						</td>
						
						<th>
							<em>* </em>参考下限(女)
						</th>
						<td>
							<input type="text" id="refMinFemale" maxlength="50" >
							
						</td>
						
					</tr>
					
					<tr>
						<th>
							<em>* </em>参考上限(男)
						</th>
						<td>
							<input type="text" id="refMaxMale" maxlength="50" >
							
						</td>
						
						<th>
							<em>* </em>参考上限(女)
						</th>
						<td>
							<input type="text" id="refMaxFemale" maxlength="50" >
							
						</td>
						
					</tr>
					
					<tr>
						<th>
							<em>* </em>参考结果
						</th>
						<td>
							<input type="text" id="refResult" maxlength="50" >
							
						</td>
						
						<th>
							检测项目
						</th>
						<td>
						<input type="text" id=phyItemName class="takeform" readonly="readonly" linkclear="phyItemId" onclick="getPhyItemUpid()" style="color: #999">
							<input type="hidden" id="phyItemId" >
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
					<btn:btn onclick="saveDiseaseLevel();" value="保 存 "
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