<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String gid = request.getParameter("gid");//选择人员的新增部分
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员病历录入！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员病历录入信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员病历录入</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwri_archives_medicalrecordService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwri_archives_medicalrecordService.getIArchivesMedicalrecordByPk(pk,setIarchivesmedicalrecord);
    }
}
<!--新增部分开始-->
var fckvalue = "";
var fck;
function FCKeditor_OnComplete(editorInstance) {
    fck = editorInstance;
    editorInstance.SetHTML(fckvalue);
    window.status = editorInstance.Description;
}
<!--新增部分结束-->

function setIarchivesmedicalrecord(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchivesmedicalrecord = data.resultList[0];
            DWRUtil.setValue("memberId",iarchivesmedicalrecord.memberId);
            DWRUtil.setValue("memberName",iarchivesmedicalrecord.memberName);
            
            DWRUtil.setValue("hospitalName",iarchivesmedicalrecord.hospitalName);
            DWRUtil.setValue("diagnoseData",iarchivesmedicalrecord.diagnoseData);
            fckvalue = iarchivesmedicalrecord.diagnoseContent;
            DWRUtil.setValue("diagnoseContent",iarchivesmedicalrecord.diagnoseContent);
            
            DWRUtil.setValue("department",iarchivesmedicalrecord.department);
            
            if(isNotBlank(iarchivesmedicalrecord.fileUploadaddress)){
                dwrCommonService.getAttachmentInfoListToString(iarchivesmedicalrecord.fileUploadaddress,function(data){Sys.setFilevalue("fileUploadaddress",data);});
            }
            //DWRUtil.setValue("fileUploadaddress",iarchivesmedicalrecord.fileUploadaddress);
            DWRUtil.setValue("firstOperator",iarchivesmedicalrecord.firstOperator);
            DWRUtil.setValue("firstOperatorTime",iarchivesmedicalrecord.firstOperatorTime);
            DWRUtil.setValue("lastOperator",iarchivesmedicalrecord.lastOperator);
            DWRUtil.setValue("lastOperatorTime",iarchivesmedicalrecord.lastOperatorTime);
            DWRUtil.setValue("memo",iarchivesmedicalrecord.memo);
            DWRUtil.setValue("dr",iarchivesmedicalrecord.dr);
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
         var attach = DWRUtil.getValue("fileUploadaddress");//附件(新增)
        //Btn.close();
        if(<%=isedit%>){
            dwri_archives_medicalrecordService.updateIArchivesMedicalrecord(getIarchivesmedicalrecord(),attach,updateCallback);
        }else{
            dwri_archives_medicalrecordService.saveIArchivesMedicalrecord(getIarchivesmedicalrecord(),attach,saveCallback);
        }
    }
}
function getIarchivesmedicalrecord(){
    var iarchivesmedicalrecord = new Object();
    if(<%=isedit%>){
        iarchivesmedicalrecord.primaryKey = '<%=pk%>';
    }
    iarchivesmedicalrecord.memberId = DWRUtil.getValue("memberId");
    iarchivesmedicalrecord.memberName = DWRUtil.getValue("memberName");
    iarchivesmedicalrecord.hospitalName = DWRUtil.getValue("hospitalName");
    iarchivesmedicalrecord.diagnoseData = DWRUtil.getValue("diagnoseData");
    iarchivesmedicalrecord.diagnoseContent = fck.GetXHTML();
    iarchivesmedicalrecord.diagnoseContent = DWRUtil.getValue("diagnoseContent");
    iarchivesmedicalrecord.department = DWRUtil.getValue("department");
   // iarchivesmedicalrecord.fileUploadaddress = DWRUtil.getValue("fileUploadaddress");
    iarchivesmedicalrecord.firstOperator = DWRUtil.getValue("firstOperator");
    iarchivesmedicalrecord.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    iarchivesmedicalrecord.lastOperator = DWRUtil.getValue("lastOperator");
    iarchivesmedicalrecord.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    iarchivesmedicalrecord.memo = DWRUtil.getValue("memo");
    iarchivesmedicalrecord.dr = DWRUtil.getValue("dr");
    return iarchivesmedicalrecord;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员病历录入成功！是否想继续添加会员病历录入？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>会员病历录入</div>
        <table class="inputtable">
            <tr>
                  <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <div>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input>
                    <button    onclick="getupcode()" >选择用户</button>
                    <label id="memberNameMust"></label>
                    </div>
                </td>
                <th><em>*</em>&nbsp;&nbsp;医院名称</th>
                <td>
                    <input type="text" id="hospitalName" must="医院名称不能为空!" formust="hospitalNameMust"></input><label id="hospitalNameMust"></label>
                </td>
            </tr>
            
            
            
            <tr>    
                 <th><em>*</em>&nbsp;&nbsp;诊断日期</th>
                     
                <td>
						  
						 <input type="text" must="诊断日期不能为空！" readonly="readonly" id="diagnoseData" formust="diagnoseDataMust" class="Wdate" onClick="WdatePicker({maxDate:'%y-%M-%d'})" value="<%=UtilWork.getToday() %>">
						 <label id="diagnoseDataMust"></label>
				</td>
                <th><em>*</em>&nbsp;&nbsp;科室</th>
                <td>
                    <input type="text" id="department" must="科室不能为空!" formust="departmentMust"></input><label id="departmentMust"></label>
                </td>
               
               
            </tr>
            
            
            
            
          
            
         
          <tr>	
				<th><em>*</em>病历内容</th>
				<td colspan="3">
				<FCK:editor instanceName="diagnoseContent"    width="90%" height="250" ></FCK:editor>
				<!-- <textarea id="diagnoseContent"  width="90%" style="height: 150px;" ></textarea>	 -->	
				</td>
		</tr>
         
          <tr>	
				<th>备注</th>
				<td colspan="3">
				<textarea id="memo"  width="90%" style="height: 150px;" ></textarea>		
				</td>
		</tr>
		
		
		 <tr>
				<th>附件上传</th>
				<td  colspan="3">
				<file:multifileupload width="90%" acceptTextId="fileUploadaddress" height="100" saveType="file" edit="<%=isedit%>"></file:multifileupload>
				</td>
		</tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员病历录入信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr>
    </table>
</body>
</html>
