<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员消费管理</title>
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
function edit(pk){
    openMDITab("<%=contextPath%>/erp/memberui/imemberconsumption_add.jsp?pk="+pk+"&tab="+getMDITab());
}
function createProcessMethod(rowObj){
    var str="<a href='javascript:void(0)' title='编辑' onclick=\"edit('"+rowObj.primaryKey+"')\"><img src='<%=contextPath%>/images/grid_images/rowedit.png' border='0'/></a>";
    str += "&nbsp;&nbsp;<a href='javascript:void(0)' title='删除' onclick=\"del('"+rowObj.primaryKey+"')\"><img src='<%=contextPath%>/images/grid_images/rowdel.png' border='0'/></a>";
    return str;
}
function del(pk){
    confirmmsg("确定要删除会员消费吗?","delok('"+pk+"')");
}
function delok(pk){
    var pks = new Array();
    pks[0] = pk;
    dwrImemberconsumptionService.deleteIMemberConsumptionByPks(pks,delCallback);
}
function delCallback(data){
    alertmsg(data,"queryData()");
}
function delbatch(){
    if(getAllRecordArray() != false){
        confirmmsg("确定要删除会员消费吗?","delbatchok()");
    }else{
        alertmsg("请选择要删除的会员消费...");
    }
}
function delbatchok(){
    var pks = getAllRecordArray();
    dwrImemberconsumptionService.deleteIMemberConsumptionByPks(pks,delCallback);
}
function add(){
    openMDITab("<%=contextPath%>/erp/memberui/imemberconsumption_add.jsp?tab="+getMDITab());
}
</script>
</head>
<body>
<%
SysGrid grid = new SysGrid(request,"会员消费列表");
//放入按钮
ArrayList<SysGridBtnBean> btnList = new ArrayList<SysGridBtnBean>();
btnList.add(new SysGridBtnBean("新增", "add()", "add.png"));
btnList.add(new SysGridBtnBean("批量删除", "delbatch()", "close.png"));
grid.setBtnList(btnList);
//放入操作提示，请在系统管理-帮助管理处添加
grid.setHelpList(UtilTool.getGridTitleList(this.getServletContext(), request));
ArrayList<SysColumnControl> sccList = new ArrayList<SysColumnControl>();
//sccList.add(new SysColumnControl("memberId","会员ID",1,1,1,0));
sccList.add(new SysColumnControl("memberName","会员姓名",1,1,1,0));
sccList.add(new SysColumnControl("consumptionContent","消费明细",1,1,1,0));
sccList.add(new SysColumnControl("consumptionTime","消费时间",1,1,1,0));
//sccList.add(new SysColumnControl("firstOperator","添加人",1,1,1,0));
//sccList.add(new SysColumnControl("firstOperatorTime","添加时间",1,1,1,0));
//sccList.add(new SysColumnControl("lastOperator","最后修改人",1,1,1,0));
//sccList.add(new SysColumnControl("lastOperatorTime","最后修改时间",1,1,1,0));
sccList.add(new SysColumnControl("memo","备注",1,1,1,0));
//sccList.add(new SysColumnControl("dr","是否删除",1,2,1,0));
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
  			//高级查询显示
  			DateType date = new DateType();
  			bc.setColumnTypeClass(date);
  			//列样式
  			bc.setColumnStyle("padding-left:15px;");
  		}
  		if ("consumptionContent"
  				.equalsIgnoreCase(bc.getDataName())) {
  			//高级查询显示
  			DateType date = new DateType();
  			bc.setColumnTypeClass(date);
  			//列样式
  			bc.setColumnStyle("padding-left:15px;");
  		}
  		if ("consumptionTime"
  				.equalsIgnoreCase(bc.getDataName())) {
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
grid.setShowProcess(true);//默认为false 为true请设置processMethodName
grid.setProcessMethodName("createProcessMethod");//生成该操作图标的js方法,系统默认放入数据行对象
out.print(grid.createTable());
%>
</body>
</html>
