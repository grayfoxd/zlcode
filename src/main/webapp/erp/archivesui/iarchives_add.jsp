<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String tab = request.getParameter("tab");
    String pk = request.getParameter("pk");
    String gid = request.getParameter("gid");//选择人员的新增部分
    String isedit = "false";
    String saveOrEdit = "新增";
    String helpTitle = "您可以在此处添加您想新增的会员档案录入！";
    if(pk != null){
        isedit = "true";
        saveOrEdit = "编辑";
        helpTitle = "您可以在此处编辑会员档案录入信息！";
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=saveOrEdit%>会员档案录入</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrIarchivesService.js"></script>
<script type="text/javascript">
window.onload = function(){
    useLoadingMassage();
    initInput("helpTitle","<%=helpTitle%>");
    saveOrEdit();
}
function saveOrEdit(){
    if(<%=isedit%>){
        var pk = '<%=pk%>';
        dwrIarchivesService.getIArchivesByPk(pk,setIarchives);
    }
}


<!--新增部分-->
var fckvalue = "";
var fck;
function FCKeditor_OnComplete(editorInstance) {
    fck = editorInstance;
    editorInstance.SetHTML(fckvalue);
    window.status = editorInstance.Description;
}
<!--新增部分-->


function setIarchives(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchives = data.resultList[0];
            DWRUtil.setValue("memberId",iarchives.memberId);
            DWRUtil.setValue("archiveType",iarchives.archiveType);
            DWRUtil.setValue("archiveName",iarchives.archiveName);
            DWRUtil.setValue("dataFrom",iarchives.dataFrom);
           //  DWRUtil.setValue("indicatorUpload",iarchives.indicatorUpload);
           // DWRUtil.setValue("imageUpload",iarchives.imageUpload);
          //  DWRUtil.setValue("allUpload",iarchives.allUpload);
            DWRUtil.setValue("firstOperator",iarchives.firstOperator);
            DWRUtil.setValue("firstOperatorTime",iarchives.firstOperatorTime);
            DWRUtil.setValue("lastOperator",iarchives.lastOperator);
            DWRUtil.setValue("lastOperatorTime",iarchives.lastOperatorTime);
            //DWRUtil.setValue("memo",iarchives.memo);
            DWRUtil.setValue("dr",iarchives.dr);
            <!--新增部分-->
            fckvalue = iarchives.memo;
            if(isNotBlank(iarchives.indicatorUpload)){
                dwrCommonService.getAttachmentInfoListToString(iarchives.indicatorUpload,function(data){Sys.setFilevalue("indicatorUpload",data);});
            }
            
            
            if(isNotBlank(iarchives.imageUpload)){
                dwrCommonService.getAttachmentInfoListToString(iarchives.imageUpload,function(data){Sys.setFilevalue("imageUpload",data);});
            }
            
            
            if(isNotBlank(iarchives.allUpload)){
                dwrCommonService.getAttachmentInfoListToString(iarchives.allUpload,function(data){Sys.setFilevalue("allUpload",data);});
            }
            <!--新增部分-->
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
        var attach=new Array();
        attach[0] = DWRUtil.getValue("indicatorUpload");//附件
        attach[1] = DWRUtil.getValue("imageUpload");//附件
         attach[2] = DWRUtil.getValue("allUpload");//附件
        //Btn.close();
        if(<%=isedit%>){
            dwrIarchivesService.updateIArchives(getIarchives(),attach,updateCallback);
        }else{
            dwrIarchivesService.saveIArchives(getIarchives(),attach,saveCallback);
        }
    }
}
function getIarchives(){
    var iarchives = new Object();
    if(<%=isedit%>){
        iarchives.primaryKey = '<%=pk%>';
    }
    iarchives.memberId = DWRUtil.getValue("memberId");
    iarchives.archiveType = DWRUtil.getValue("archiveType");
    iarchives.archiveName = DWRUtil.getValue("archiveName");
    iarchives.dataFrom = DWRUtil.getValue("dataFrom");
    // iarchives.indicatorUpload = DWRUtil.getValue("indicatorUpload");
    //iarchives.imageUpload = DWRUtil.getValue("imageUpload");
    //iarchives.allUpload = DWRUtil.getValue("allUpload");
    iarchives.firstOperator = DWRUtil.getValue("firstOperator");
    iarchives.firstOperatorTime = DWRUtil.getValue("firstOperatorTime");
    iarchives.lastOperator = DWRUtil.getValue("lastOperator");
    iarchives.lastOperatorTime = DWRUtil.getValue("lastOperatorTime");
    //iarchives.memo = DWRUtil.getValue("memo");
    iarchives.memo = fck.GetXHTML();
    iarchives.dr = DWRUtil.getValue("dr");
    return iarchives;
}
function saveCallback(data){
    //Btn.open();
    if(data.success){
        confirmmsgAndTitle("添加会员档案录入成功！是否想继续添加会员档案录入？","reset();","继续添加","closePage();","关闭页面");
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
        <div class="formTitle"><%=saveOrEdit%>会员档案录入</div>
        <table class="inputtable">
            <tr>
                <th><em>*</em>&nbsp;&nbsp;会员姓名</th>
                <td>
                    <input type="text" id="memberName" must="会员姓名不能为空!" formust="memberNameMust"></input>
                      <button    onclick="getupcode()" >选择用户</button>
                    <label id="memberNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;档案类型</th>
                <td>
                    <input type="text" id="archiveType" must="档案类型不能为空!" formust="archiveTypeMust"></input><label id="archiveTypeMust"></label>
                </td>
            </tr>
            
            
            
            
          <tr>
                <th><em>*</em>&nbsp;&nbsp;档案名称</th>
                <td>
                    <input type="text" id="archiveName" must="档案名称不能为空!" formust="archiveNameMust"></input><label id="archiveNameMust"></label>
                </td>
                <th><em>*</em>&nbsp;&nbsp;数据来源</th>
                <td>
                    <input type="text" id="dataFrom" must="数据来源不能为空!" formust="dataFromMust"></input><label id="dataFromMust"></label>
                </td>
            </tr>
          
       <tr>
				<th>指标附件</th>
				<td  colspan="3">
				<file:multifileupload width="90%" acceptTextId="indicatorUpload" height="100" saveType="file" edit="<%=isedit%>"></file:multifileupload>
				</td>
		</tr>	
		
		
		 <tr>
				<th>影像附件</th>
				<td  colspan="3">
				<file:multifileupload width="90%" acceptTextId="imageUpload" height="100" saveType="file" edit="<%=isedit%>"></file:multifileupload>
				</td>
		  </tr>
		  
		    <tr>       
                <th>档案附件</th>
				<td  colspan="3">
				<file:multifileupload width="90%" acceptTextId="allUpload" height="100" saveType="file" edit="<%=isedit%>"></file:multifileupload>
				</td>
             </tr>
              
         <tr>	
             <th><em>*</em>&nbsp;&nbsp;备注</th>
                <td colspan="3">
                    <label id="memoMust"></label><FCK:editor instanceName="memo"  width="90%" height="250"></FCK:editor>
                </td>
			 
		</tr>
        </table>
    </div>
    <table align="center">
        <tr>
            <td><btn:btn onclick="save();" value="保 存 " imgsrc="../../images/png-1718.png" title="保存会员档案录入信息" /></td>
            <td style="width:20px;"></td>
            <td><btn:btn onclick="closePage();" value="关 闭 " imgsrc="../../images/winclose.png" title="关闭当前页面"/></td>
        </tr> 
    </table>
</body>
</html>
