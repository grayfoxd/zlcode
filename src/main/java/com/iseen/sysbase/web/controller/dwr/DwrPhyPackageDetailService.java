package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IPhyPackageDetail;
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
import com.iseen.sysbase.core.iservice.IPhyPackageDetailService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrPhyPackageDetailService {

    private final static Logger logger = LoggerFactory.getLogger(DwrPhyPackageDetailService.class);

    @Resource
    private IPhyPackageDetailService phyPackageDetailService;

    /**
     * 查询 IPhyPackageDetail 分页列表
     * @param context
     * @param request
     * @param iPhyPackageDetail
     * @param pager
     */
    public ResultBean listIPhyPackageDetail(ServletContext context, HttpServletRequest request, IPhyPackageDetail iPhyPackageDetail, Pager pager){
        List<IPhyPackageDetail> list = null;
        pager = PagerHelper.getPager(pager,phyPackageDetailService.listIPhyPackageDetailCount(iPhyPackageDetail));
        list = phyPackageDetailService.listIPhyPackageDetail(iPhyPackageDetail, pager);
        logger.info("查询 IPhyPackageDetail 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IPhyPackageDetail 列表
     * @param context
     * @param request
     * @param iPhyPackageDetail
     * @param pager
     */
    public ResultBean listIPhyPackageDetailAll(ServletContext context, HttpServletRequest request){
        IPhyPackageDetail iPhyPackageDetail = new IPhyPackageDetail();
        List<IPhyPackageDetail> list = phyPackageDetailService.listIPhyPackageDetail(iPhyPackageDetail);
        logger.info("查询所有 IPhyPackageDetail 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IPhyPackageDetail
     * @param context
     * @param request
     * @param iPhyPackageDetail
     */
    public ResultBean saveIPhyPackageDetail(ServletContext context, HttpServletRequest request, IPhyPackageDetail iPhyPackageDetail){
        String empid = UtilTool.getEmployeeId(request);
        iPhyPackageDetail.initSave(empid);
        iPhyPackageDetail.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        iPhyPackageDetail.setDr("N");
        iPhyPackageDetail.setFirstOperator(empid);
        iPhyPackageDetail.setFirstOperatorTime(UtilWork.getNowTime());
        iPhyPackageDetail.setLastOperator(empid);
        iPhyPackageDetail.setLastOperatorTime(UtilWork.getNowTime());
        phyPackageDetailService.saveIPhyPackageDetail(iPhyPackageDetail);
        logger.info("保存 IPhyPackageDetail...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IPhyPackageDetail
     * @param context
     * @param request
     * @param iPhyPackageDetail
     */
    public ResultBean updateIPhyPackageDetail(ServletContext context, HttpServletRequest request, IPhyPackageDetail iPhyPackageDetail){
        IPhyPackageDetail tmp = phyPackageDetailService.getIPhyPackageDetailByPk(iPhyPackageDetail.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iPhyPackageDetail.initUpdate(empid);
        iPhyPackageDetail.setLastOperator(empid);
        iPhyPackageDetail.setLastOperatorTime(UtilWork.getNowTime());
        phyPackageDetailService.saveIPhyPackageDetail(iPhyPackageDetail);
        logger.info("更新 IPhyPackageDetail...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IPhyPackageDetail
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIPhyPackageDetailByPk(ServletContext context, HttpServletRequest request, String pk){
        IPhyPackageDetail iPhyPackageDetail = phyPackageDetailService.getIPhyPackageDetailByPk(pk);
        logger.info("根据ID获得 IPhyPackageDetail...{}", iPhyPackageDetail.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iPhyPackageDetail);
    }

    /**
     * 删除 IPhyPackageDetail
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIPhyPackageDetailByPks(ServletContext context, HttpServletRequest request, String[] pks){
    	String empid = UtilTool.getEmployeeId(request);
        phyPackageDetailService.deleteIPhyPackageDetailByPks(pks, empid);
        for (String pk : pks) {
            logger.info("删除 IPhyPackageDetail...{}", pk);
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