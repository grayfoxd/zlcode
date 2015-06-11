<%@ page pageEncoding="UTF-8" language="java"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.centling.common.util.UtilTool"%>
<%@page import="com.iseen.sysbase.core.pojo.IHealthIndicator"%>
<%@page import="com.iseen.sysbase.core.service.HealthIndicatorService"%>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader("Expires",0);
String treetype = request.getParameter("treetype");
String methodcode = request.getParameter("code");
if(methodcode == null||methodcode.length()==0){
	return;
}else if(methodcode.equals("-2")){
	//add root node
	StringBuffer sb = new StringBuffer();
	sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
	sb.append("<tree>\n");
	String srcTemp ="src=\""+request.getContextPath()+"/erp/baseui/i_health_indicator_tree_select.jsp?code=-1"+"&treetype="+treetype+"\"";
	sb.append("<tree type=\""+treetype+"\"  id =\""+"-1"+"\" text=\""+"顶级\" value=\""+"-1"+"\" "+srcTemp+"/>\n");
	sb.append("</tree>");
	UtilTool.writeTextXml(response,sb.toString());
}else{
	WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	HealthIndicatorService healthService =(HealthIndicatorService) webAppContext.getBean("healthIndicatorService");
	List<IHealthIndicator> healthlist = healthService.getIHealthIndicatorListByUpCode(methodcode);
	if(healthlist!=null&& healthlist.size()>0){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<tree>\n");
		for(int i=0;i<healthlist.size();i++){
			IHealthIndicator item = healthlist.get(i);
			String tmp = "";
			String icon="";
			
			int row = healthService.getHealthIndicatorListByUpCodeCount(item.getPrimaryKey());
			if(row>0){
				tmp ="src=\""+request.getContextPath()+"/erp/baseui/i_health_indicator_tree_select.jsp?code="+item.getPrimaryKey()+"&treetype="+treetype+"\"";
			}
			//输出树节点
			sb.append("<tree type=\""+treetype+"\"  id =\""+item.getPrimaryKey()+"\" text=\""+item.getIndicatorName()+"\" value=\""+item.getPrimaryKey()+"\" "+tmp+" "+icon+"/>\n");
		}                        
		sb.append("</tree>");
		UtilTool.writeTextXml(response,sb.toString());
	}
}
%>
