<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务套餐管理明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrServicepackageService.js"></script>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrserviceInfoService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrServicepackageService.getIServicePackageByPk('<%=pk%>',setPageValue);
    dwrServicepackageService.getdetailids('<%=pk%>',setServiceDetail);
}
function setServiceDetail(data){
	var serviceInfoids="";
	if(data.success == true){
		for(var i=0;i<data.resultList.length;i++){
			serviceInfoids+=data.resultList[i]+",";
		}
		DWRUtil.setValue("serviceInfoid",serviceInfoids);
	}
	getusermsg();
}
function getusermsg(){
	var serviceInfoid =document.getElementById("serviceInfoid").value;
	if(serviceInfoid.length==0){
		return;
	}
	dwrserviceInfoService.getIServiceInfoByPks(serviceInfoid,getcallback);
}
function getcallback(data){
	var tab = document.getElementById("servicepackage");
	if(data.success==true){
		var rlen = tab.rows.length;	
		for(var i=rlen-1;i>=1;i--){
			tab.deleteRow(i);
		}
		if(data.resultList[0].length > 0){
			for ( var i = 0; i < data.resultList[0].length; i++) {
				var IServiceInfo = data.resultList[0][i];
				var otr = tab.insertRow(-1);
				otr.id="tr"+IServiceInfo.primaryKey;
		        var td2=document.createElement("td");
		        td2.innerHTML = IServiceInfo.serviceInfoCode;
		        
		        var td3=document.createElement("td");
		        td3.innerHTML = IServiceInfo.serviceInfoName;
		        var td4=document.createElement("td");
		        td4.innerHTML = IServiceInfo.crowd;
		        var td5=document.createElement("td");
		        td5.innerHTML = IServiceInfo.measuringUnit;
		        var td6=document.createElement("td");
		        td6.innerHTML = IServiceInfo.measuringUnitPrice;
		        
		        otr.appendChild(td2);
		        otr.appendChild(td3);
		        otr.appendChild(td4);
		        otr.appendChild(td5);
		        otr.appendChild(td6);
	        }
        }
	}else{
		alertmsg(data);
	}
}

function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var servicepackage = data.resultList[0];
            DWRUtil.setValue("servicePackageCode",servicepackage.servicePackageCode);
            DWRUtil.setValue("servicePackageName",servicepackage.servicePackageName);
            DWRUtil.setValue("servicePackageAdviceprice",servicepackage.servicePackageAdviceprice);
            DWRUtil.setValue("servicePackagePrice",servicepackage.servicePackagePrice);
            DWRUtil.setValue("firstOperator",servicepackage.firstOperator);
            DWRUtil.setValue("firstOperatorTime",servicepackage.firstOperatorTime);
            DWRUtil.setValue("lastOperator",servicepackage.lastOperator);
            DWRUtil.setValue("lastOperatorTime",servicepackage.lastOperatorTime);
            DWRUtil.setValue("memo",servicepackage.memo);
            DWRUtil.setValue("dr",servicepackage.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}
</script>
</head>
<body class="inputdetail">
<input type="hidden" id="serviceInfoid">
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示服务套餐管理相关信息！</label></div>
    <div class="detailtitle">服务套餐管理明细</div>
    <table class="detailtable">
        <tr>
            <th>编码</th>
            <td id="servicePackageCode" class="detailtabletd"></td>
            <th>名称</th>
            <td id="servicePackageName" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>指导价格</th>
            <td id="servicePackageAdviceprice" class="detailtabletd"></td>
            <th>执行价格</th>
            <td id="servicePackagePrice" class="detailtabletd"></td>
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
        </tr>
   		<tr>
			<td valign="top" colspan="4" height="240">
				<div style="overflow: auto; height: 100%; vertical-align: top;">
					<table class='tablerowStyleColor' cellSpacing='0'
						cellPadding='3' width='100%' align='center' border='1'
						id='servicepackage'>
						<tr
							style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/fhbg.gif');">
							<td class='tableTitle1' style="text-align: center;">项目编码</td>
							<td class='tableTitle1' style="text-align: center;">项目名称</td>
							<td class='tableTitle1' style="text-align: center;">适用人群</td>
							<td class='tableTitle1' style="text-align: center;">计量单位</td>
							<td class='tableTitle1' style="text-align: center;">计量单价</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
    </table>
</body>
</html>
