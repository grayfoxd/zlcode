<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%//fckeditor组件%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>

<%//文件及图片上传组件 %>
<%@ taglib uri="http://www.centling.com/taglibs/filetag" prefix="file"%>

<%//按钮组件 %>
<%@ taglib uri="http://www.centling.com/taglibs/buttontag" prefix="btn"%>

<%//table组件 %>
<%@ taglib uri="http://www.centling.com/taglibs/tabletag" prefix="sys"%>

<%@page import="com.centling.common.exception.*" %>
<%@page import="com.centling.common.module.*" %>
<%@page import="com.centling.common.pack.*" %>
<%@page import="com.centling.common.pages.*" %>
<%@page import="com.centling.common.util.*" %>
<%@page import="com.centling.common.util.file.*" %>
<%@page import="com.centling.common.util.net.*" %>
<%@page import="com.centling.common.util.os.command.*" %>
<%@page import="com.centling.common.util.path.*" %>
<%@page import="com.centling.common.util.security.*" %>
<%@page import="com.centling.common.util.file.office.*" %>
<%@page import="com.centling.common.util.standardCode.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="java.text.*" %>
<%@page import="com.centling.core.iservice.*" %>
<%@page import="com.centling.core.pojo.*" %>
<%@page import="com.centling.core.iservice.*" %>
<%@page import="com.centling.web.controller.dwr.*" %>
<%@page import="com.centling.web.taglib.*" %>
<%@page import="com.centling.web.taglib.table.*" %>
<%@page import="com.centling.web.taglib.table.cloumntype.*" %>
<%@page import="com.centling.common.util.file.properties.*" %>
<%@page import="com.centling.common.util.security.Base64"%>


<%
//项目相对及绝对路径
String contextPath = request.getContextPath();
String absPath = this.getServletContext().getRealPath("");
%>


<link rel='Shortcut Icon' href='<%=contextPath%>/favicon.ico' />
<link rel='Bookmark' href='<%=contextPath%>/favicon.ico' />

<link type='text/css' rel='stylesheet'  href='<%=contextPath%>/css/normal.css' />
<link type='text/css' rel='stylesheet' href='<%=contextPath%>/js/artDialog/skins/blue.css' />
<script type='text/javascript' src='<%=contextPath %>/js/artDialog/artDialog.source.js'></script>

<script type='text/javascript' src='<%=contextPath%>/js/normalutil.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/pageToservice.js'></script>
<script type='text/javascript'>
Sys.setProjectcode('<%=ConstWords.getProjectCode()%>');
Sys.setProjectPath('<%=contextPath%>');
</script>
<script type='text/javascript' src='<%=contextPath%>/js/cookie.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/util.js'></script>
<script type='text/javascript' src='<%=contextPath%>/dwr/interface/dwrCommonService.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/dateJs/WdatePicker.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/tabJs/sys_tab.js'></script>

<link type='text/css' rel='stylesheet' href='<%=contextPath%>/js/sys_btn/skin/default/btnskin.css' />
<script type='text/javascript' src='<%=contextPath%>/js/sys_btn/sys_btn.js'></script>
		
<link type='text/css' rel='stylesheet' href='<%=contextPath%>/css/sysgrid.css' />
<link type='text/css' rel='stylesheet' href='<%=contextPath%>/css/formstyle.css' />
<script type='text/javascript' src='<%=contextPath%>/js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/formjs.js'></script>
<script type='text/javascript'>
formStylePath.setImagePath('<%=contextPath%>/images/');
</script>
<script type='text/javascript' src='<%=contextPath%>/js/tipalert/alertWin.js'></script>
<link type='text/css' rel='stylesheet' href='<%=contextPath%>/js/tipalert/alertwin.css'/>
<script type='text/javascript' src='<%=contextPath%>/js/selectJs.js'></script>
<script type='text/javascript'>
SEL.setProjectPath('<%=contextPath%>');
</script>

<!-- 左右分栏效果 -->
<script type='text/javascript' src='<%=contextPath%>/js/split/splitter.js'></script>
<link type='text/css' rel='stylesheet' href='<%=contextPath%>/js/split/style.css' />

<script type='text/javascript' src='<%=contextPath%>/js/contextmenu.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/jcarousellite.js'></script>
<script type='text/javascript' src='<%=contextPath%>/js/jquery.hotkeys.js'></script>

<div style='display:none;' id='clearMenu'>
	<ul>
		<li id='clear'>
		<img src="<%=contextPath%>/images/clearinput.png" height="14"> 清 除
		</li>
	</ul>
</div>
<input type="hidden" id="onlinecount" value="0"/>
<input type="hidden" id="onlinecountsessionid" value="0"/>
<script type="text/javascript">
function loginOut(){
	var vl = document.getElementById("onlinecount").value;
	if(vl=="0"){
		document.getElementById("onlinecount").value ="1";
		window.top.location.href = "<%=contextPath%>/centerSend.jsp";	
	}
}

function warningmsg(){
	var vl = document.getElementById("onlinecountsessionid").value;
	if(vl=="0"){
		document.getElementById("onlinecountsessionid").value ="1";
		Sys.alert("当前用户在其他地方登录或者未正常退出,点击确定返回登录！\n如有其它疑问，请联系管理员。",reloadlogin);
	}
}

function errormsg(){
	Sys.alert("系统好像出问题了，请截图保存后及时与技术人员联系！\n\n"+ getFullCurrentDate());
}

function reloadlogin(){
	window.top.location.href = "<%=contextPath%>/login.jsp"
}

window.status ="xxx (c)2008-2015";
</script>
