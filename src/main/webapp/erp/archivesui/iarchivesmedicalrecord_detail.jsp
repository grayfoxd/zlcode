<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员病历录入明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwri_archives_medicalrecordService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwri_archives_medicalrecordService.getIArchivesMedicalrecordByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchivesmedicalrecord = data.resultList[0];
            DWRUtil.setValue("memberName",iarchivesmedicalrecord.memberId);
            DWRUtil.setValue("hospitalName",iarchivesmedicalrecord.hospitalName);
            DWRUtil.setValue("diagnoseData",iarchivesmedicalrecord.diagnoseData);
            
            DWRUtil.setValue("diagnoseContent",iarchivesmedicalrecord.diagnoseContent,{escapeHtml:false});
            
           // DWRUtil.setValue("diagnoseContent",iarchivesmedicalrecord.diagnoseContent);
            DWRUtil.setValue("department",iarchivesmedicalrecord.department);
           // DWRUtil.setValue("fileUploadaddress",iarchivesmedicalrecord.fileUploadaddress);
            if(isNotBlank(iarchivesmedicalrecord.fileUploadaddress)){
                Sys.showDownload(iarchivesmedicalrecord.fileUploadaddress,"fileUploadaddress");
            }
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
</script>
</head>
<body class="inputdetail">
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员病历录入相关信息！</label></div>
    <div class="detailtitle">会员病历录入明细</div>
    <table class="detailtable">
        <tr>
            <th>会员姓名</th>
            <td id="memberName" class="detailtabletd"></td>
            <th>医院名称</th>
            <td id="hospitalName" class="detailtabletd"></td>
        </tr>
        
        
        <tr>
            <th>诊断日期</th>
            <td id="diagnoseData" class="detailtabletd"></td>
             
        </tr>
        
        
        <tr>
            <th>科室</th>
            <td id="department" class="detailtabletd"></td>
            <th>附件</th>
            <td id="fileUploadaddress" class="detailtabletd"></td>
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
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
        </tr>
        
        
         <tr  rowspan="2">
                <th  >病历内容</th>
				<td colspan="3"    class="detailtabletd" id="diagnoseContent" >
				</td>
        </tr>
        
        
    </table>
</body>
</html>
