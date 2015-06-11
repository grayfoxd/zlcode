<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>体检套餐明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrPhyPackageService.js"></script>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrPhyItemService.js"></script>

<script type="text/javascript">
window.onload = function(){
    dwrPhyPackageService.getIPhyPackageByPk('<%=pk%>',setPageValue);
    dwrPhyPackageService.getIPhyItemsByPackageId('<%=pk%>',setPhyItems);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iPhyPackage = data.resultList[0];
            DWRUtil.setValue("packageName",iPhyPackage.packageName);
            DWRUtil.setValue("marketPrice",iPhyPackage.marketPrice);
            DWRUtil.setValue("actualPrice",iPhyPackage.actualPrice);
            DWRUtil.setValue("gender",iPhyPackage.gender);
            DWRUtil.setValue("status",iPhyPackage.status);
            DWRUtil.setValue("compnayId",iPhyPackage.compnayId);
            DWRUtil.setValue("firstOperator",iPhyPackage.firstOperator);
            DWRUtil.setValue("firstOperatorTime",iPhyPackage.firstOperatorTime);
            DWRUtil.setValue("lastOperator",iPhyPackage.lastOperator);
            DWRUtil.setValue("lastOperatorTime",iPhyPackage.lastOperatorTime);
            DWRUtil.setValue("memo",iPhyPackage.memo);
            DWRUtil.setValue("dr",iPhyPackage.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}

function setPhyItems(data){
	if(data.success == true){
        if(data.resultList.length > 0){
            var itemIds = "";
        	for(var i=0;i<data.resultList.length;i++){
    			itemIds+=data.resultList[i]+",";
    		}
        	if(itemIds.length==0){
				return;
            }
        	dwrPhyItemService.getIPhyItemsByPks(itemIds, getItemsCallback);

        }else{
            alert(data.message);
        }
	}else{
        alert(data.message);
    }
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
				var otr = tab.insertRow(-1);
				otr.id="tr"+item.primaryKey;
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
		        
		        otr.appendChild(td2);
		        otr.appendChild(td3);
		        otr.appendChild(td4);
	        }
        }
	}else{
		alertmsg(data);
	}
}

</script>
</head>
<body class="inputdetail">
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示体检套餐相关信息！</label></div>
    <div class="detailtitle">体检套餐明细</div>
    <table class="detailtable">
        <tr>
            <th>套餐名称</th>
            <td id="packageName" class="detailtabletd"></td>
            <th>市场价格</th>
            <td id="marketPrice" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>实际价格</th>
            <td id="actualPrice" class="detailtabletd"></td>
            <th>适用性别</th>
            <td id="gender" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>状态</th>
            <td id="status" class="detailtabletd"></td>
            <th>公司ID</th>
            <td id="compnayId" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>添加人</th>
            <td id="firstOperator" class="detailtabletd"></td>
            <th>添加时间</th>
            <td id="firstOperatorTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>最后修改人</th>
            <td id="lastOperator" class="detailtabletd"></td>
            <th>最后修改时间</th>
            <td id="lastOperatorTime" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>备注</th>
            <td id="memo" class="detailtabletd"></td>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
        </tr>
        <tr>
        	<th><br/></th>
        	<td><br/></td>
        </tr>
        
        <tr>
        	<th valign="top">体检项目列表</th>
			<td valign="top" colspan="3">
				<div style="">
					<table class='tablerowStyleColor' cellSpacing='0'
						cellPadding='3' width='100%' align='center' border='1'
						id='phyitems'>
						<tr
							style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/fhbg.gif');">
							<td class='tableTitle1' style="text-align: center;">项目编码</td>
							<td class='tableTitle1' style="text-align: center;">项目名称</td>
							<td class='tableTitle1' style="text-align: center;">适用性别</td>
							
						</tr>
					</table>
				</div>
			</td>
		</tr>
    </table>
</body>
</html>
