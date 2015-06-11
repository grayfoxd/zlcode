<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员消费查询</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrImemberconsumptionService.js"></script>
<script type="text/javascript">
//查询方法
function queryData(){
    startQuery();
    var imemberconsumption = getQueryParam();//java实体类相对应
    var pager = getPager();
    dwrImemberconsumptionService.listIMemberConsumption(imemberconsumption,pager,queryCallback);
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
    var box = new Sys.msgbox("明细查看","<%=contextPath%>/erp/memberui/imemberconsumption_detail.jsp?pk="+obj.value);
    box.show();
}

</script>
</head>
<body>
<%
SysGrid grid = new SysGrid(request,"会员消费列表");
//放入操作提示，请在系统管理-帮助管理处添加
grid.setHelpList(UtilTool.getGridTitleList(this.getServletContext(), request));
ArrayList<SysColumnControl> sccList = new ArrayList<SysColumnControl>();
//sccList.add(new SysColumnControl("memberId","会员ID",1,1,1,0));
sccList.add(new SysColumnControl("memberName","会员姓名",1,1,1,0));
sccList.add(new SysColumnControl("consumptionContent","消费明细",1,2,2,0));
sccList.add(new SysColumnControl("consumptionTime","消费时间",1,1,1,0));
sccList.add(new SysColumnControl("memo","备注",1,1,2,0));

ArrayList<SysGridColumnBean> colList = UtilTool.getGridColumnList(sccList);
for(int i = 0; i < colList.size(); i++){
    SysGridColumnBean bc = colList.get(i);
    if ("".equalsIgnoreCase(bc.getDataName())){
        bc.setColumnReplace("");
        bc.setColumnStyle("text-align:center");
    }
  //新增部分
  	if (bc.isShowAdvanced() || bc.isShowColumn()) {
  		//
  	 	if ("memberName".equalsIgnoreCase(bc.getDataName())) {
  			
  			//列样式
  			bc.setColumnStyle("padding-left:15px;");
  		}
  		
  		if ("consumptionTime"
  				.equalsIgnoreCase(bc.getDataName())) {
  		     //高级查询显示
  			DateType date = new DateType();
  			bc.setColumnTypeClass(date);
  			//列样式
  			bc.setColumnStyle("padding-left:15px;text-align: left");
  		} 
  
  	}
}
grid.setColumnList(colList);
//设置附加信息
grid.setShowImg(false);
grid.setQueryFunction("queryData");//查询的方法名
grid.setDblFunction("dblCallback");//双击列的方法名，有返回值，为列对象
grid.setDblBundle("primaryKey");//双击列的绑定的列值
grid.setShowProcess(false);//默认为false 为true请设置processMethodName,用于显示右边的编辑删除界面
//grid.setProcessMethodName("createProcessMethod");//生成该操作图标的js方法,系统默认放入数据行对象
out.print(grid.createTable());
%>
</body>
</html>
