package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IDiseaseLevel;
import com.iseen.sysbase.core.pojo.IPhyItem;

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
import com.iseen.sysbase.core.iservice.IDiseaseLevelService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrDiseaseLevelService {

    private final static Logger logger = LoggerFactory.getLogger(DwrDiseaseLevelService.class);

    @Resource
    private IDiseaseLevelService diseaseLevelService;
    @Resource
	private IHrmEmployeeService hrmEmployeeService;

    /**
     * 查询 IDiseaseLevel 分页列表
     * @param context
     * @param request
     * @param iDiseaseLevel
     * @param pager
     */
    public ResultBean listIDiseaseLevel(ServletContext context, HttpServletRequest request, IDiseaseLevel iDiseaseLevel, Pager pager){
        List<IDiseaseLevel> list = null;
        pager = PagerHelper.getPager(pager,diseaseLevelService.listIDiseaseLevelCount(iDiseaseLevel));
        list = diseaseLevelService.listIDiseaseLevel(iDiseaseLevel, pager);
        logger.info("查询 IDiseaseLevel 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }
    
    public ResultBean getIDiseaseLevelList(ServletContext context,
			HttpServletRequest request, IDiseaseLevel iDiseaseLevel, Pager pager) {
		List<IDiseaseLevel> list = null;
		pager = PagerHelper.getPager(pager,
				diseaseLevelService.getIDiseaseLevelListCount(iDiseaseLevel));
		list = diseaseLevelService.getDiseaseLevelList(iDiseaseLevel, pager);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				IDiseaseLevel item = list.get(i);
				item.setFirstOperator(hrmEmployeeService.getEmployeeByPK(item
						.getFirstOperator()) == null ? "" : hrmEmployeeService
						.getEmployeeByPK(item.getFirstOperator())
						.getHrmEmployeeName());

				item.setLastOperator(hrmEmployeeService.getEmployeeByPK(item
						.getLastOperator()) == null ? "" : hrmEmployeeService
						.getEmployeeByPK(item.getLastOperator())
						.getHrmEmployeeName());

				list.set(i, item);
			}
		}

		logger.info("查询 IPhyItem 分页列表...");
		logger.info("DwrPhyItemService.getIPhyItemList list.length:"
				+ list.size());
		return WebUtilWork.WebResultPack(list, pager);
	}

    /**
     * 查询所有 IDiseaseLevel 列表
     * @param context
     * @param request
     * @param iDiseaseLevel
     * @param pager
     */
    public ResultBean listIDiseaseLevelAll(ServletContext context, HttpServletRequest request){
        IDiseaseLevel iDiseaseLevel = new IDiseaseLevel();
        List<IDiseaseLevel> list = diseaseLevelService.listIDiseaseLevel(iDiseaseLevel);
        logger.info("查询所有 IDiseaseLevel 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IDiseaseLevel
     * @param context
     * @param request
     * @param iDiseaseLevel
     */
    public ResultBean saveIDiseaseLevel(ServletContext context, HttpServletRequest request, IDiseaseLevel iDiseaseLevel){
        String empid = UtilTool.getEmployeeId(request);
        iDiseaseLevel.initSave(empid);
        
        try {
			// eric.jin modify
        	iDiseaseLevel.setFirstOperator(empid);
			iDiseaseLevel.setFirstOperatorTime(UtilWork.getNowTime());
			iDiseaseLevel.setLastOperator(empid);
			iDiseaseLevel.setLastOperatorTime(UtilWork.getNowTime());
			iDiseaseLevel.setDr("N");
			iDiseaseLevel.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
	        diseaseLevelService.saveIDiseaseLevel(iDiseaseLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        logger.info("保存 IDiseaseLevel...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IDiseaseLevel
     * @param context
     * @param request
     * @param iDiseaseLevel
     */
    public ResultBean updateIDiseaseLevel(ServletContext context, HttpServletRequest request, IDiseaseLevel iDiseaseLevel){
        IDiseaseLevel tmp = diseaseLevelService.getIDiseaseLevelByPk(iDiseaseLevel.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iDiseaseLevel.initUpdate(empid);
        diseaseLevelService.saveIDiseaseLevel(iDiseaseLevel);
        logger.info("更新 IDiseaseLevel...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IDiseaseLevel
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIDiseaseLevelByPk(ServletContext context, HttpServletRequest request, String pk){
        IDiseaseLevel iDiseaseLevel = diseaseLevelService.getIDiseaseLevelByPk(pk);
        if (iDiseaseLevel != null) {

        	iDiseaseLevel.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iDiseaseLevel.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iDiseaseLevel.getFirstOperator()).getHrmEmployeeName());

        	iDiseaseLevel.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iDiseaseLevel.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iDiseaseLevel.getLastOperator()).getHrmEmployeeName());

			logger.info("根据ID获得 iDiseaseLevel...{}", iDiseaseLevel.getPrimaryKey());
		}
        return WebUtilWork.WebObjectPack(iDiseaseLevel);
    }

    /**
     * 删除 IDiseaseLevel
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIDiseaseLevelByPks(ServletContext context, HttpServletRequest request, String[] pks){
    	String empid = UtilTool.getEmployeeId(request);
        diseaseLevelService.deleteIDiseaseLevelByPks(pks, empid);
        for (String pk : pks) {
            logger.info("删除 IDiseaseLevel...{}", pk);
        }
        return WebUtilWork.WebResultPack(null);
    }
    
    public ResultBean updateDiseaseLevel(ServletContext context,
			HttpServletRequest request, IDiseaseLevel diseaseLevel) {

    	IDiseaseLevel item = diseaseLevelService.getIDiseaseLevelByPk(diseaseLevel.getPrimaryKey());

		String empid = UtilTool.getEmployeeId(request);
		diseaseLevel.initUpdate(empid);
		diseaseLevel.setLastOperator(empid);
		diseaseLevel.setLastOperatorTime(UtilWork.getNowTime());
		if(item!=null){
			diseaseLevel.setFirstOperator(item.getFirstOperator());
			diseaseLevel.setFirstOperatorTime(item.getFirstOperatorTime());
			diseaseLevel.setDr(item.getDr());
		}
		
		diseaseLevelService.saveIDiseaseLevel(diseaseLevel);

		logger.info("更新项目目录信息...");
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