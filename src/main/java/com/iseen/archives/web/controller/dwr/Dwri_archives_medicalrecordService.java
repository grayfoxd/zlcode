package com.iseen.archives.web.controller.dwr;

import com.iseen.archives.core.pojo.IArchivesMedicalrecord;
import com.iseen.member.core.pojo.IMember;

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
import com.iseen.archives.core.iservice.Ii_archives_medicalrecordService;

/**********************************************
 * Class name: Description: Others: History:
 **********************************************/
@Controller
public class Dwri_archives_medicalrecordService {

	private final static Logger logger = LoggerFactory
			.getLogger(Dwri_archives_medicalrecordService.class);

	@Resource
	private Ii_archives_medicalrecordService i_archives_medicalrecordService;
	
	@Resource
    private IHrmEmployeeService hrmEmployeeService;

	/**
	 * 查询 IArchivesMedicalrecord 分页列表
	 * 
	 * @param context
	 * @param request
	 * @param iArchivesMedicalrecord
	 * @param pager
	 */
	public ResultBean listIArchivesMedicalrecord(ServletContext context,
			HttpServletRequest request,
			IArchivesMedicalrecord iArchivesMedicalrecord, Pager pager) {
		List<IArchivesMedicalrecord> list = null;
		pager = PagerHelper.getPager(pager, i_archives_medicalrecordService
				.listIArchivesMedicalrecordCount(iArchivesMedicalrecord));
		list = i_archives_medicalrecordService.listIArchivesMedicalrecord(
				iArchivesMedicalrecord, pager);
		logger.info("查询 IArchivesMedicalrecord 分页列表...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	/**
	 * 查询所有 IArchivesMedicalrecord 列表
	 * 
	 * @param context
	 * @param request
	 * @param iArchivesMedicalrecord
	 * @param pager
	 */
	public ResultBean listIArchivesMedicalrecordAll(ServletContext context,
			HttpServletRequest request) {
		IArchivesMedicalrecord iArchivesMedicalrecord = new IArchivesMedicalrecord();
		List<IArchivesMedicalrecord> list = i_archives_medicalrecordService
				.listIArchivesMedicalrecord(iArchivesMedicalrecord);
		logger.info("查询所有 IArchivesMedicalrecord 列表...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 保存 IArchivesMedicalrecord
	 * 
	 * @param context
	 * @param request
	 * @param iArchivesMedicalrecord
	 */
	public ResultBean saveIArchivesMedicalrecord(ServletContext context,
			HttpServletRequest request,
			IArchivesMedicalrecord iArchivesMedicalrecord, String attach) {

		// 保存附件
		String ids = UtilTool.saveAttachments(context, request, attach);
		iArchivesMedicalrecord.setFileUploadaddress(ids);
		// 修改部分

		String empid = UtilTool.getEmployeeId(request);

		try {
			iArchivesMedicalrecord.initSave(empid);
			iArchivesMedicalrecord
					.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iArchivesMedicalrecord.setFirstOperator(UtilTool
					.getEmployeeId(request));
			iArchivesMedicalrecord.setFirstOperatorTime(UtilWork.getNowTime());
			iArchivesMedicalrecord.setLastOperator(UtilTool
					.getEmployeeId(request));
			iArchivesMedicalrecord.setLastOperatorTime(UtilWork.getNowTime());
			iArchivesMedicalrecord.setLastmodiId(UtilTool
					.getEmployeeId(request));
			iArchivesMedicalrecord.setLastmodiDate(UtilWork.getNowTime());
			iArchivesMedicalrecord.setDr("N");
			i_archives_medicalrecordService
					.saveIArchivesMedicalrecord(iArchivesMedicalrecord);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		logger.info("保存 IArchivesMedicalrecord...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新 IArchivesMedicalrecord
	 * 
	 * @param context
	 * @param request
	 * @param iArchivesMedicalrecord
	 */
	public ResultBean updateIArchivesMedicalrecord(ServletContext context,
			HttpServletRequest request,
			IArchivesMedicalrecord iArchivesMedicalrecord, String attach) {
		IArchivesMedicalrecord tmp = i_archives_medicalrecordService
				.getIArchivesMedicalrecordByPk(iArchivesMedicalrecord
						.getPrimaryKey());
		// 删除原附件
		UtilTool.deleteAttachmentsNoFile(context, request,
				tmp.getFileUploadaddress());
		// 保存附件
		String ids = UtilTool.saveAttachments(context, request, attach);

		String empid = UtilTool.getEmployeeId(request);

		try {

			tmp.setMemo(iArchivesMedicalrecord.getMemo());
			tmp.initUpdate(empid);
			tmp.setLastOperator(UtilTool.getEmployeeId(request));
			tmp.setLastOperatorTime(UtilWork.getNowTime());
			i_archives_medicalrecordService
					.saveIArchivesMedicalrecord(iArchivesMedicalrecord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// iArchivesMedicalrecord.initUpdate(empid);

		logger.info("更新 IArchivesMedicalrecord...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获得 IArchivesMedicalrecord
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 */
	public ResultBean getIArchivesMedicalrecordByPk(ServletContext context,
			HttpServletRequest request, String pk) {
		IArchivesMedicalrecord iArchivesMedicalrecord = i_archives_medicalrecordService
				.getIArchivesMedicalrecordByPk(pk);
		/*新增部分------根据登录用户的id查找用户的名字*/
		iArchivesMedicalrecord.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iArchivesMedicalrecord.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iArchivesMedicalrecord.getFirstOperator())
							.getHrmEmployeeName());
		iArchivesMedicalrecord.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iArchivesMedicalrecord.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iArchivesMedicalrecord.getLastOperator())
							.getHrmEmployeeName());
		/*新增部分----------根据会员id查找会员名字*/    
		logger.info("根据ID获得 IArchivesMedicalrecord...{}",
				iArchivesMedicalrecord.getPrimaryKey());
		return WebUtilWork.WebObjectPack(iArchivesMedicalrecord);
	}

	/**
	 * 删除 IArchivesMedicalrecord
	 * 
	 * @param context
	 * @param request
	 * @param pks
	 */
	public ResultBean deleteIArchivesMedicalrecordByPks(ServletContext context,
			HttpServletRequest request, String[] pks) {
		try {
			i_archives_medicalrecordService
					.deleteIArchivesMedicalrecordByPks(pks,null);
			for (String pk : pks) {
				logger.info("删除 IArchivesMedicalrecord...{}", pk);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 查询 IMember 分页列表
	 * 
	 * @param context
	 * @param request
	 * @param iMember
	 * @param pager
	 */
	public ResultBean listIMember(ServletContext context,
			HttpServletRequest request, IMember iMember, Pager pager) {
		List<IMember> list = null;
		pager = PagerHelper.getPager(pager,
				i_archives_medicalrecordService.listIMemberCount(iMember));
		list = i_archives_medicalrecordService.listIMember(iMember, pager);
		logger.info("查询 IMember 分页列表...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	/**
	 * 查询所有 IMember 列表
	 * 
	 * @param context
	 * @param request
	 * @param iMember
	 * @param pager
	 */
	public ResultBean listIMemberAll(ServletContext context,
			HttpServletRequest request) {
		IMember iMember = new IMember();
		List<IMember> list = i_archives_medicalrecordService
				.listIMember(iMember);
		logger.info("查询所有 IMember 列表...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 保存 IMember
	 * 
	 * @param context
	 * @param request
	 * @param iMember
	 */
	public ResultBean saveIMember(ServletContext context,
			HttpServletRequest request, IMember iMember) {
		String empid = UtilTool.getEmployeeId(request);
		iMember.initSave(empid);
		iMember.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
		i_archives_medicalrecordService.saveIMember(iMember);
		logger.info("保存 IMember...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新 IMember
	 * 
	 * @param context
	 * @param request
	 * @param iMember
	 */
	public ResultBean updateIMember(ServletContext context,
			HttpServletRequest request, IMember iMember) {
		IMember tmp = i_archives_medicalrecordService.getIMemberByPk(iMember
				.getPrimaryKey());
		String empid = UtilTool.getEmployeeId(request);
		iMember.initUpdate(empid);
		i_archives_medicalrecordService.saveIMember(iMember);
		logger.info("更新 IMember...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获得 IMember
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 */
	public ResultBean getIMemberByPk(ServletContext context,
			HttpServletRequest request, String pk) {
		IMember iMember = i_archives_medicalrecordService.getIMemberByPk(pk);
		logger.info("根据ID获得 IMember...{}", iMember.getPrimaryKey());
		return WebUtilWork.WebObjectPack(iMember);
	}

	/**
	 * 删除 IMember
	 * 
	 * @param context
	 * @param request
	 * @param pks
	 */
	public ResultBean deleteIMemberByPks(ServletContext context,
			HttpServletRequest request, String[] pks) {
		i_archives_medicalrecordService.deleteIMemberByPks(pks);
		for (String pk : pks) {
			logger.info("删除 IMember...{}", pk);
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