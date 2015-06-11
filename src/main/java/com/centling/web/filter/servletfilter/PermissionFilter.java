package com.centling.web.filter.servletfilter;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.centling.common.module.SessionUser;
import com.centling.common.util.LoginContext;
import com.centling.core.pojo.SysMethodInfo;
import com.centling.web.controller.dwr.DwrSysProcessService;
import com.centling.web.filter.springaop.ExceptionCatcherAdvice;

public class PermissionFilter implements Filter {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionCatcherAdvice.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		//获取当前访问的页面名称
		String tmpUrl = httpRequest.getRequestURL().toString();
		String page = tmpUrl.substring(tmpUrl.lastIndexOf("/")+1,tmpUrl.length());

		boolean permissionFlag = false;
	
		SessionUser sessionUser =  (SessionUser) LoginContext.getSessionValueByLogin(httpRequest);
	
		ServletContext context = httpRequest.getSession().getServletContext();
		WebApplicationContext webctx = WebApplicationContextUtils.getWebApplicationContext(context);
		DwrSysProcessService service = (DwrSysProcessService)webctx.getBean("dwrSysProcessService");
		//根据页面名称获取相关功能菜单
		List<SysMethodInfo> list = service.listSysmethodInfoByPage(context,httpRequest,page);
		//如果没有页面相关的功能菜单，可以访问。
		if(list.size() == 0){
			permissionFlag = true;
		}
		//如果用户有权限的功能菜单包含访问页面相关的功能菜单，可以访问。
		for (SysMethodInfo sysMethodInfo : list) {
			if(sessionUser.getUserMethodsSet().contains(sysMethodInfo.getPrimaryKey())){
				permissionFlag = true;
			}
		}

		if(permissionFlag){
			chain.doFilter(httpRequest, httpResponse);
		}else{
			logger.error("{},IP:{},访问页面:{},没有权限....",sessionUser.getEmployeeName(),request.getRemoteAddr(),page);
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/error.jsp");
		}
		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
