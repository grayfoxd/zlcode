<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目明细查看</title>
<%
	String pk = request.getParameter("pk");
	System.out.println("pk=" + pk);
%>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrDiseaseLevelService.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>
	
<script type="text/javascript">
window.onload = function(){
	dwrDiseaseLevelService.getIDiseaseLevelByPk('<%=pk%>',setPageValue);
}
	function setPageValue(data){
		if(data.success == true){
		      if(data.resultList.length>0){
		          var item = data.resultList[0];
		          DWRUtil.setValue("diseaseLevelName",item.diseaseLevelName);	        
		          DWRUtil.setValue("diseaseLevelValue",item.diseaseLevelValue);	          
                  if(item.gender == <%=EnumUtil.PHY_ITEM_GENDER.Male.value%>){
                	  DWRUtil.setValue("gender","<%=EnumUtil.PHY_ITEM_GENDER
					.valueOf(EnumUtil.PHY_ITEM_GENDER.Male.value)%>");
                  }else if(item.gender == <%=EnumUtil.PHY_ITEM_GENDER.Female.value%>){
                   	  DWRUtil.setValue("gender","<%=EnumUtil.PHY_ITEM_GENDER
					.valueOf(EnumUtil.PHY_ITEM_GENDER.Female.value)%>");
                  }else{
                	  DWRUtil.setValue("gender","<%=EnumUtil.PHY_ITEM_GENDER
					.valueOf(EnumUtil.PHY_ITEM_GENDER.Both.value)%>");
                  }

                  DWRUtil.setValue("ageRange",item.ageRange);      
                  DWRUtil.setValue("refMinMale",item.refMinMale);
                  DWRUtil.setValue("refMinFemale",item.refMinFemale);
                  DWRUtil.setValue("refMaxMale",item.refMaxMale);
                  DWRUtil.setValue("refMaxFemale",item.refMaxFemale);
                  DWRUtil.setValue("refResult", item.refResult);
				  DWRUtil.setValue("firstOperator", item.firstOperator);
				  DWRUtil.setValue("firstOperatorTime", item.firstOperatorTime);
				  DWRUtil.setValue("lastOperator", item.lastOperator);
				  DWRUtil.setValue("lastOperatorTime", item.lastOperatorTime);
				  DWRUtil.setValue("dr", item.dr);
				  DWRUtil.setValue("memo", item.memo);

				  dwrPhyItemService.getIPhyItemByPk(item.phyItemId, updatePhyItemName);

			} else {
				alertmsg("没找到相关记录！");
			}
		} else {
			alertmsg(data.message);
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
	
</script>
</head>
<body>
<fieldset><legend>异常等级明细</legend>
<div>
<table class="detailtable" align="center">
	<tr>
		<th width="15%">等级名称</th>
		<td id="diseaseLevelName"></td>
		<th width="15%">等级数值</th>
		<td id="diseaseLevelValue"></td>
	</tr>

	<tr>
		<th width="15%">适用性别</th>
		<td id="gender"></td>
		<th width="15%">年龄范围</th>
		<td id="ageRange"></td>
	</tr>

	<tr>
		<th width="15%">参考下限(女)</th>
		<td id="refMinMale"></td>
		<th width="15%">参考下限(男)</th>
		<td id="refMinFemale"></td>
	</tr>
	
	<tr>
		<th width="15%">参考上限(女)</th>
		<td id="refMaxMale"></td>
		<th width="15%">参考上限(男)</th>
		<td id="refMaxFemale"></td>
	</tr>
	
	<tr>
		<th width="15%">参考结果</th>
		<td id="refResult"></td>
		<th width="15%">检测项目</th>
		<td id="phyItemName"></td>
	</tr>
	
	<tr>
		<th width="15%">添加人</th>
		<td id="firstOperator"></td>
		<th width="15%">添加时间</th>
		<td id="firstOperatorTime"></td>
	</tr>

	<tr>
		<th width="15%">最后修改人</th>
		<td id="lastOperator"></td>
		<th width="15%">最后修改时间</th>
		<td id="lastOperatorTime"></td>
	</tr>

	<tr>
		<th width="15%">是否删除</th>
		<td id="dr"></td>
	</tr>

	<tr>
		<th width="15%">备注</th>
		<td colspan="3" id="memo"></td>
	</tr>

</table>
</div>
</fieldset>
<br />

<br />
</body>
</html>