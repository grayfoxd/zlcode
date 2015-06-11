<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String gid = request.getParameter("gid");//选择人员的新增部分
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员消费！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员消费信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员消费</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrImemberconsumptionService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
    //第一个输入框获取焦点
    document.getElementById("memberName").focus();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrImemberconsumptionService.getIMemberConsumptionByPk(pk,setImemberconsumption);
    }
}

function setImemberconsumption(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var imemberconsumption = data.resultList[0];
            DWRUtil.setValue("memberId",imemberconsumption.memberId);
            DWRUtil.setValue("memberName",imemberconsumption.memberName);
            DWRUtil.setValue("consumptionContent",imemberconsumption.consumptionContent);
            DWRUtil.setValue("consumptionTime",imemberconsumption.consumptionTime);
            DWRUtil.setValue("firstOperator",imemberconsumption.firstOperator);
            DWRUtil.setValue("firstOperatorTime",imemberconsumption.firstOperatorTime);
            DWRUtil.setValue("lastOperator",imemberconsumption.lastOperator);
            DWRUtil.setValue("lastOperatorTime",imemberconsumption.lastOperatorTime);
            DWRUtil.setValue("memo",imemberconsumption.memo);
            DWRUtil.setValue("dr",imemberconsumption.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}
function save(){
    var warnArr = new Array();
   // alert("开始保存信息");
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    //alert("bl的值为"+bl);
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrImemberconsumptionService.updateIMemberConsumption(getImemberconsumption(),updateCallback);
        }else{
        	alert("开始保存信息");
            dwrImemberconsumptionService.saveIMemberConsumption(getImemberconsumption(),saveCallback);
        }
    }
}
function getImemberconsumption(){
    var imemberconsumption = new Object();
    if(<%=isedit%>){
        imemberconsumption.primaryKey = '<%=pk%>';
    }
    imemberconsumption.memberId = DWRUtil.getValue("memberId");
    imemberconsumption.memberName = DWRUtil.getValue("memberName");
    imemberconsumption.consumptionContent = DWRUtil.getValue("consumptionContent");
    imemberconsumption.consumptionTime = DWRUtil.getValue("consumptionTime");
    imemberconsumption.firstOperator = DWRUtil.getValue("firstOperator");
    imemberconsumption.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    imemberconsumption.lastOperator = DWRUtil.getValue("lastOperator");
    imemberconsumption.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    imemberconsumption.memo = DWRUtil.getValue("memo");
    imemberconsumption.dr = DWRUtil.getValue("dr");
    return imemberconsumption;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员消费成功！是否想继续添加会员消费？","reset();","继续添加","closePage();","关闭页面");
    }else{
        alertmsg(data);
    }
}
function updateCallback(data){
    //Btn.open();
    if(data.success){
        alertmsg(data,"closePage();");
    }else{
        alertmsg(data);
    }
}
function reset(){
    Sys.reload();
}
function closePage(){
    closeMDITab(<%=tab%>);
}

<!--新增部分,用于选择人员-->
function getupcode(){
	if(<%=gid%>!=null){
		//用于得到用户名
		var box = SEL.getMemberNames("memberName","memberId","getusermsg()");
		box.show();
	}else{
	  	var box = SEL.getMemberNames("memberName","memberId","getusermsg()");
		box.show();
	}
}
</script>
</head>
<body class="inputcls">
    <div class="formDetail">
        <div class="requdiv"><label id="helpTitle"></label></div>
        <div class="formTitle"><%=saveOrEdit%>会员消费</div>
        <table class="inputtable">
            <tr>
               
                 <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input>
                      <button    onclick="getupcode()" >选择用户</button>
                    <label id="memberNameMust"></label>
                </td>
                
               <!--  注意此处，formust错误的话会导致页面无反应 -->
                 <th><em>*</em>&nbsp;&nbsp消费时间</th>   
                 <td>
						    <input type="text" must="消费时间不能为空!" readonly="readonly" id="consumptionTime" formust="consumptionTimeMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						    <label id="consumptionTimeMust"></label>
			      </td> 
            </tr>
                    
            <tr>
              <th>消费明细</th>
				<td colspan="3">
				<textarea id="consumptionContent"  width="90%" style="height: 150px;" formust="consumptionContentMust"></textarea>		
				<label id="consumptionContentMust"></label>
				</td>
            </tr>
             
            <tr>
              <th>备注</th>
				<td colspan="3">
				<textarea id="memo"  width="90%" style="height: 150px;" ></textarea>		
				</td>
            </tr>
            
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员消费信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
