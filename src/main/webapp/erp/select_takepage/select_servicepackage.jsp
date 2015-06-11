<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务项目维护管理</title>
<%
String textid = request.getParameter("textid");
String valueid = request.getParameter("valueid");
String treetype = request.getParameter("treetype");
 %>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrserviceInfoService.js"></script>
<script type="text/javascript">
//查询方法
function queryData(){
    startQuery();
    var serviceinfo = getQueryParam();//java实体类相对应
    var pager = getPager();
    dwrserviceInfoService.listIServiceInfo(serviceinfo,pager,queryCallback);
}
function queryCallback(data){
    if(data.success == true){
        initGridData(data.resultList,data.pager);
    }else{
        alert(data.message);
    }
    endQuery();
}
//双击数据
function dblCallback(obj){

}

function delok(pk){
    var pks = new Array();
    pks[0] = pk;
    dwrserviceInfoService.deleteIServiceInfoByPks(pks,delCallback);
}
function delCallback(data){
    alertmsg(data,"queryData()");
}
function delbatch(){
    if(getAllRecordArray() != false){
        confirmmsg("确定要删除服务项目维护吗?","delbatchok()");
    }else{
        alertmsg("请选择要删除的服务项目维护...");
    }
}
function delbatchok(){
    var pks = getAllRecordArray();
    dwrserviceInfoService.deleteIServiceInfoByPks(pks,delCallback);
}

/**
 * 用户点击确认按钮时触发
 */
function userclickcustomera(dialogId,method){
	userclick();
	if(method != null && method.length > 0){
 		var win = Sys.getfrm();
 		
		eval("win."+method);
	}
	Sys.close(dialogId);
}

function userclick() {
	var win = Sys.getfrm();
	var textid = win.document.getElementById("<%=textid%>");
	var valueid = win.document.getElementById("<%=valueid%>");
	var treetype = '<%=treetype%>';
	var pirce=0.00;
	if (treetype == "radio") {
		if (getOneRecordArray() != false) {
			var obj = getObjectByPk(getOneRecordArray());
			textid.value = obj.serviceInfoCode;
			valueid.value = obj.primaryKey;
			pirce=parseInt(obj.measuringUnitPrice);
		}else{
	    	alertmsg("请选择相应数据记录...");
	    	return;
		}
	} else {
		var objs = getRowsObject();
		if(objs.length==0){
	    	alertmsg("请选择相应数据记录...");
	    	return;
		}
		var value = "";
		var text = "";
		for (var i = 0; i < objs.length; i++) {
			value += objs[i].primaryKey + ",";
			text += objs[i].serviceInfoCode + ",";
			pirce +=parseInt(objs[i].measuringUnitPrice);
		}
		if (valueid.value == "" || valueid.value == null) {
			valueid.value = value;
			textid.value = text;
		} else { //去除重复
			var tmps = removerepeat(valueid.value + value, textid.value + text) ;
			textid.value = tmps[1];
			valueid.value = tmps[0];
		}
	}
	win.document.getElementById("servicePackageAdviceprice").value=pirce;
}

</script>
</head>
<body>
<%
SysGrid grid = new SysGrid(request,"服务项目维护列表");
//放入按钮
//放入操作提示，请在系统管理-帮助管理处添加
grid.setHelpList(UtilTool.getGridTitleList(this.getServletContext(), request));
ArrayList<SysColumnControl> sccList = new ArrayList<SysColumnControl>();
sccList.add(new SysColumnControl("serviceInfoCode","编码",1,1,1,0));
sccList.add(new SysColumnControl("serviceInfoName","名称",1,1,1,0));
sccList.add(new SysColumnControl("crowd","适用人群",1,1,1,0));
sccList.add(new SysColumnControl("measuringUnit","计量单位",1,1,1,0));
sccList.add(new SysColumnControl("measuringUnitPrice","计量单价",1,1,1,0));
sccList.add(new SysColumnControl("firstOperator","添加人",2,1,1,0));
sccList.add(new SysColumnControl("firstOperatorTime","添加时间",2,1,1,0));
sccList.add(new SysColumnControl("lastOperator","最后修改人",2,1,1,0));
sccList.add(new SysColumnControl("lastOperatorTime","最后修改时间",2,1,1,0));
sccList.add(new SysColumnControl("memo","备注",1,1,1,0));
sccList.add(new SysColumnControl("dr","是否删除",2,2,1,0));
ArrayList<SysGridColumnBean> colList = UtilTool.getGridColumnList(sccList);
for(int i = 0; i < colList.size(); i++){
    SysGridColumnBean bc = colList.get(i);
    if ("".equalsIgnoreCase(bc.getDataName())){
        bc.setColumnReplace("");
        bc.setColumnStyle("text-align:center");
    }
}
grid.setColumnList(colList);
//设置附加信息
grid.setShowImg(false);
grid.setQueryFunction("queryData");//查询的方法名
grid.setDblFunction("dblCallback");//双击列的方法名，有返回值，为列对象
grid.setDblBundle("primaryKey");//双击列的绑定的列值
grid.setShowProcess(false);//默认为false 为true请设置processMethodName
out.print(grid.createTable());
%>
</body>
</html>
