package com.iseen.member.web.controller.dwr;

import com.iseen.member.core.pojo.IMemberConsumption;

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
import com.iseen.member.core.iservice.IImemberconsumptionService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrImemberconsumptionService {

    private final static Logger logger = LoggerFactory.getLogger(DwrImemberconsumptionService.class);

    @Resource
    private IImemberconsumptionService imemberconsumptionService;

    /**
     * 查询 IMemberConsumption 分页列表
     * @param context
     * @param request
     * @param iMemberConsumption
     * @param pager
     */
    public ResultBean listIMemberConsumption(ServletContext context, HttpServletRequest request, IMemberConsumption iMemberConsumption, Pager pager){
        List<IMemberConsumption> list = null;
        pager = PagerHelper.getPager(pager,imemberconsumptionService.listIMemberConsumptionCount(iMemberConsumption));
        list = imemberconsumptionService.listIMemberConsumption(iMemberConsumption, pager);
        logger.info("查询 IMemberConsumption 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IMemberConsumption 列表
     * @param context
     * @param request
     * @param iMemberConsumption
     * @param pager
     */
    public ResultBean listIMemberConsumptionAll(ServletContext context, HttpServletRequest request){
        IMemberConsumption iMemberConsumption = new IMemberConsumption();
        List<IMemberConsumption> list = imemberconsumptionService.listIMemberConsumption(iMemberConsumption);
        logger.info("查询所有 IMemberConsumption 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IMemberConsumption
     * @param context
     * @param request
     * @param iMemberConsumption
     */
    public ResultBean saveIMemberConsumption(ServletContext context, HttpServletRequest request, IMemberConsumption iMemberConsumption){
    	System.out.println("开始保存会员消费数据");
        String empid = UtilTool.getEmployeeId(request);
        
        try {
        	iMemberConsumption.initSave(empid);
        	iMemberConsumption.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        	iMemberConsumption.setFirstOperator(UtilTool
  					.getEmployeeId(request));
        	iMemberConsumption.setFirstOperatorTime(UtilWork.getNowTime());
        	iMemberConsumption.setLastOperator(UtilTool
  					.getEmployeeId(request));
        	iMemberConsumption.setLastOperatorTime(UtilWork.getNowTime());
        	iMemberConsumption.setLastmodiId(UtilTool
  					.getEmployeeId(request));
        	iMemberConsumption.setLastmodiDate(UtilWork.getNowTime());
        	iMemberConsumption.setDr("N");
        	 imemberconsumptionService.saveIMemberConsumption(iMemberConsumption);
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}     
         
        logger.info("保存 IMemberConsumption...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IMemberConsumption
     * @param context
     * @param request
     * @param iMemberConsumption
     */
    public ResultBean updateIMemberConsumption(ServletContext context, HttpServletRequest request, IMemberConsumption iMemberConsumption){
        IMemberConsumption tmp = imemberconsumptionService.getIMemberConsumptionByPk(iMemberConsumption.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        
        try {
        	 iMemberConsumption.initUpdate(empid);
        	tmp.setMemberId(iMemberConsumption.getMemberId());//更新会员id
        	tmp.setMemberName(iMemberConsumption.getMemberName());//更新会员名字
            tmp.setConsumptionContent(iMemberConsumption.getConsumptionContent());//更新消费明细
            tmp.setConsumptionTime(iMemberConsumption.getConsumptionTime());//更新消费时间
            
        	
        	tmp.initUpdate(empid);//这句话很重要
        	tmp.setLastOperator(UtilTool.getEmployeeId(request));
        	tmp.setLastOperatorTime(UtilWork.getNowTime());      
        	 imemberconsumptionService.saveIMemberConsumption(iMemberConsumption);
  		} catch (Exception e) {
  			// TODO: handle exception
  			e.printStackTrace();
  		}            
        
        

  
        
        logger.info("更新 IMemberConsumption...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IMemberConsumption
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIMemberConsumptionByPk(ServletContext context, HttpServletRequest request, String pk){
        IMemberConsumption iMemberConsumption = imemberconsumptionService.getIMemberConsumptionByPk(pk);
        logger.info("根据ID获得 IMemberConsumption...{}", iMemberConsumption.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iMemberConsumption);
    }

    /**
     * 删除 IMemberConsumption
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIMemberConsumptionByPks(ServletContext context, HttpServletRequest request, String[] pks){
        imemberconsumptionService.deleteIMemberConsumptionByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IMemberConsumption...{}", pk);
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