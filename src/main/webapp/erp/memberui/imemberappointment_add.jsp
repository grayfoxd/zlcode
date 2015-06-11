<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");   
    String gid = request.getParameter("gid");//选择人员的新增部分
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员预约！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员预约信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员预约</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrImemberappointmentService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrImemberappointmentService.getIMemberAppointmentByPk(pk,setImemberappointment);
    }
}

function setImemberappointment(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var imemberappointment = data.resultList[0];
            DWRUtil.setValue("memberId",imemberappointment.memberId);
            DWRUtil.setValue("memberName",imemberappointment.memberName);
            DWRUtil.setValue("appointmentType",imemberappointment.appointmentType);
            DWRUtil.setValue("appointmentContent",imemberappointment.appointmentContent);
            DWRUtil.setValue("expectedTime",imemberappointment.expectedTime);
            DWRUtil.setValue("endTime",imemberappointment.endTime);
            DWRUtil.setValue("processInstanceId",imemberappointment.processInstanceId);
            DWRUtil.setValue("firstOperator",imemberappointment.firstOperator);
            DWRUtil.setValue("firstOperatorTime",imemberappointment.firstOperatorTime);
            DWRUtil.setValue("lastOperator",imemberappointment.lastOperator);
            DWRUtil.setValue("lastOperatorTime",imemberappointment.lastOperatorTime);
            DWRUtil.setValue("memo",imemberappointment.memo);
            DWRUtil.setValue("dr",imemberappointment.dr);
        }else{
            alert(data.message);
        }
    }else{
        alert(data.message);
    }
}
function save(){
    var warnArr = new Array();
    //清空所有信息提示
    warnInit(warnArr);
    var bl = validvalue('helpTitle');
    if(bl){
        //此处可编写js代码进一步验证数据项

        //Btn.close();
        if(<%=isedit%>){
            dwrImemberappointmentService.updateIMemberAppointment(getImemberappointment(),updateCallback);
        }else{
            dwrImemberappointmentService.saveIMemberAppointment(getImemberappointment(),saveCallback);
        }
    }
}
function getImemberappointment(){
    var imemberappointment = new Object();
    if(<%=isedit%>){
        imemberappointment.primaryKey = '<%=pk%>';
    }
    imemberappointment.memberId = DWRUtil.getValue("memberId");
    imemberappointment.memberName = DWRUtil.getValue("memberName");
    imemberappointment.appointmentType = DWRUtil.getValue("appointmentType");
    imemberappointment.appointmentContent = DWRUtil.getValue("appointmentContent");
    imemberappointment.expectedTime = DWRUtil.getValue("expectedTime");
    imemberappointment.endTime = DWRUtil.getValue("endTime");
    imemberappointment.processInstanceId = DWRUtil.getValue("processInstanceId");
    imemberappointment.firstOperator = DWRUtil.getValue("firstOperator");
    imemberappointment.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    imemberappointment.lastOperator = DWRUtil.getValue("lastOperator");
    imemberappointment.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    imemberappointment.memo = DWRUtil.getValue("memo");
    imemberappointment.dr = DWRUtil.getValue("dr");
    return imemberappointment;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员预约成功！是否想继续添加会员预约？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>会员预约</div>
        <table class="inputtable">
            <tr>     
                   <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input>
                      <button    onclick="getupcode()" >选择用户</button>
                    <label id="memberNameMust"></label>
                </td>
                   <th><em>*</em>&nbsp;&nbsp;流程ID</th>
                <td>
                    <input type="text" id="processInstanceId" must="流程ID不能为空!" formust="processInstanceIdMust"></input><label id="processInstanceIdMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;预约类型</th>
                <td>
                    <input type="text" id="appointmentType" must="预约类型不能为空!" formust="appointmentTypeMust"></input><label id="appointmentTypeMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;预约详情</th>
                <td>
                    <input type="text" id="appointmentContent" must="预约详情不能为空!" formust="appointmentContentMust"></input><label id="appointmentContentMust"></label>
                </td>
            </tr>
            <tr>
                <th><em>*</em>&nbsp;&nbsp;预约时间</th>           
                 <td>
						    <input type="text" must="预约时间不能为空!" readonly="readonly" id="expectedTime" formust="expectedTimeMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						    <label id="expectedTimeMust"></label>
			      </td> 
                <th><em>*</em>&nbsp;&nbsp;预约终结时间</th>             
                <td>
						    <input type="text" must="预约终结时间不能为空!" readonly="readonly" id="endTime" formust="endTimeMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						    <label id="endTimeMust"></label>
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
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员预约信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
