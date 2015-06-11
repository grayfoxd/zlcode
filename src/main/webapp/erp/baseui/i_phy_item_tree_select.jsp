<%@ page pageEncoding="UTF-8" language="java"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.centling.common.util.UtilTool"%>
<%@page import="com.iseen.sysbase.core.pojo.IPhyItem"%>
<%@page import="com.iseen.sysbase.core.service.PhyItemService"%>
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
	String srcTemp ="src=\""+request.getContextPath()+"/erp/baseui/i_phy_item_tree_select.jsp?code=-1"+"&treetype="+treetype+"\"";
	sb.append("<tree type=\""+treetype+"\"  id =\""+"-1"+"\" text=\""+"顶级\" value=\""+"-1"+"\" "+srcTemp+"/>\n");
	sb.append("</tree>");
	UtilTool.writeTextXml(response,sb.toString());
}else{
	WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	PhyItemService phyItemService =(PhyItemService) webAppContext.getBean("phyItemService");
	List<IPhyItem> itemlist = phyItemService.getIPhyItemListByUpCode(methodcode);
	if(itemlist!=null&& itemlist.size()>0){
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<tree>\n");
		
		for(int i=0;i<itemlist.size();i++){
			IPhyItem item = itemlist.get(i);
			String tmp = "";
			String icon="";
			
			int row = phyItemService.getPhyItemListByUpCodeCount(item.getPrimaryKey());
			if(row>0){
				tmp ="src=\""+request.getContextPath()+"/erp/baseui/i_phy_item_tree_select.jsp?code="+item.getPrimaryKey()+"&treetype="+treetype+"\"";
			}
			//输出树节点
			sb.append("<tree type=\""+treetype+"\"  id =\""+item.getPrimaryKey()+"\" text=\""+item.getItemName()+"\" value=\""+item.getPrimaryKey()+"\" "+tmp+" "+icon+"/>\n");
		}                        
		sb.append("</tree>");
		UtilTool.writeTextXml(response,sb.toString());
	}
}
%>
