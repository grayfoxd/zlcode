package com.iseen.member.web.controller.dwr;

import com.iseen.member.core.pojo.IMemberAppointment;

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
import com.iseen.member.core.iservice.IImemberappointmentService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrImemberappointmentService {

    private final static Logger logger = LoggerFactory.getLogger(DwrImemberappointmentService.class);

    @Resource
    private IImemberappointmentService imemberappointmentService;

    /**
     * 查询 IMemberAppointment 分页列表
     * @param context
     * @param request
     * @param iMemberAppointment
     * @param pager
     */
    public ResultBean listIMemberAppointment(ServletContext context, HttpServletRequest request, IMemberAppointment iMemberAppointment, Pager pager){
        List<IMemberAppointment> list = null;
        pager = PagerHelper.getPager(pager,imemberappointmentService.listIMemberAppointmentCount(iMemberAppointment));
        list = imemberappointmentService.listIMemberAppointment(iMemberAppointment, pager);
        logger.info("查询 IMemberAppointment 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IMemberAppointment 列表
     * @param context
     * @param request
     * @param iMemberAppointment
     * @param pager
     */
    public ResultBean listIMemberAppointmentAll(ServletContext context, HttpServletRequest request){
        IMemberAppointment iMemberAppointment = new IMemberAppointment();
        List<IMemberAppointment> list = imemberappointmentService.listIMemberAppointment(iMemberAppointment);
        logger.info("查询所有 IMemberAppointment 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IMemberAppointment
     * @param context
     * @param request
     * @param iMemberAppointment
     */
    public ResultBean saveIMemberAppointment(ServletContext context, HttpServletRequest request, IMemberAppointment iMemberAppointment){
        String empid = UtilTool.getEmployeeId(request);
        
        try {
        	iMemberAppointment.initSave(empid);
        	iMemberAppointment.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        	iMemberAppointment.setFirstOperator(UtilTool
  					.getEmployeeId(request));
        	iMemberAppointment.setFirstOperatorTime(UtilWork.getNowTime());
        	iMemberAppointment.setLastOperator(UtilTool
  					.getEmployeeId(request));
        	iMemberAppointment.setLastOperatorTime(UtilWork.getNowTime());
        	iMemberAppointment.setLastmodiId(UtilTool
  					.getEmployeeId(request));
        	iMemberAppointment.setLastmodiDate(UtilWork.getNowTime());
        	iMemberAppointment.setDr("N");
        	 imemberappointmentService.saveIMemberAppointment(iMemberAppointment);
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}     
       
        
        logger.info("保存 IMemberAppointment...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IMemberAppointment
     * @param context
     * @param request
     * @param iMemberAppointment
     */
    public ResultBean updateIMemberAppointment(ServletContext context, HttpServletRequest request, IMemberAppointment iMemberAppointment){
        IMemberAppointment tmp = imemberappointmentService.getIMemberAppointmentByPk(iMemberAppointment.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        
        try {
        	  iMemberAppointment.initUpdate(empid);
              tmp.setMemberId(iMemberAppointment.getMemberId());//更新会员id
       	      tmp.setMemberName(iMemberAppointment.getMemberName());//更新会员名字
       	      tmp.setAppointmentType(iMemberAppointment.getAppointmentType());//更新预约类型
       	      tmp.setAppointmentContent(iMemberAppointment.getAppointmentContent());//更新预约详情
       	      tmp.setExpectedTime(iMemberAppointment.getExpectedTime());//更新预约时间
       	      tmp.setEndTime(iMemberAppointment.getEndTime());//更新预约终结时间
       	      tmp.setProcessInstanceId(iMemberAppointment.getProcessInstanceId());//更新流程id             
              tmp.setMemo(iMemberAppointment.getMemo());//更新备注
       	
        	  tmp.initUpdate(empid);//这句话很重要
        	  tmp.setLastOperator(UtilTool.getEmployeeId(request));
       	      tmp.setLastOperatorTime(UtilWork.getNowTime());      
        imemberappointmentService.saveIMemberAppointment(iMemberAppointment);
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}            
        

        
        
        logger.info("更新 IMemberAppointment...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IMemberAppointment
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIMemberAppointmentByPk(ServletContext context, HttpServletRequest request, String pk){
        IMemberAppointment iMemberAppointment = imemberappointmentService.getIMemberAppointmentByPk(pk);
        logger.info("根据ID获得 IMemberAppointment...{}", iMemberAppointment.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iMemberAppointment);
    }

    /**
     * 删除 IMemberAppointment
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIMemberAppointmentByPks(ServletContext context, HttpServletRequest request, String[] pks){
        imemberappointmentService.deleteIMemberAppointmentByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IMemberAppointment...{}", pk);
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