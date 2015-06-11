package com.iseen.archives.web.controller.dwr;

import com.iseen.archives.core.pojo.IArchivesDrugallergy;
import com.iseen.member.core.pojo.IMember;
import com.iseen.archives.core.pojo.IArchivesDisease;

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
import com.iseen.archives.core.iservice.IIarchivesstartService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrIarchivesstartService {

    private final static Logger logger = LoggerFactory.getLogger(DwrIarchivesstartService.class);

    @Resource
    private IIarchivesstartService iarchivesstartService;
    //新增部分
    @Resource
    private IHrmEmployeeService hrmEmployeeService;

    /**
     * 查询 IArchivesDrugallergy 分页列表
     * @param context
     * @param request
     * @param iArchivesDrugallergy
     * @param pager
     */
    public ResultBean listIArchivesDrugallergy(ServletContext context, HttpServletRequest request, IArchivesDrugallergy iArchivesDrugallergy, Pager pager){
        List<IArchivesDrugallergy> list = null;
        pager = PagerHelper.getPager(pager,iarchivesstartService.listIArchivesDrugallergyCount(iArchivesDrugallergy));
        list = iarchivesstartService.listIArchivesDrugallergy(iArchivesDrugallergy, pager);
        logger.info("查询 IArchivesDrugallergy 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IArchivesDrugallergy 列表
     * @param context
     * @param request
     * @param iArchivesDrugallergy
     * @param pager
     */
    public ResultBean listIArchivesDrugallergyAll(ServletContext context, HttpServletRequest request){
        IArchivesDrugallergy iArchivesDrugallergy = new IArchivesDrugallergy();
        List<IArchivesDrugallergy> list = iarchivesstartService.listIArchivesDrugallergy(iArchivesDrugallergy);
        logger.info("查询所有 IArchivesDrugallergy 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IArchivesDrugallergy
     * @param context
     * @param request
     * @param iArchivesDrugallergy
     */
    public ResultBean saveIArchivesDrugallergy(ServletContext context, HttpServletRequest request, IArchivesDrugallergy iArchivesDrugallergy){
        String empid = UtilTool.getEmployeeId(request);
        System.out.println("开始保存数据");
        
        iArchivesDrugallergy.initSave(empid);
        iArchivesDrugallergy.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        iarchivesstartService.saveIArchivesDrugallergy(iArchivesDrugallergy);
        logger.info("保存 IArchivesDrugallergy...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IArchivesDrugallergy
     * @param context
     * @param request
     * @param iArchivesDrugallergy
     */
    public ResultBean updateIArchivesDrugallergy(ServletContext context, HttpServletRequest request, IArchivesDrugallergy iArchivesDrugallergy){
        IArchivesDrugallergy tmp = iarchivesstartService.getIArchivesDrugallergyByPk(iArchivesDrugallergy.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iArchivesDrugallergy.initUpdate(empid);
        iarchivesstartService.saveIArchivesDrugallergy(iArchivesDrugallergy);
        logger.info("更新 IArchivesDrugallergy...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IArchivesDrugallergy
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIArchivesDrugallergyByPk(ServletContext context, HttpServletRequest request, String pk){
        IArchivesDrugallergy iArchivesDrugallergy = iarchivesstartService.getIArchivesDrugallergyByPk(pk);
        logger.info("根据ID获得 IArchivesDrugallergy...{}", iArchivesDrugallergy.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iArchivesDrugallergy);
    }

    /**
     * 删除 IArchivesDrugallergy
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIArchivesDrugallergyByPks(ServletContext context, HttpServletRequest request, String[] pks){
        iarchivesstartService.deleteIArchivesDrugallergyByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IArchivesDrugallergy...{}", pk);
        }
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 查询 IMember 分页列表
     * @param context
     * @param request
     * @param iMember
     * @param pager
     */
    public ResultBean listIMember(ServletContext context, HttpServletRequest request, IMember iMember, Pager pager){
        List<IMember> list = null;
        System.out.println("页面传递过来的参数为"+iMember.getMemberSex());
        pager = PagerHelper.getPager(pager,iarchivesstartService.listIMemberCount(iMember));
        list = iarchivesstartService.listIMember(iMember, pager);
        logger.info("查询 IMember 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IMember 列表
     * @param context
     * @param request
     * @param iMember
     * @param pager
     */
    public ResultBean listIMemberAll(ServletContext context, HttpServletRequest request){
        IMember iMember = new IMember();
        List<IMember> list = iarchivesstartService.listIMember(iMember);
        logger.info("查询所有 IMember 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IMember
     * @param context
     * @param request
     * @param iMember
     */
    public ResultBean saveIMember(ServletContext context, HttpServletRequest request, IMember iMember){
    	System.out.println("开始保存数据");
        String empid = UtilTool.getEmployeeId(request);
        
       // 根据登录用户的id获取用户名，并保存起来
        try {
        	  iMember.initSave(empid);
        	  iMember.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iMember.setFirstOperator(UtilTool
					.getEmployeeId(request));
			iMember.setFirstOperatorTime(UtilWork.getNowTime());
			iMember.setLastOperator(UtilTool
					.getEmployeeId(request));
			iMember.setLastOperatorTime(UtilWork.getNowTime());
			iMember.setLastmodiId(UtilTool
					.getEmployeeId(request));
			iMember.setLastmodiDate(UtilWork.getNowTime());
			iMember.setDr("N");
			 iarchivesstartService.saveIMember(iMember);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}            
        logger.info("保存 IMember...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IMember
     * @param context
     * @param request
     * @param iMember
     */
    public ResultBean updateIMember(ServletContext context, HttpServletRequest request, IMember iMember){
        IMember tmp = iarchivesstartService.getIMemberByPk(iMember.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
           
        
        
        try {
        	iMember.initUpdate(empid);
        	tmp.setMemberId(iMember.getMemberId());//更新会员id
        	tmp.setMemberName(iMember.getMemberName());//更新会员名字
        	tmp.setMemberSex(iMember.getMemberSex());//更新会员性别
        	tmp.setMemberAge(iMember.getMemberAge());//更新会员年龄
            tmp.setMemberBirthday(iMember.getMemberBirthday());//更新会员出生日期
            tmp.setMemberCountry(iMember.getMemberCountry());//更新会员国籍
            tmp.setMemberAddress(iMember.getMemberAddress());//更新住址
            tmp.setMemberBirthplace(iMember.getMemberBirthplace());//更新出生地
            tmp.setMemberIsmarry(iMember.getMemberIsmarry());//更新会员是否结婚
            tmp.setMemberIdcard(iMember.getMemberIdcard());//更新会员身份证
            tmp.setMemberJointime(iMember.getMemberJointime());//更新入会时间
            tmp.setMemberNation(iMember.getMemberNation());//更新国籍
            tmp.setMemberPhone(iMember.getMemberPhone());//更新手机号
            tmp.setBloodType(iMember.getBloodType());//更新血型
            tmp.setRh(iMember.getRh());//更新rh
            tmp.setCompanyId(iMember.getCompanyId());//更新子公司id
        	
        	tmp.initUpdate(empid);//这句话很重要
        	tmp.setLastOperator(UtilTool.getEmployeeId(request));
        	tmp.setLastOperatorTime(UtilWork.getNowTime());
        	//tmp.setLastmodiId(UtilTool.getEmployeeId(request));
        	//tmp.setLastmodiDate(UtilWork.getNowTime());
        	//tmp.setDr("N");
        	 iarchivesstartService.saveIMember(tmp);//注意此处，问题全出在此处
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}            

        logger.info("更新 IMember...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IMember
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIMemberByPk(ServletContext context, HttpServletRequest request, String pk){
        IMember iMember = iarchivesstartService.getIMemberByPk(pk);
        
        /*新增部分------根据登录用户的id查找用户的名字*/
        iMember.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iMember.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iMember.getFirstOperator())
							.getHrmEmployeeName());
        iMember.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iMember.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iMember.getLastOperator())
							.getHrmEmployeeName());
		/*新增部分----------根据会员id查找会员名字*/    
        logger.info("根据ID获得 IMember...{}", iMember.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iMember);
    }

    /**
     * 删除 IMember
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIMemberByPks(ServletContext context, HttpServletRequest request, String[] pks){
    	try {
    	iarchivesstartService.deleteIMemberByPks(pks,null);
        for (String pk : pks) {
            logger.info("删除 IMember...{}", pk);
        }
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 查询 IArchivesDisease 分页列表
     * @param context
     * @param request
     * @param iArchivesDisease
     * @param pager
     */
    public ResultBean listIArchivesDisease(ServletContext context, HttpServletRequest request, IArchivesDisease iArchivesDisease, Pager pager){
        List<IArchivesDisease> list = null;
        pager = PagerHelper.getPager(pager,iarchivesstartService.listIArchivesDiseaseCount(iArchivesDisease));
        list = iarchivesstartService.listIArchivesDisease(iArchivesDisease, pager);
        logger.info("查询 IArchivesDisease 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IArchivesDisease 列表
     * @param context
     * @param request
     * @param iArchivesDisease
     * @param pager
     */
    public ResultBean listIArchivesDiseaseAll(ServletContext context, HttpServletRequest request){
        IArchivesDisease iArchivesDisease = new IArchivesDisease();
        List<IArchivesDisease> list = iarchivesstartService.listIArchivesDisease(iArchivesDisease);
        logger.info("查询所有 IArchivesDisease 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IArchivesDisease
     * @param context
     * @param request
     * @param iArchivesDisease
     */
    public ResultBean saveIArchivesDisease(ServletContext context, HttpServletRequest request, IArchivesDisease iArchivesDisease){
        String empid = UtilTool.getEmployeeId(request);
        iArchivesDisease.initSave(empid);
        iArchivesDisease.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        iarchivesstartService.saveIArchivesDisease(iArchivesDisease);
        logger.info("保存 IArchivesDisease...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IArchivesDisease
     * @param context
     * @param request
     * @param iArchivesDisease
     */
    public ResultBean updateIArchivesDisease(ServletContext context, HttpServletRequest request, IArchivesDisease iArchivesDisease){
        IArchivesDisease tmp = iarchivesstartService.getIArchivesDiseaseByPk(iArchivesDisease.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iArchivesDisease.initUpdate(empid);
        iarchivesstartService.saveIArchivesDisease(iArchivesDisease);
        logger.info("更新 IArchivesDisease...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IArchivesDisease
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIArchivesDiseaseByPk(ServletContext context, HttpServletRequest request, String pk){
        IArchivesDisease iArchivesDisease = iarchivesstartService.getIArchivesDiseaseByPk(pk);
        logger.info("根据ID获得 IArchivesDisease...{}", iArchivesDisease.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iArchivesDisease);
    }

    /**
     * 删除 IArchivesDisease
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIArchivesDiseaseByPks(ServletContext context, HttpServletRequest request, String[] pks){
        iarchivesstartService.deleteIArchivesDiseaseByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IArchivesDisease...{}", pk);
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
/**********************JC-end**********************/

/**********************Jacy-begin**********************/
    public void method2(){
        System.out.println("Jacy's code here");
    }
/**********************Jacy-end**********************/

}