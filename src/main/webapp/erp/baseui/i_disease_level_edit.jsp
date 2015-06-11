<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="org.springframework.web.context.WebApplicationContext"%>

<%@ include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑异常等级目录</title>
<%
	String sid = request.getParameter("sid");
%>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrDiseaseLevelService.js"></script>
<script type="text/javascript">

window.onload = function(){
	useLoadingMassage();
	initInput('helpTitle','您可以在此处编辑功能目录信息！');
	dwrDiseaseLevelService.getIDiseaseLevelByPk('<%=sid%>', setPageValue);
	}

	function saveDiseaseLevel() {
		var warnArr = new Array();
		warnArr[0] = "diseaseLevelNameMust";
		warnArr[1] = "diseaseLevelValueMust";
		warnInit(warnArr);
		var bl = validvalue('helpTitle');

		if (bl) {
			var desc = DWRUtil.getValue("memo");
			if (desc.length > 100) {
				setMustWarn("memoMust", "备注不能超过100字符");
				return;
			}
			Btn.close();

			dwrDiseaseLevelService.updateDiseaseLevel(getDiseaseLevel(),
					updateCallback);
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

	function setPageValue(data) {
		if (data != null && data.resultList.length > 0) {
			var info = data.resultList[0];
			DWRUtil.setValue("diseaseLevelName", info.diseaseLevelName);
			DWRUtil.setValue("diseaseLevelValue", info.diseaseLevelValue);
          	DWRUtil.setValue("gender", info.gender);
			DWRUtil.setValue("ageRange", info.ageRange);
			DWRUtil.setValue("refMinMale", info.refMinMale);
			DWRUtil.setValue("refMinFemale", info.refMinFemale);
			DWRUtil.setValue("refMaxMale", info.refMaxMale);
			DWRUtil.setValue("refMaxFemale", info.refMaxFemale);
			DWRUtil.setValue("refResult", info.refResult);
			DWRUtil.setValue("phyItemId", info.phyItemId);
			DWRUtil.setValue("memo", info.memo);

			dwrPhyItemService.getIPhyItemByPk(info.phyItemId, updatePhyItemName);
			
		}

	}

	function updatePhyItemName(data) {
		if (data.success == true) {
			if (data.resultList.length > 0) {

				var info = data.resultList[0];
				DWRUtil.setValue("phyItemName", info.itemName);
			}
		} 
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
				编辑异常等级信息
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