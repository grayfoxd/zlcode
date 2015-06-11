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
	src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>
<script type="text/javascript">
window.onload = function(){
	dwrPhyItemService.getIPhyItemByPk('<%=pk%>',setPageValue);
}
	function setPageValue(data){
		if(data.success == true){
		      if(data.resultList.length>0){
		          var item = data.resultList[0];
		          DWRUtil.setValue("itemCode",item.itemCode);	        
		          DWRUtil.setValue("itemName",item.itemName);	          
		          DWRUtil.setValue("retrieveCode",item.retrieveCode);      
                  DWRUtil.setValue("displaySequence",item.displaySequence);
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
                  //DWRUtil.setValue("parentId",item.parentId);
                  if(item.isLeaf == <%=EnumUtil.PHY_ITEM_IS_LEAF.Vaild.value%>){
                	  DWRUtil.setValue("isLeaf","<%=EnumUtil.PHY_ITEM_IS_LEAF
					.valueOf(EnumUtil.PHY_ITEM_IS_LEAF.Vaild.value)%>");
                  }else{
                	  DWRUtil.setValue("isLeaf","<%=EnumUtil.PHY_ITEM_IS_LEAF
					.valueOf(EnumUtil.PHY_ITEM_IS_LEAF.No_Vaild.value)%>");
				}

				DWRUtil.setValue("firstOperator", item.firstOperator);
				DWRUtil.setValue("firstOperatorTime", item.firstOperatorTime);
				DWRUtil.setValue("lastOperator", item.lastOperator);
				DWRUtil.setValue("lastOperatorTime", item.lastOperatorTime);
				DWRUtil.setValue("dr", item.dr);
				DWRUtil.setValue("memo", item.memo);

				dwrPhyItemService.getIPhyItemByPk(item.parentId, updateParentName);

			} else {
				alertmsg("没找到相关记录！");
			}
		} else {
			alertmsg(data.message);
		}
	}

	function updateParentName(data) {
		if (data.success == true) {
			if (data.resultList.length > 0) {

				var info = data.resultList[0];
				//document.getElementById("parentName").value=info.itemName;
				DWRUtil.setValue("parentName", info.itemName);
			}else{
				DWRUtil.setValue("parentName", "-1");
			}
		} else {
			DWRUtil.setValue("parentName", "-1");
		}
	}
	
</script>
</head>
<body>
<fieldset><legend>项目明细</legend>
<div>
<table class="detailtable" align="center">
	<tr>
		<th width="15%">项目编号</th>
		<td id="itemCode"></td>
		<th width="15%">项目名称</th>
		<td id="itemName"></td>
	</tr>

	<tr>
		<th width="15%">检索编码</th>
		<td id="retrieveCode"></td>
		<th width="15%">显示顺序</th>
		<td id="displaySequence"></td>
	</tr>

	<tr>
		<th width="15%">适用性别</th>
		<td id="gender"></td>
		<th width="15%">上级项目</th>
		<td id="parentName"></td>
	</tr>

	<tr>
		<th width="15%">是否叶子结点</th>
		<td id="isLeaf"></td>
		<th width="15%">添加人</th>
		<td id="firstOperator"></td>
	</tr>

	<tr>
		<th width="15%">添加时间</th>
		<td id="firstOperatorTime"></td>
		<th width="15%">最后修改人</th>
		<td id="lastOperator"></td>
	</tr>

	<tr>
		<th width="15%">最后修改时间</th>
		<td id="lastOperatorTime"></td>
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