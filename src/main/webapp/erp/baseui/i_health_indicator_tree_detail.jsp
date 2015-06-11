<%@ page pageEncoding="UTF-8" language="java"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.iseen.sysbase.web.controller.dwr.DwrHealthIndicatorService"%>
<%@page import="com.iseen.sysbase.core.pojo.IHealthIndicator"%>
<%@page import="com.centling.common.util.UtilTool"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires",0);
String methodcode = request.getParameter("code");
String methodjs = request.getParameter("method");
if(methodcode == null||methodcode.length()==0){
	return;
}else{
	WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	DwrHealthIndicatorService indicatorService = (DwrHealthIndicatorService)webAppContext.getBean("dwrHealthIndicatorService");
	List<IHealthIndicator> indicatorlist = indicatorService.getIHealthIndicatorByUpCode(methodcode);
	if(indicatorlist!=null&& indicatorlist.size()>0){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<tree>\n");
		for(int i=0;i<indicatorlist.size();i++){
			IHealthIndicator item = indicatorlist.get(i);
			String tmp = "";
			String action ="";
			int row = indicatorService.getIHealthIndicatorByUpCodeCount(item.getPrimaryKey());
			if(row>0){
				tmp ="src=\""+request.getContextPath()+"/erp/baseui/i_health_indicator_tree_detail.jsp?code="+item.getPrimaryKey()+"&method="+methodjs+"\"";
			}
			if(methodjs!=null&&methodjs.length()>0){
				//action = "action=\""+methodjs+"("+"'"+item.getPrimaryKey()+"'"+",'"+item.getItemName()+"');\"";
				action = "action=\""+methodjs+"("+"'"+item.getPrimaryKey()+"');\"";
			}
			//输出树节点
			sb.append("<tree id =\""+item.getPrimaryKey()+"\" text=\""+item.getIndicatorName()+"\" value=\""+item.getPrimaryKey()+"\" "+tmp+" "+action+"/>\n");
		}
		sb.append("</tree>");
		UtilTool.writeTextXml(response,sb.toString());
	}
}
%>
