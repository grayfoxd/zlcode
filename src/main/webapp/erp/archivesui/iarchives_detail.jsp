<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@include file="/erp/common.jsp" %>
<%
    String pk = request.getParameter("pk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员档案录入明细</title>
<script type="text/javascript" src="<%=contextPath%>/dwr/interface/dwrIarchivesService.js"></script>
<script type="text/javascript">
window.onload = function(){
    dwrIarchivesService.getIArchivesByPk('<%=pk%>',setPageValue);
}
function setPageValue(data){
    if(data.success == true){
        if(data.resultList.length > 0){
            var iarchives = data.resultList[0];
            DWRUtil.setValue("memberId",iarchives.memberId);
            DWRUtil.setValue("archiveType",iarchives.archiveType);
            DWRUtil.setValue("archiveName",iarchives.archiveName);
            DWRUtil.setValue("dataFrom",iarchives.dataFrom);
           //  DWRUtil.setValue("indicatorUpload",iarchives.indicatorUpload);
           // DWRUtil.setValue("imageUpload",iarchives.imageUpload);
           //DWRUtil.setValue("allUpload",iarchives.allUpload); 
            //放入附件
            if(isNotBlank(iarchives.indicatorUpload)){
                Sys.showDownload(iarchives.indicatorUpload,"indicatorUpload");
            }
            //放入附件
            if(isNotBlank(iarchives.imageUpload)){
                Sys.showDownload(iarchives.imageUpload,"imageUpload");
            }
            //放入附件
            if(isNotBlank(iarchives.allUpload)){
                Sys.showDownload(iarchives.allUpload,"allUpload");
            }
            DWRUtil.setValue("firstOperator",iarchives.firstOperator);
            DWRUtil.setValue("firstOperatorTime",iarchives.firstOperatorTime);
            DWRUtil.setValue("lastOperator",iarchives.lastOperator);
            DWRUtil.setValue("lastOperatorTime",iarchives.lastOperatorTime);
            DWRUtil.setValue("memo",iarchives.memo);
            DWRUtil.setValue("dr",iarchives.dr);
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
    <div class="requdivdetail"><label>查看帮助:&nbsp; 显示会员档案录入相关信息！</label></div>
    <div class="detailtitle">会员档案录入明细</div>
    <table class="detailtable">
        <tr>
            <th>会员id</th>
            <td id="memberId" class="detailtabletd"></td>
            <th>档案类型</th>
            <td id="archiveType" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>档案名称</th>
            <td id="archiveName" class="detailtabletd"></td>
            <th>数据来源</th>
            <td id="dataFrom" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>指标附件</th>
            <td id="indicatorUpload" class="detailtabletd"></td>
            <th>影像附件</th>
            <td id="imageUpload" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>档案附件</th>
            <td id="allUpload" class="detailtabletd"></td>
            <th>添加人</th>
            <td id="firstOperator" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>添加时间</th>
            <td id="firstOperatorTime" class="detailtabletd"></td>
            <th>最后修改人</th>
            <td id="lastOperator" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>最后修改时间</th>
            <td id="lastOperatorTime" class="detailtabletd"></td>
            <th>备注</th>
            <td id="memo" class="detailtabletd"></td>
        </tr>
        <tr>
            <th>是否删除</th>
            <td id="dr" class="detailtabletd"></td>
            <th></th><td></td>
        </tr>
    </table>
</body>
</html>
