package com.iseen.member.web.controller.dwr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.centling.common.module.ResultBean;
import com.centling.common.pages.Pager;
import com.centling.common.pages.PagerHelper;
import com.centling.common.util.UtilPrimaryKey;
import com.centling.common.util.UtilTool;
import com.centling.common.util.UtilWork;
import com.centling.common.util.WebUtilWork;
import com.centling.core.iservice.IHrmEmployeeService;
import com.centling.core.pojo.SysUserGroup;
import com.iseen.member.core.iservice.IserviceInfoService;
import com.iseen.member.core.pojo.IServiceInfo;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrserviceInfoService {

    private final static Logger logger = LoggerFactory.getLogger(DwrserviceInfoService.class);

    @Resource
    private IserviceInfoService serviceInfoService;
    
    @Resource
    private IHrmEmployeeService hrmEmployeeService;

    /**
     * 查询 IServiceInfo 分页列表
     * @param context
     * @param request
     * @param iServiceInfo
     * @param pager
     */
    public ResultBean listIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo, Pager pager){
        List<IServiceInfo> list = null;
        pager = PagerHelper.getPager(pager,serviceInfoService.listIServiceInfoCount(iServiceInfo));
        list = serviceInfoService.listIServiceInfo(iServiceInfo, pager);
        Iterator<IServiceInfo> it = list.iterator();
		List<IServiceInfo> vo_list = new ArrayList<IServiceInfo>();
		while (it.hasNext()) {
			IServiceInfo iserviceinfo = (IServiceInfo) it.next();
			try {
				iserviceinfo.setFirstOperator(hrmEmployeeService
						.getEmployeeByPK(iserviceinfo.getFirstOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								iserviceinfo.getFirstOperator())
								.getHrmEmployeeName());
				iserviceinfo.setLastOperator(hrmEmployeeService
						.getEmployeeByPK(iserviceinfo.getLastOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								iserviceinfo.getLastOperator())
								.getHrmEmployeeName());
				vo_list.add(iserviceinfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        logger.info("查询 IServiceInfo 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IServiceInfo 列表
     * @param context
     * @param request
     * @param iServiceInfo
     * @param pager
     */
    public ResultBean listIServiceInfoAll(ServletContext context, HttpServletRequest request){
        IServiceInfo iServiceInfo = new IServiceInfo();
        List<IServiceInfo> list = serviceInfoService.listIServiceInfo(iServiceInfo);
        logger.info("查询所有 IServiceInfo 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IServiceInfo
     * @param context
     * @param request
     * @param iServiceInfo
     */
    public ResultBean saveIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo){
        String empid = UtilTool.getEmployeeId(request);
        try {
			iServiceInfo.initSave(empid);
			iServiceInfo.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServiceInfo.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServiceInfo.setFirstOperator(UtilTool.getEmployeeId(request));
			iServiceInfo.setFirstOperatorTime(UtilWork.getNowTime());
			iServiceInfo.setLastOperator(UtilTool.getEmployeeId(request));
			iServiceInfo.setLastOperatorTime(UtilWork.getNowTime());
			iServiceInfo.setLastmodiId(UtilTool.getEmployeeId(request));
			iServiceInfo.setLastmodiDate(UtilWork.getNowTime());
			iServiceInfo.setDr("N");
			serviceInfoService.saveIServiceInfo(iServiceInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("保存 IServiceInfo...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IServiceInfo
     * @param context
     * @param request
     * @param iServiceInfo
     */
    public ResultBean updateIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo){
        IServiceInfo tmp = serviceInfoService.getIServiceInfoByPk(iServiceInfo.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        try {
			iServiceInfo.initUpdate(empid);
			tmp.setServiceInfoCode(iServiceInfo.getServiceInfoCode());
			tmp.setServiceInfoName(iServiceInfo.getServiceInfoName());
			tmp.setCrowd(iServiceInfo.getCrowd());
			tmp.setMeasuringUnit(iServiceInfo.getMeasuringUnit());
			tmp.setMeasuringUnitPrice(iServiceInfo.getMeasuringUnitPrice());
			tmp.setMemo(iServiceInfo.getMemo());
			tmp.initUpdate(empid);
			tmp.setLastOperator(UtilTool.getEmployeeId(request));
			tmp.setLastOperatorTime(UtilWork.getNowTime());
			serviceInfoService.saveIServiceInfo(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("更新 IServiceInfo...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IServiceInfo
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIServiceInfoByPk(ServletContext context, HttpServletRequest request, String pk){
        IServiceInfo iServiceInfo = serviceInfoService.getIServiceInfoByPk(pk);
        iServiceInfo.setFirstOperator(hrmEmployeeService
 				.getEmployeeByPK(iServiceInfo.getFirstOperator()) == null ? ""
 				: hrmEmployeeService.getEmployeeByPK(
 						iServiceInfo.getFirstOperator())
 						.getHrmEmployeeName());
        iServiceInfo.setLastOperator(hrmEmployeeService
 				.getEmployeeByPK(iServiceInfo.getLastOperator()) == null ? ""
 				: hrmEmployeeService.getEmployeeByPK(
 						iServiceInfo.getLastOperator())
 						.getHrmEmployeeName());
        logger.info("根据ID获得 IServiceInfo...{}", iServiceInfo.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iServiceInfo);
    }

    /**
     * 删除 IServiceInfo
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIServiceInfoByPks(ServletContext context, HttpServletRequest request, String[] pks){
        serviceInfoService.deleteIServiceInfoByPks(pks,null);
        for (String pk : pks) {
            logger.info("删除 IServiceInfo...{}", pk);
        }
        return WebUtilWork.WebResultPack(null);
    }

/**********************************************
 * 以上代码由CTOA代码生成工具自动生成，请根据具体需求进行修改。
 * 开发人员在此注释以下编写业务逻辑代码，并将自己写的代码框起来，便于后期代码合并，例如：
 **********************************************/

/**********************JC-begin**********************/
    public void method(){
        System.out.println("JC's code here");
    }
    
    /**
     * 根据ID获得 IServiceInfos
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIServiceInfoByPks(ServletContext context, HttpServletRequest request, String pks){
    	List<IServiceInfo> list = serviceInfoService.listIServiceInfo(pks);
    	
    	System.out.println(list.size());
        return WebUtilWork.WebObjectPack(list);
    }
/**********************JC-end**********************/

/**********************Jacy-begin**********************/
    public void method2(){
        System.out.println("Jacy's code here");
    }
/**********************Jacy-end**********************/

}