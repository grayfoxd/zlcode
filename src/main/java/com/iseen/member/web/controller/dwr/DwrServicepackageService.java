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
import com.iseen.member.core.iservice.IServicepackageService;
import com.iseen.member.core.pojo.IServiceDetail;
import com.iseen.member.core.pojo.IServicePackage;

/**********************************************
 * Class name: Description: 服务套餐维护 Others: History:
 **********************************************/
@Controller
public class DwrServicepackageService {

	private final static Logger logger = LoggerFactory
			.getLogger(DwrServicepackageService.class);

	@Resource
	private IServicepackageService servicepackageService;

	@Resource
	private IHrmEmployeeService hrmEmployeeService;

	/**
	 * 查询 IServicePackage 分页列表
	 * 
	 * @param context
	 * @param request
	 * @param iServicePackage
	 * @param pager
	 */
	public ResultBean listIServicePackage(ServletContext context,
			HttpServletRequest request, IServicePackage iServicePackage,
			Pager pager) {
		List<IServicePackage> list = null;
		pager = PagerHelper
				.getPager(pager, servicepackageService
						.listIServicePackageCount(iServicePackage));
		list = servicepackageService
				.listIServicePackage(iServicePackage, pager);
		Iterator<IServicePackage> it = list.iterator();
		List<IServicePackage> vo_list = new ArrayList<IServicePackage>();
		while (it.hasNext()) {
			IServicePackage iservicepackage = (IServicePackage) it.next();
			try {
				iservicepackage
						.setFirstOperator(hrmEmployeeService
								.getEmployeeByPK(iservicepackage
										.getFirstOperator()) == null ? ""
								: hrmEmployeeService.getEmployeeByPK(
										iservicepackage.getFirstOperator())
										.getHrmEmployeeName());
				iservicepackage
						.setLastOperator(hrmEmployeeService
								.getEmployeeByPK(iservicepackage
										.getLastOperator()) == null ? ""
								: hrmEmployeeService.getEmployeeByPK(
										iservicepackage.getLastOperator())
										.getHrmEmployeeName());
				vo_list.add(iservicepackage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("查询 IServicePackage 分页列表...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	/**
	 * 查询所有 IServicePackage 列表
	 * 
	 * @param context
	 * @param request
	 * @param iServicePackage
	 * @param pager
	 */
	public ResultBean listIServicePackageAll(ServletContext context,
			HttpServletRequest request) {
		IServicePackage iServicePackage = new IServicePackage();
		List<IServicePackage> list = servicepackageService
				.listIServicePackage(iServicePackage);
		logger.info("查询所有 IServicePackage 列表...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 保存 IServicePackage
	 * 
	 * @param context
	 * @param request
	 * @param iServicePackage
	 */
	public ResultBean saveIServicePackage(ServletContext context,
			HttpServletRequest request, IServicePackage iServicePackage) {
		String empid = UtilTool.getEmployeeId(request);
		try {
			iServicePackage.initSave(empid);
			iServicePackage.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServicePackage.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServicePackage.setFirstOperator(UtilTool.getEmployeeId(request));
			iServicePackage.setFirstOperatorTime(UtilWork.getNowTime());
			iServicePackage.setLastOperator(UtilTool.getEmployeeId(request));
			iServicePackage.setLastOperatorTime(UtilWork.getNowTime());
			iServicePackage.setLastmodiId(UtilTool.getEmployeeId(request));
			iServicePackage.setLastmodiDate(UtilWork.getNowTime());
			iServicePackage.setDr("N");
			servicepackageService.saveIServicePackage(iServicePackage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("保存 IServicePackage...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新 IServicePackage
	 * 
	 * @param context
	 * @param request
	 * @param iServicePackage
	 */
	public ResultBean updateIServicePackage(ServletContext context,
			HttpServletRequest request, IServicePackage iServicePackage) {
		IServicePackage tmp = servicepackageService
				.getIServicePackageByPk(iServicePackage.getPrimaryKey());
		String empid = UtilTool.getEmployeeId(request);
		try {
			iServicePackage.initUpdate(empid);
			tmp.setServicePackageCode(iServicePackage.getServicePackageCode());
			tmp.setServicePackageName(iServicePackage.getServicePackageName());
			tmp.setServicePackageAdviceprice(iServicePackage
					.getServicePackageAdviceprice());
			tmp.setServicePackagePrice(iServicePackage.getServicePackagePrice());
			tmp.setMemo(iServicePackage.getMemo());
			tmp.initUpdate(empid);
			tmp.setLastOperator(UtilTool.getEmployeeId(request));
			tmp.setLastOperatorTime(UtilWork.getNowTime());
			servicepackageService.saveIServicePackage(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("更新 IServicePackage...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获得 IServicePackage
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 */
	public ResultBean getIServicePackageByPk(ServletContext context,
			HttpServletRequest request, String pk) {
		IServicePackage iServicePackage = servicepackageService
				.getIServicePackageByPk(pk);
		iServicePackage
				.setFirstOperator(hrmEmployeeService
						.getEmployeeByPK(iServicePackage.getFirstOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								iServicePackage.getFirstOperator())
								.getHrmEmployeeName());
		iServicePackage
				.setLastOperator(hrmEmployeeService
						.getEmployeeByPK(iServicePackage.getLastOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								iServicePackage.getLastOperator())
								.getHrmEmployeeName());
		logger.info("根据ID获得 IServicePackage...{}",
				iServicePackage.getPrimaryKey());
		return WebUtilWork.WebObjectPack(iServicePackage);
	}

	/**
	 * 删除 IServicePackage
	 * 
	 * @param context
	 * @param request
	 * @param pks
	 */
	public ResultBean deleteIServicePackageByPks(ServletContext context,
			HttpServletRequest request, String[] pks) {
		servicepackageService.deleteIServicePackageByPks(pks);
		for (String pk : pks) {
			logger.info("删除 IServicePackage...{}", pk);
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**********************************************
	 * 以上代码由CTOA代码生成工具自动生成，请根据具体需求进行修改。
	 * 开发人员在此注释以下编写业务逻辑代码，并将自己写的代码框起来，便于后期代码合并，例如：
	 **********************************************/

	/********************** JC-begin **********************/
	/**
	 * 保存方法：保存套餐以及套餐明细部分
	 * 
	 * @param context
	 * @param request
	 * @param iServicePackage
	 * @param serviceInfoids
	 * @return
	 */
	public ResultBean saveServicePackageAndDetail(ServletContext context,
			HttpServletRequest request, IServicePackage iServicePackage,
			String[] serviceInfoids) {
		String empid = UtilTool.getEmployeeId(request);
		if (null != iServicePackage.getPrimaryKey()
				&& !"".equals(iServicePackage.getPrimaryKey())) {
			IServicePackage tmp = servicepackageService
					.getIServicePackageByPk(iServicePackage.getPrimaryKey());
			tmp.initUpdate(empid);
			tmp.setServicePackageCode(iServicePackage.getServicePackageCode());;
			tmp.setServicePackageName(iServicePackage.getServicePackageName());
			tmp.setServicePackageAdviceprice(iServicePackage.getServicePackageAdviceprice());
			tmp.setServicePackagePrice(iServicePackage.getServicePackagePrice());
			tmp.setMemo(iServicePackage.getMemo());
			tmp.setLastmodiId(UtilTool.getEmployeeId(request));
			tmp.setLastmodiDate(UtilWork.getNowTime());
			servicepackageService.saveServicePackageAndDetail(tmp,
					serviceInfoids);
		} else {
			iServicePackage.initSave(empid);
			iServicePackage.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServicePackage.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iServicePackage.setFirstOperator(UtilTool.getEmployeeId(request));
			iServicePackage.setFirstOperatorTime(UtilWork.getNowTime());
			iServicePackage.setLastOperator(UtilTool.getEmployeeId(request));
			iServicePackage.setLastOperatorTime(UtilWork.getNowTime());
			iServicePackage.setLastmodiId(UtilTool.getEmployeeId(request));
			iServicePackage.setLastmodiDate(UtilWork.getNowTime());
			iServicePackage.setDr("N");
			servicepackageService.saveServicePackageAndDetail(iServicePackage,
					serviceInfoids);
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据主表主键获取明细部分
	 * @param context
	 * @param request
	 * @param iServicePackagepk
	 * @return
	 */
	public ResultBean getdetailids(ServletContext context,
			HttpServletRequest request, String iServicePackagepk) {
		List<IServiceDetail> list=servicepackageService.servicedetail(iServicePackagepk);
		Iterator<IServiceDetail> it = list.iterator();
		List<String> listpk=new ArrayList<String>();
		while (it.hasNext()) {
			IServiceDetail detail = (IServiceDetail) it.next();
			listpk.add(detail.getIserviceinfoid());
		}
		return WebUtilWork.WebResultPack(listpk);
	}
	
	public void method() {
		System.out.println("JC's code here");
	}

	/********************** JC-end **********************/

	/********************** Jacy-begin **********************/
	public void method2() {
		System.out.println("Jacy's code here");
	}
	/********************** Jacy-end **********************/

}