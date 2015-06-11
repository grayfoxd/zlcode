package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IPhyItem;
import com.iseen.sysbase.core.pojo.IPhyPackage;
import com.iseen.sysbase.core.pojo.IPhyPackageDetail;

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
import com.iseen.sysbase.core.iservice.IPhyItemService;
import com.iseen.sysbase.core.iservice.IPhyPackageDetailService;
import com.iseen.sysbase.core.iservice.IPhyPackageService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrPhyPackageService {

    private final static Logger logger = LoggerFactory.getLogger(DwrPhyPackageService.class);

    @Resource
    private IPhyPackageService phyPackageService;
    @Resource
	private IHrmEmployeeService hrmEmployeeService;
    @Resource
    private IPhyPackageDetailService phyPackageDetailService;
    @Resource
	private IPhyItemService phyItemService;

    /**
     * 查询 IPhyPackage 分页列表
     * @param context
     * @param request
     * @param iPhyPackage
     * @param pager
     */
    public ResultBean listIPhyPackage(ServletContext context, HttpServletRequest request, IPhyPackage iPhyPackage, Pager pager){
        List<IPhyPackage> list = null;
        pager = PagerHelper.getPager(pager,phyPackageService.listIPhyPackageCount(iPhyPackage));
        list = phyPackageService.listIPhyPackage(iPhyPackage, pager);
        logger.info("查询 IPhyPackage 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IPhyPackage 列表
     * @param context
     * @param request
     * @param iPhyPackage
     * @param pager
     */
    public ResultBean listIPhyPackageAll(ServletContext context, HttpServletRequest request){
        IPhyPackage iPhyPackage = new IPhyPackage();
        List<IPhyPackage> list = phyPackageService.listIPhyPackage(iPhyPackage);
        logger.info("查询所有 IPhyPackage 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IPhyPackage
     * @param context
     * @param request
     * @param iPhyPackage
     */
    public ResultBean saveIPhyPackage(ServletContext context, HttpServletRequest request, IPhyPackage iPhyPackage, String phyItemIds){
        String empid = UtilTool.getEmployeeId(request);
        String primaryKey = UtilPrimaryKey.getPrimaryKey();
        iPhyPackage.initSave(empid);
        try {
        	iPhyPackage.setFirstOperator(empid);
        	iPhyPackage.setFirstOperatorTime(UtilWork.getNowTime());
        	iPhyPackage.setLastOperator(empid);
        	iPhyPackage.setLastOperatorTime(UtilWork.getNowTime());
        	iPhyPackage.setDr("N");
        	iPhyPackage.setPrimaryKey(primaryKey);
            phyPackageService.saveIPhyPackage(iPhyPackage);
            
            String[] itemIds = phyItemIds.split(",");
            for(int i=0; i<itemIds.length; i++){
            	IPhyItem item = phyItemService.getIPhyItemByPk(itemIds[i]);
            	if(item!=null && item.getIsLeaf().equals("1")){
            		IPhyPackageDetail packageDetail = new IPhyPackageDetail();
                	packageDetail.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
                	packageDetail.setPhyItemId(itemIds[i]);
                	packageDetail.setPhyPackageId(primaryKey);
                	packageDetail.setFirstOperator(empid);
                	packageDetail.setFirstOperatorTime(UtilWork.getNowTime());
                	packageDetail.setLastOperator(empid);
                	packageDetail.setLastmodiDate(UtilWork.getNowTime());
                	packageDetail.setDr("N");
                	
                	phyPackageDetailService.saveIPhyPackageDetail(packageDetail);
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        logger.info("保存 IPhyPackage...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IPhyPackage
     * @param context
     * @param request
     * @param iPhyPackage
     */
    public ResultBean updateIPhyPackage(ServletContext context, HttpServletRequest request, IPhyPackage iPhyPackage){
        IPhyPackage tmp = phyPackageService.getIPhyPackageByPk(iPhyPackage.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iPhyPackage.initUpdate(empid);
        try {
        	iPhyPackage.setLastOperator(empid);
        	iPhyPackage.setLastOperatorTime(UtilWork.getNowTime());

			phyPackageService.saveIPhyPackage(iPhyPackage);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        logger.info("更新 IPhyPackage...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IPhyPackage
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIPhyItemsByPackageId(ServletContext context, HttpServletRequest request, String packagePk){
       
    	List<IPhyPackageDetail> packageDetailList = phyPackageDetailService.getIPhyPackageDetailsByPackageId(packagePk);
    	System.out.println("packageDetailList size:"+packageDetailList.size());
    	List<String> itemIdList = new ArrayList<String>();
    	if(packageDetailList!=null){
    		for(int i=0; i<packageDetailList.size(); i++){
    			itemIdList.add(packageDetailList.get(i).getPhyItemId());
    		}
    	}
    	System.out.println("itemIdList size:"+itemIdList.size());
        return WebUtilWork.WebObjectPack(itemIdList);
    }
    
    /**
     * 根据ID获得 套餐体检项目详情
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIPhyPackageByPk(ServletContext context, HttpServletRequest request, String pk){
        IPhyPackage iPhyPackage = phyPackageService.getIPhyPackageByPk(pk);
        if (iPhyPackage != null) {

        	iPhyPackage.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iPhyPackage.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iPhyPackage.getFirstOperator()).getHrmEmployeeName());

        	iPhyPackage.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iPhyPackage.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iPhyPackage.getLastOperator()).getHrmEmployeeName());

        	logger.info("根据ID获得 IPhyPackage...{}", iPhyPackage.getPrimaryKey());
		}
        
        return WebUtilWork.WebObjectPack(iPhyPackage);
    }

    /**
     * 删除 IPhyPackage
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIPhyPackageByPks(ServletContext context, HttpServletRequest request, String[] pks){
    	String empid = UtilTool.getEmployeeId(request);
        phyPackageService.deleteIPhyPackageByPks(pks, empid);
        phyPackageDetailService.deleteIPhyPackageDetailByPackagePks(pks, empid);
        for (String pk : pks) {
            logger.info("删除 IPhyPackage...{}", pk);
            
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