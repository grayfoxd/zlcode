<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp"%>
<%
	String tab = request.getParameter("tab");
	String pk = request.getParameter("pk");
	int row =15;
	String gid=request.getParameter("gid");
	String isedit = "false";
	String saveOrEdit = "新增";
	String helpTitle = "您可以在此处添加您想新增的服务套餐管理！";
	if (pk != null) {
		isedit = "true";
		saveOrEdit = "编辑";
		helpTitle = "您可以在此处编辑服务套餐管理信息！";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>服务套餐管理</title>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrServicepackageService.js"></script>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrserviceInfoService.js"></script>
</head>
<body class="inputcls">
<input type="hidden" id="serviceInfoCode">
<input type="hidden" id="serviceInfoid">
	<div class="formDetail">
		<div class="requdiv">
			<label id="helpTitle"></label>
		</div>
		<div class="formTitle"><%=saveOrEdit%>服务套餐管理
		</div>
		<table class="inputtable">
			<tr>
				<th><em>*</em>&nbsp;&nbsp;编码</th>
				<td><input type="text" id="servicePackageCode" must="编码不能为空!"
					formust="servicePackageCodeMust"></input><label
					id="servicePackageCodeMust"></label></td>
				<th><em>*</em>&nbsp;&nbsp;名称</th>
				<td><input type="text" id="servicePackageName" must="名称不能为空!"
					formust="servicePackageNameMust"></input><label
					id="servicePackageNameMust"></label></td>
			</tr>
			<tr>
				<th><em>*</em>&nbsp;&nbsp;指导价格</th>
				<td><input type="text" id="servicePackageAdviceprice" readonly="readonly"
					must="指导价格不能为空!" formust="servicePackageAdvicepriceMust"></input><label
					id="servicePackageAdvicepriceMust"></label></td>
				<th><em>*</em>&nbsp;&nbsp;执行价格</th>
				<td><input type="text" onkeyup="this.value=this.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3')"
					onkeypress="return event.keyCode>=4&&event.keyCode<=57" 
				onblur="if(!/^\d{1,12}(?:\.\d{1,4})?$/.test(this.value)){alert('只能输入RMB类型！');this.value='';}"
				id="servicePackagePrice" 
					must="执行价格不能为空!" formust="servicePackagePriceMust"></input><label
					id="servicePackagePriceMust"></label></td>
			</tr>

			<tr>
				<th><em>*</em>&nbsp;&nbsp;备注</th>
				<td><input type="text" id="memo" must="备注不能为空!"
					formust="memoMust"></input><label id="memoMust"></label></td>
			</tr>

			<tr>
				<td valign="top" colspan="4">
					<div style="border: 1px solid #A6D0E8; width: 80%">
						<label id="servicepackage1"></label>
						<table cellpadding='0' cellspacing='0' border='0' align='center'
							width='100%' />
							
							<tr
								style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/wbg.gif');"
								height="24px">
								<td align='left' style='padding-left: 10px; font-weight: bold;'>服务项目明细</td>
								<td style="text-align: right;" nowrap="nowrap" align="right">
									<div class='div_btn'
										onmouseover='this.className ="div_btn_hover"'
										onmouseout='this.className ="div_btn"'
										onclick="deletebatch();">&nbsp;删除选中项目&nbsp;</div>
									<div class='div_btn'
										onmouseover='this.className ="div_btn_hover"'
										onmouseout='this.className ="div_btn"' onclick="getupcode()">&nbsp;选择项目&nbsp;</div>
								</td>
							</tr>
							<tr>
								<td valign="top" colspan="2" height="240">
									<div style="overflow: auto; height: 100%; vertical-align: top;">
										<table class='tablerowStyleColor' cellSpacing='0'
											cellPadding='3' width='100%' align='center' border='1'
											id='servicepackage'>
											<tr
												style="BACKGROUND-IMAGE: url('<%=contextPath%>/images/grid_images/fhbg.gif');">
												<td class='tableTitle1' style="text-align: center;"
													width="10px"><input type='checkbox'
													onclick="selectAll(this,'userchk')" title='全选/取消'></td>
												<td class='tableTitle1' style="text-align: center;">项目编码</td>
												<td class='tableTitle1' style="text-align: center;">项目名称</td>
												<td class='tableTitle1' style="text-align: center;">适用人群</td>
												<td class='tableTitle1' style="text-align: center;">计量单位</td>
												<td class='tableTitle1' style="text-align: center;">计量单价</td>
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
			<td><btn:btn onclick="savepackage();" value="保 存 "
					imgsrc="../../images/png-1718.png" title="保存服务套餐管理信息" /></td>
			<td style="width: 20px;"></td>
			<td><btn:btn onclick="closePage();" value="关 闭 "
					imgsrc="../../images/winclose.png" title="关闭当前页面" /></td>
		</tr>
	</table>
	
	<script type="text/javascript">
	window.onload = function(){
		useLoadingMassage();
	initInput("helpTitle","<%=helpTitle%>");
	createRow(6);
	if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrServicepackageService.getIServicePackageByPk(pk,setServicepackage);
        dwrServicepackageService.getdetailids(pk,setServiceDetail);
    }else{
//	  		Btn.hidden("closePage");
	}
}

function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrServicepackageService.getIServicePackageByPk(pk,setServicepackage);
    }
}

function setServicepackage(data){
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
function getServicepackage(){
    var servicepackage = new Object();
    if(<%=isedit%>){
        servicepackage.primaryKey = '<%=pk%>';
		}
		servicepackage.servicePackageCode = DWRUtil
				.getValue("servicePackageCode");
		servicepackage.servicePackageName = DWRUtil
				.getValue("servicePackageName");
		servicepackage.servicePackageAdviceprice = DWRUtil
				.getValue("servicePackageAdviceprice");
		servicepackage.servicePackagePrice = DWRUtil
				.getValue("servicePackagePrice");
		servicepackage.firstOperator = DWRUtil.getValue("firstOperator");
		servicepackage.firstOperatorTime = DWRUtil
				.getValue("firstOperatorTime");
		servicepackage.lastOperator = DWRUtil.getValue("lastOperator");
		servicepackage.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
		servicepackage.memo = DWRUtil.getValue("memo");
		servicepackage.dr = DWRUtil.getValue("dr");
		return servicepackage;
	}
	function saveCallback(data) {
		//Btn.open();
		if (data.success) {
			confirmmsgAndTitle("添加服务套餐管理成功！是否想继续添加服务套餐管理？", "reset();", "继续添加",
					"closePage();", "关闭页面");
		} else {
			alertmsg(data);
		}
	}
	function reset() {
		Sys.reload();
	}
	function closePage() {
		closeMDITab(<%=tab%>);
	}
	
	function getusermsg(){
		var serviceInfoid =document.getElementById("serviceInfoid").value;
		if(serviceInfoid.length==0){
			return;
		}
		dwrserviceInfoService.getIServiceInfoByPks(serviceInfoid,getcallback);
	}

	function createRow(row){
		var tab = document.getElementById("servicepackage");
		for ( var i = row ; i < <%=row%>; i++) {
			var otr = tab.insertRow(-1);
			for(var j=0;j<7;j++){
				var td=document.createElement("td");
				td.innerHTML ="&nbsp;";
				otr.appendChild(td);
			}
	    }
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
			        var td1=document.createElement("td");
			        td1.innerHTML = "<input type='checkbox' name='userchk' value='"+IServiceInfo.primaryKey+"'>";
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
			        
					var td7=document.createElement("td");
					td7.style.cssText ="text-align:center";
					td7.innerHTML="<a href='javascript:void(0)' onclick=\"delrow('"+IServiceInfo.primaryKey+"')\">删除</a>";
			        otr.appendChild(td1);
			        otr.appendChild(td2);
			        otr.appendChild(td3);
			        otr.appendChild(td4);
			        otr.appendChild(td5);
			        otr.appendChild(td6);
			        otr.appendChild(td7);
		        }
	        }
	        createRow(data.resultList[0].length);
		}else{
			alertmsg(data);
		}
	}

	function delrow(i){
		var tab = document.getElementById("servicepackage");
		var row = document.getElementById("tr"+i);
		var rIndex = row.rowIndex;
		tab.deleteRow(rIndex);
		
		var serviceInfoid =document.getElementById("serviceInfoid").value;
		var serviceInfoids = serviceInfoid.split(",");
		var tmpid="";
		for(var j=0;j<serviceInfoids.length;j++){
			if(serviceInfoids[j].length>0&&serviceInfoids[j] != i){
				tmpid+= serviceInfoids[j]+",";
			}
		}
		document.getElementById("serviceInfoid").value = tmpid;
	}

	function deletebatch(){
		var ids = getCheckedValues("userchk");
		for(var i=0;i<ids.length;i++){
			delrow(ids[i]);
		}
	}
	function getupcode(){
		if(<%=gid%>!=null){
			var box = SEL.getServicepackage("check","serviceInfoCode","serviceInfoid","getusermsg()");
			box.show();
		}else{
		  	var box = SEL.getServicepackage("check","serviceInfoCode","serviceInfoid","getusermsg()");
			box.show();
		}
	}

	function savepackage(){
	    var warnArr = new Array();
		warnArr[0] = "servicepackage1"; 
		warnArr[1] = "servicepackageDescMsg";
		var bl = validvalue('title');
		if(bl){
			var tmp = DWRUtil.getValue("memoMust");
	   		  if(tmp.length>200){
	   		  	setMustWarn("servicepackageDescMsg","部门描述不能大于200个字符!");
	   		  	return;
	   		  }
			var cks = document.getElementsByName("userchk");
			if(cks.length==0){
				setMustWarn("servicepackage1", "请选择编组的用户");
				return false;
			}
			var serviceInfoids = new Array();
			for(var i=0;i<cks.length;i++){
				serviceInfoids[i] = cks[i].value;
			}
			Btn.close();
			getservicepack(); 
			dwrServicepackageService.saveServicePackageAndDetail(getservicepack(),serviceInfoids,methodcallback);
		}
			
	}


	function methodcallback(data){
		Btn.open();
		var method = "sevent()";
		if(<%=isedit%>) {
			if (data.success) {
				alertmsg(data, "closePage();");
			} else {
				alertmsg(data);
			}
			return ;
		}else{
		    if(data.success){
		        confirmmsgAndTitle("添加服务项目维护成功！是否想继续添加服务项目维护？",method,"继续添加","closePage();","关闭页面");
		    }else{
		        alertmsg(data);
		    }
			}
		}
	
		function returnload() {
			alert(1)
			window.parent.MoveDiv.close();
			window.parent.queryData();
		}
		function sevent() {
// 			document.getElementById("serviceInfoid").value = "";
// 			document.getElementById("employeename").value = "";
// 			document.getElementById("forempname").checked = false;
// 			DWRUtil.setValue("groupname", "");
// 			DWRUtil.setValue("grouptext", "");
			var tab = document.getElementById("servicepackage");
			var rlen = tab.rows.length;
			for (var i = rlen - 1; i >= 1; i--) {
				tab.deleteRow(i);
			}
			initInput('title');
			createRow(0);
			window.parent.queryData();
		}

		function getservicepack() {
			var servicepack = new Object();
			if(<%=isedit%>){
		        var pk = '<%=pk%>';
				servicepack.primaryKey=pk;
			}
			servicepack.servicePackageCode = DWRUtil.getValue("servicePackageCode");
			servicepack.servicePackageName = DWRUtil.getValue("servicePackageName");
			servicepack.servicePackageAdviceprice = DWRUtil.getValue("servicePackageAdviceprice");
			servicepack.servicePackagePrice = DWRUtil.getValue("servicePackagePrice");
			servicepack.memo = DWRUtil.getValue("memo");
			return servicepack;
		}
	</script>
</body>
</html>
