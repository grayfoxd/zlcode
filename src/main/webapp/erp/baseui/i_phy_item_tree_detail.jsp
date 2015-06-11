<%@ page pageEncoding="UTF-8" language="java"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.iseen.sysbase.web.controller.dwr.DwrPhyItemService"%>
<%@page import="com.iseen.sysbase.core.pojo.IPhyItem"%>
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
	DwrPhyItemService itemService = (DwrPhyItemService)webAppContext.getBean("dwrPhyItemService");
	List<IPhyItem> itemlist = itemService.getIPhyItemByUpCode(methodcode);
	if(itemlist!=null&& itemlist.size()>0){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<tree>\n");
		for(int i=0;i<itemlist.size();i++){
			IPhyItem item = itemlist.get(i);
			String tmp = "";
			String action ="";
			int row = itemService.getIPhyItemByUpCodeCount(item.getPrimaryKey());
			if(row>0){
				tmp ="src=\""+request.getContextPath()+"/erp/baseui/i_phy_item_tree_detail.jsp?code="+item.getPrimaryKey()+"&method="+methodjs+"\"";
			}
			if(methodjs!=null&&methodjs.length()>0){
				//action = "action=\""+methodjs+"("+"'"+item.getPrimaryKey()+"'"+",'"+item.getItemName()+"');\"";
				action = "action=\""+methodjs+"("+"'"+item.getPrimaryKey()+"');\"";
			}
			//输出树节点
			sb.append("<tree id =\""+item.getPrimaryKey()+"\" text=\""+item.getItemName()+"\" value=\""+item.getPrimaryKey()+"\" "+tmp+" "+action+"/>\n");
		}
		sb.append("</tree>");
		UtilTool.writeTextXml(response,sb.toString());
	}
}
%>
