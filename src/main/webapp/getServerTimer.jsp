<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@page import="com.centling.common.util.UtilWork"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires",0);
%>
<%out.print(UtilWork.getCustomerDay("yyyy-M-d-HH-mm-ss-E-a"));%>