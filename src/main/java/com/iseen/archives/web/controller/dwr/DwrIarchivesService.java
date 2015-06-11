package com.iseen.archives.web.controller.dwr;

import com.iseen.archives.core.pojo.IArchives;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.centling.common.module.ResultBean;
import com.centling.common.pages.Pager;
import com.centling.common.pages.PagerHelper;
import com.centling.common.util.UtilTool;
import com.centling.common.util.UtilPrimaryKey;
import com.centling.common.util.UtilWork;
import com.centling.common.util.WebUtilWork;
import com.centling.core.iservice.IHrmEmployeeService;
import com.iseen.archives.core.iservice.IIarchivesService;

/**********************************************
 * Class name: Description: Others: History:
 **********************************************/
@Controller
public class DwrIarchivesService {

	private final static Logger logger = LoggerFactory
			.getLogger(DwrIarchivesService.class);

	@Resource
	private IIarchivesService iarchivesService;
	//新增部分
	@Resource
    private IHrmEmployeeService hrmEmployeeService;

	/**
	 * 查询 IArchives 分页列表
	 * 
	 * @param context
	 * @param request
	 * @param iArchives
	 * @param pager
	 */
	public ResultBean listIArchives(ServletContext context,
			HttpServletRequest request, IArchives iArchives, Pager pager) {
		List<IArchives> list = null;
		pager = PagerHelper.getPager(pager,
				iarchivesService.listIArchivesCount(iArchives));
		list = iarchivesService.listIArchives(iArchives, pager);
		logger.info("查询 IArchives 分页列表...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	/**
	 * 查询所有 IArchives 列表
	 * 
	 * @param context
	 * @param request
	 * @param iArchives
	 * @param pager
	 */
	public ResultBean listIArchivesAll(ServletContext context,
			HttpServletRequest request) {
		IArchives iArchives = new IArchives();
		List<IArchives> list = iarchivesService.listIArchives(iArchives);
		logger.info("查询所有 IArchives 列表...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 保存 IArchives
	 * 
	 * @param context
	 * @param request
	 * @param iArchives
	 */
	public ResultBean saveIArchives(ServletContext context,
			HttpServletRequest request, IArchives iArchives, String attach[]) {
		// 保存附件
		System.out.println("开始保存会员档案附件");
		String ids = UtilTool.saveAttachments(context, request, attach[0]);
		iArchives.setIndicatorUpload(ids);
		String ids1 = UtilTool.saveAttachments(context, request, attach[1]);
		iArchives.setImageUpload(ids1);
		String ids2 = UtilTool.saveAttachments(context, request, attach[2]);
		iArchives.setAllUpload(ids2);

		String empid = UtilTool.getEmployeeId(request);

		try {
			iArchives.initSave(empid);
			iArchives.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iArchives.setFirstOperator(UtilTool.getEmployeeId(request));
			iArchives.setFirstOperatorTime(UtilWork.getNowTime());
			iArchives.setLastOperator(UtilTool.getEmployeeId(request));
			iArchives.setLastOperatorTime(UtilWork.getNowTime());
			iArchives.setLastmodiId(UtilTool.getEmployeeId(request));
			iArchives.setLastmodiDate(UtilWork.getNowTime());
			iArchives.setDr("N");
			iarchivesService.saveIArchives(iArchives);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		logger.info("保存 IArchives...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新 IArchives
	 * 
	 * @param context
	 * @param request
	 * @param iArchives
	 */
	public ResultBean updateIArchives(ServletContext context,
			HttpServletRequest request, IArchives iArchives, String attach[]) {
		IArchives tmp = iarchivesService.getIArchivesByPk(iArchives
				.getPrimaryKey());
		// 删除原附件
		UtilTool.deleteAttachmentsNoFile(context, request,
				tmp.getIndicatorUpload());
		// 保存附件
		String ids = UtilTool.saveAttachments(context, request, attach[0]);
		iArchives.setIndicatorUpload(ids);
		String ids1 = UtilTool.saveAttachments(context, request, attach[1]);
		iArchives.setImageUpload(ids1);
		String ids2 = UtilTool.saveAttachments(context, request, attach[2]);
		iArchives.setAllUpload(ids2);

		String empid = UtilTool.getEmployeeId(request);
		
		try {
			tmp.setMemo(iArchives.getMemo());
			tmp.initUpdate(empid);
			tmp.setLastOperator(UtilTool.getEmployeeId(request));
			tmp.setLastOperatorTime(UtilWork.getNowTime());
			iarchivesService.saveIArchives(iArchives);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("更新 IArchives...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获得 IArchives
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 */
	public ResultBean getIArchivesByPk(ServletContext context,
			HttpServletRequest request, String pk) {
		IArchives iArchives = iarchivesService.getIArchivesByPk(pk);
		
		/*新增部分------根据登录用户的id查找用户的名字*/
		iArchives.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iArchives.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iArchives.getFirstOperator())
							.getHrmEmployeeName());
		iArchives.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iArchives.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iArchives.getLastOperator())
							.getHrmEmployeeName());
		/*新增部分----------根据会员id查找会员名字*/    
		logger.info("根据ID获得 IArchives...{}", iArchives.getPrimaryKey());
		return WebUtilWork.WebObjectPack(iArchives);
	}

	/**
	 * 删除 IArchives
	 * 
	 * @param context
	 * @param request
	 * @param pks
	 */
	public ResultBean deleteIArchivesByPks(ServletContext context,
			HttpServletRequest request, String[] pks) {
		try {
		iarchivesService.deleteIArchivesByPks(pks,null);
		for (String pk : pks) {
			logger.info("删除 IArchives...{}", pk);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return WebUtilWork.WebResultPack(null);
	}

	/**********************************************
	 * 以上代码由CTOA代码生成工具自动生成，请根据具体需求进行修改。
	 * 开发人员在此注释以下编写业务逻辑代码，并将自己写的代码框起来，便于后期代码合并，例如：
	 **********************************************/

	/********************** JC-begin **********************/
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