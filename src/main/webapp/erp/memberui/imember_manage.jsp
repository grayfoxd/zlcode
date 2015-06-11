<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息管理</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrI_memberService.js"></script>
<script type="text/javascript">
//查询方法
function queryData(){
    startQuery();
    var imember = getQueryParam();//java实体类相对应
    var pager = getPager();
    dwrI_memberService.listIMember(imember,pager,queryCallback);
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
    var box = new Sys.msgbox("明细查看","<%=contextPath%>/erp/memberui/imember_detail.jsp?pk="+obj.value);
    box.show();
}
function edit(pk){
    openMDITab("<%=contextPath%>/erp/memberui/imember_add.jsp?pk="+pk+"&tab="+getMDITab());
}
function createProcessMethod(rowObj){
    var str="<a href='javascript:void(0)' title='编辑' onclick=\"edit('"+rowObj.primaryKey+"')\"><img src='<%=contextPath%>/images/grid_images/rowedit.png' border='0'/></a>";
    str += "&nbsp;&nbsp;<a href='javascript:void(0)' title='删除' onclick=\"del('"+rowObj.primaryKey+"')\"><img src='<%=contextPath%>/images/grid_images/rowdel.png' border='0'/></a>";
    return str;
}
function del(pk){
    confirmmsg("确定要删除会员信息吗?","delok('"+pk+"')");
}
function delok(pk){
    var pks = new Array();
    pks[0] = pk;
    dwrI_memberService.deleteIMemberByPks(pks,delCallback);
}
function delCallback(data){
    alertmsg(data,"queryData()");
}
function delbatch(){
    if(getAllRecordArray() != false){
        confirmmsg("确定要删除会员信息吗?","delbatchok()");
    }else{
        alertmsg("请选择要删除的会员信息...");
    }
}
function delbatchok(){
    var pks = getAllRecordArray();
    dwrI_memberService.deleteIMemberByPks(pks,delCallback);
}
function add(){
    openMDITab("<%=contextPath%>/erp/memberui/imember_add.jsp?tab="+getMDITab());
}
//列显示替换方法（为高级查询中的性别使用的）
function repleaSex(rowObj){
	var str="";
	if(rowObj.memberSex==<%=EnumUtil.HRM_EMPLOYEE_SEX.Man.value%>){
		str= "<font style='color:blue'><%=EnumUtil.HRM_EMPLOYEE_SEX
							.valueOf(EnumUtil.HRM_EMPLOYEE_SEX.Man.value)%></font>"
	}else{
		str= "<font style='color:red'><%=EnumUtil.HRM_EMPLOYEE_SEX
							.valueOf(EnumUtil.HRM_EMPLOYEE_SEX.Woman.value)%></font>"
	}
	return str;
}
</script>
</head>
<body>
<%
SysGrid grid = new SysGrid(request,"会员信息列表");
//放入按钮
ArrayList<SysGridBtnBean> btnList = new ArrayList<SysGridBtnBean>();
btnList.add(new SysGridBtnBean("新增", "add()", "add.png"));
btnList.add(new SysGridBtnBean("批量删除", "delbatch()", "close.png"));
grid.setBtnList(btnList);
//放入操作提示，请在系统管理-帮助管理处添加
grid.setHelpList(UtilTool.getGridTitleList(this.getServletContext(), request));
ArrayList<SysColumnControl> sccList = new ArrayList<SysColumnControl>();
sccList.add(new SysColumnControl("memberId","会员ID",1,1,1,0));
sccList.add(new SysColumnControl("memberName","会员姓名",1,1,1,0));
sccList.add(new SysColumnControl("memberSex","会员性别",1,2,1,0));
//sccList.add(new SysColumnControl("memberAge","会员年龄",1,1,1,0));
//sccList.add(new SysColumnControl("memberBirthday","出生日期",1,1,1,0));
//sccList.add(new SysColumnControl("memberCountry","国籍",1,1,1,0));
//sccList.add(new SysColumnControl("memberBirthplace","出生地",1,1,1,0));
//sccList.add(new SysColumnControl("memberOriginplace","籍贯",1,1,1,0));
//sccList.add(new SysColumnControl("memberNation","民族",1,1,1,0));
//sccList.add(new SysColumnControl("memberIdcard","身份证号",1,1,1,0));
//sccList.add(new SysColumnControl("memberIsmarry","婚姻",1,1,1,0));
//sccList.add(new SysColumnControl("memberAddress","住址",1,1,1,0));
sccList.add(new SysColumnControl("memberPhone","电话",1,1,1,0));
//sccList.add(new SysColumnControl("memberJointime","入会时间",1,1,1,0));
//sccList.add(new SysColumnControl("bloodType","血型",1,1,1,0));
sccList.add(new SysColumnControl("rh","rh",1,1,1,0));
//sccList.add(new SysColumnControl("companyId","公司ID",1,1,1,0));
//sccList.add(new SysColumnControl("firstOperator","添加人",1,1,1,0));
//sccList.add(new SysColumnControl("firstOperatorTime","添加时间",1,1,1,0));
//sccList.add(new SysColumnControl("lastOperator","最后修改人",1,1,1,0));
//sccList.add(new SysColumnControl("lastOperatorTime","最后修改时间",1,1,1,0));
sccList.add(new SysColumnControl("memo","备注",1,1,1,0));
//sccList.add(new SysColumnControl("dr","是否删除",1,1,1,0));
ArrayList<SysGridColumnBean> colList = UtilTool.getGridColumnList(sccList);
for(int i = 0; i < colList.size(); i++){
    SysGridColumnBean bc = colList.get(i);
    if ("".equalsIgnoreCase(bc.getDataName())){
        bc.setColumnReplace("");
        bc.setColumnStyle("text-align:center");
    }
    
    //新增部分
	 if (bc.isShowAdvanced() || bc.isShowColumn()) {
		if ("memberSex".equalsIgnoreCase(bc.getDataName())) {
			//设置高级查询显示样式
           System.out.println("bc.getDataName()的值为："+bc.getDataName());
			SelectType select = new SelectType(EnumUtil.HRM_EMPLOYEE_SEX.getSelectAndText("-1,-请选择人员性别-"));
			select.setCustomerFunction(new String[] { "onchange=\"queryData();\"" });
			bc.setColumnTypeClass(select);
			bc.setColumnReplace("repleaSex");
			//设置列显示样式
			bc.setColumnStyle("text-align:center;");
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
