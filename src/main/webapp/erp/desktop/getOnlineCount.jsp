<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="com.centling.web.listener.OnlineUserBindingListener"%>
<%@page import="com.centling.common.util.UtilTool"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires",0);
Set<String> onlineSet = OnlineUserBindingListener.getOnlineList(this.getServletContext(),UtilTool.getCompanyId(request));
int count = onlineSet.size()<0?0:onlineSet.size();
out.print(count);
%>