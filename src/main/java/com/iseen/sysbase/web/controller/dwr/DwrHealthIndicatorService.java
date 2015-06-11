package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IHealthIndicator;
import com.iseen.sysbase.core.pojo.IPhyItem;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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
import com.iseen.sysbase.core.iservice.IHealthIndicatorService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrHealthIndicatorService {

    private final static Logger logger = LoggerFactory.getLogger(DwrHealthIndicatorService.class);

    @Resource
    private IHealthIndicatorService healthIndicatorService;
    @Resource
	private IHrmEmployeeService hrmEmployeeService;

    /**
     * 查询 IHealthIndicator 分页列表
     * @param context
     * @param request
     * @param iHealthIndicator
     * @param pager
     */
    public ResultBean listIHealthIndicator(ServletContext context, HttpServletRequest request, IHealthIndicator iHealthIndicator, Pager pager){
        List<IHealthIndicator> list = null;
        pager = PagerHelper.getPager(pager,healthIndicatorService.listIHealthIndicatorCount(iHealthIndicator));
        list = healthIndicatorService.listIHealthIndicator(iHealthIndicator, pager);
        logger.info("查询 IHealthIndicator 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }
    
    public ResultBean getIHealthIndicatorList(ServletContext context,
			HttpServletRequest request, IHealthIndicator iHealthIndicator, Pager pager) {
		List<IHealthIndicator> list = null;
		pager = PagerHelper.getPager(pager,
				healthIndicatorService.getIHealthIndicatorListCount(iHealthIndicator));
		list = healthIndicatorService.getHealthIndicatorList(iHealthIndicator, pager);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				IHealthIndicator indicator = list.get(i);
				indicator.setFirstOperator(hrmEmployeeService.getEmployeeByPK(indicator
						.getFirstOperator()) == null ? "" : hrmEmployeeService
						.getEmployeeByPK(indicator.getFirstOperator())
						.getHrmEmployeeName());

				indicator.setLastOperator(hrmEmployeeService.getEmployeeByPK(indicator
						.getLastOperator()) == null ? "" : hrmEmployeeService
						.getEmployeeByPK(indicator.getLastOperator())
						.getHrmEmployeeName());

				list.set(i, indicator);
			}
		}

		logger.info("查询 IHealthIndicator 分页列表...");
		logger.info("DwrHealthIndicatorService.getIHealthIndicatorList list.length:"
				+ list.size());
		return WebUtilWork.WebResultPack(list, pager);
	}

    /**
     * 查询所有 IHealthIndicator 列表
     * @param context
     * @param request
     * @param iHealthIndicator
     * @param pager
     */
    public ResultBean listIHealthIndicatorAll(ServletContext context, HttpServletRequest request){
        IHealthIndicator iHealthIndicator = new IHealthIndicator();
        List<IHealthIndicator> list = healthIndicatorService.listIHealthIndicator(iHealthIndicator);
        logger.info("查询所有 IHealthIndicator 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IHealthIndicator
     * @param context
     * @param request
     * @param iHealthIndicator
     */
    public ResultBean saveIHealthIndicator(ServletContext context, HttpServletRequest request, IHealthIndicator iHealthIndicator){
        String empid = UtilTool.getEmployeeId(request);
        iHealthIndicator.initSave(empid);
        
        try {
        	iHealthIndicator.setFirstOperator(empid);
        	iHealthIndicator.setFirstOperatorTime(UtilWork.getNowTime());
        	iHealthIndicator.setLastOperator(empid);
        	iHealthIndicator.setLastOperatorTime(UtilWork.getNowTime());
        	iHealthIndicator.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        	iHealthIndicator.setDr("N");
        	System.out.println("primaryKey: "+iHealthIndicator.getPrimaryKey());
        	System.out.println("code: "+iHealthIndicator.getIndicatorCode());
        	System.out.println("name: "+iHealthIndicator.getIndicatorName());
        	System.out.println("isLeaf: "+iHealthIndicator.getIsLeaf());
        	System.out.println("dr: "+iHealthIndicator.getDr());
        	System.out.println("memo: "+iHealthIndicator.getMemo());
        	System.out.println("parentId: "+iHealthIndicator.getParentId());
        	System.out.println("gender: "+iHealthIndicator.getGender());
        	healthIndicatorService.saveIHealthIndicator(iHealthIndicator);
		} catch (Exception e) {
			e.printStackTrace();
		}
        logger.info("保存 IHealthIndicator...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IHealthIndicator
     * @param context
     * @param request
     * @param iHealthIndicator
     */
    public ResultBean updateIHealthIndicator(ServletContext context, HttpServletRequest request, IHealthIndicator iHealthIndicator){
        IHealthIndicator tmp = healthIndicatorService.getIHealthIndicatorByPk(iHealthIndicator.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iHealthIndicator.initUpdate(empid);
        try {
        	iHealthIndicator.setLastOperator(empid);
        	iHealthIndicator.setLastOperatorTime(UtilWork.getNowTime());

        	healthIndicatorService.saveIHealthIndicator(iHealthIndicator);
		} catch (Exception e) {
			e.printStackTrace();
		}
        logger.info("更新 IHealthIndicator...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IHealthIndicator
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIHealthIndicatorByPk(ServletContext context, HttpServletRequest request, String pk){
        IHealthIndicator iHealthIndicator = healthIndicatorService.getIHealthIndicatorByPk(pk);
        if (iHealthIndicator != null) {

        	iHealthIndicator.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iHealthIndicator.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iHealthIndicator.getFirstOperator()).getHrmEmployeeName());

        	iHealthIndicator.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iHealthIndicator.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iHealthIndicator.getLastOperator()).getHrmEmployeeName());

			logger.info("根据ID获得 IHealthIndicator...{}", iHealthIndicator.getPrimaryKey());
		}
        logger.info("根据ID获得 IHealthIndicator...{}", iHealthIndicator.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iHealthIndicator);
    }

    /**
     * 删除 IHealthIndicator
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIHealthIndicatorByPks(ServletContext context, HttpServletRequest request, String[] pks){
    	String empid = UtilTool.getEmployeeId(request);
        healthIndicatorService.deleteIHealthIndicatorByPks(pks, empid);
        for (String pk : pks) {
            logger.info("删除 IHealthIndicator...{}", pk);
        }
        return WebUtilWork.WebResultPack(null);
    }
    
    public List<IHealthIndicator> getIHealthIndicatorByUpCode(String code) {
		List<IHealthIndicator> itemList = null;
		IHealthIndicator tmp = healthIndicatorService.getIHealthIndicatorByPk(code);
		if (tmp != null && tmp.getIsLeaf().equals('1')) {
			itemList = new ArrayList<IHealthIndicator>();
		} else {
			itemList = healthIndicatorService.getIHealthIndicatorListByUpCode(code);
		}
		logger.info("DwrHealthIndicatorService.getIHealthIndicatorByUpCode itemList length:"
				+ itemList.size());
		return itemList;
	}
    
    public int getIHealthIndicatorByUpCodeCount(String code) {
		int count = 0;
		IHealthIndicator tmp = healthIndicatorService.getIHealthIndicatorByPk(code);
		if (tmp != null && tmp.getIsLeaf().equals('1')) {
			return count;
		}
		logger.info("DwrPhyItemService.getIPhyItemByUpCodeCount count:" + count);
		return healthIndicatorService.getHealthIndicatorListByUpCodeCount(code);
	}
    
    public ResultBean updateHealthIndicator(ServletContext context,
			HttpServletRequest request, IHealthIndicator healthIndicator) {
		if (StringUtils.isBlank(healthIndicator.getParentId())) {
			healthIndicator.setParentId("-1");
		}

		IHealthIndicator item = healthIndicatorService.getIHealthIndicatorByPk(healthIndicator.getPrimaryKey());
		int count = healthIndicatorService.getHealthIndicatorByNameAndParentId(
				healthIndicator.getIndicatorName(), healthIndicator.getParentId(),
				healthIndicator.getPrimaryKey());
		if (count > 0) {
			return new ResultBean(false, "同一级别下，指标目录名称不能重名！");
		}

		if (!healthIndicator.getParentId().equals(item.getParentId())) {// 上级编码有变动
			boolean bl = false;
			// 判断上级目录是否为自己和自己的下级目录
			List<IHealthIndicator> list = healthIndicatorService.getHealthIndicatorListByPK(item
					.getPrimaryKey());
			for (IHealthIndicator hi : list) {
				if (hi.getPrimaryKey().equals(healthIndicator.getParentId())) {
					bl = true;
					break;
				}
			}
			if (bl) {
				return new ResultBean(false, "上级目录不能为自己!");
			}
		}
		// eric.jin modify
		String empid = UtilTool.getEmployeeId(request);
		healthIndicator.initUpdate(empid);
		healthIndicator.setLastOperator(empid);
		healthIndicator.setLastOperatorTime(UtilWork.getNowTime());
		if(item!=null){
			healthIndicator.setFirstOperator(item.getFirstOperator());
			healthIndicator.setFirstOperatorTime(item.getFirstOperatorTime());
			healthIndicator.setDr(item.getDr());
		}

		healthIndicatorService.saveIHealthIndicator(healthIndicator);

		logger.info("更新指标目录信息...");
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