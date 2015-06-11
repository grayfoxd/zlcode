package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IPhyAdvise;
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
import com.centling.common.util.WebUtilWork;
import com.iseen.sysbase.core.iservice.IAdviseService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrAdviseService {

    private final static Logger logger = LoggerFactory.getLogger(DwrAdviseService.class);

    @Resource
    private IAdviseService adviseService;

    /**
     * 查询 IPhyAdvise 分页列表
     * @param context
     * @param request
     * @param iPhyAdvise
     * @param pager
     */
    public ResultBean listIPhyAdvise(ServletContext context, HttpServletRequest request, IPhyAdvise iPhyAdvise, Pager pager){
        List<IPhyAdvise> list = null;
        pager = PagerHelper.getPager(pager,adviseService.listIPhyAdviseCount(iPhyAdvise));
        list = adviseService.listIPhyAdvise(iPhyAdvise, pager);
        logger.info("查询 IPhyAdvise 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IPhyAdvise 列表
     * @param context
     * @param request
     * @param iPhyAdvise
     * @param pager
     */
    public ResultBean listIPhyAdviseAll(ServletContext context, HttpServletRequest request){
        IPhyAdvise iPhyAdvise = new IPhyAdvise();
        List<IPhyAdvise> list = adviseService.listIPhyAdvise(iPhyAdvise);
        logger.info("查询所有 IPhyAdvise 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IPhyAdvise
     * @param context
     * @param request
     * @param iPhyAdvise
     */
    public ResultBean saveIPhyAdvise(ServletContext context, HttpServletRequest request, IPhyAdvise iPhyAdvise){
        String empid = UtilTool.getEmployeeId(request);
        iPhyAdvise.initSave(empid);
        iPhyAdvise.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        adviseService.saveIPhyAdvise(iPhyAdvise);
        logger.info("保存 IPhyAdvise...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IPhyAdvise
     * @param context
     * @param request
     * @param iPhyAdvise
     */
    public ResultBean updateIPhyAdvise(ServletContext context, HttpServletRequest request, IPhyAdvise iPhyAdvise){
        IPhyAdvise tmp = adviseService.getIPhyAdviseByPk(iPhyAdvise.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iPhyAdvise.initUpdate(empid);
        adviseService.saveIPhyAdvise(iPhyAdvise);
        logger.info("更新 IPhyAdvise...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IPhyAdvise
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIPhyAdviseByPk(ServletContext context, HttpServletRequest request, String pk){
        IPhyAdvise iPhyAdvise = adviseService.getIPhyAdviseByPk(pk);
        logger.info("根据ID获得 IPhyAdvise...{}", iPhyAdvise.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iPhyAdvise);
    }

    /**
     * 删除 IPhyAdvise
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIPhyAdviseByPks(ServletContext context, HttpServletRequest request, String[] pks){
        adviseService.deleteIPhyAdviseByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IPhyAdvise...{}", pk);
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