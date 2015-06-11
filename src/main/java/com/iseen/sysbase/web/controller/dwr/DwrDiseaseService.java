package com.iseen.sysbase.web.controller.dwr;

import com.iseen.sysbase.core.pojo.IPhyDisease;
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
import com.iseen.sysbase.core.iservice.IDiseaseService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrDiseaseService {

    private final static Logger logger = LoggerFactory.getLogger(DwrDiseaseService.class);

    @Resource
    private IDiseaseService diseaseService;

    /**
     * 查询 IPhyDisease 分页列表
     * @param context
     * @param request
     * @param iPhyDisease
     * @param pager
     */
    public ResultBean listIPhyDisease(ServletContext context, HttpServletRequest request, IPhyDisease iPhyDisease, Pager pager){
        List<IPhyDisease> list = null;
        pager = PagerHelper.getPager(pager,diseaseService.listIPhyDiseaseCount(iPhyDisease));
        list = diseaseService.listIPhyDisease(iPhyDisease, pager);
        logger.info("查询 IPhyDisease 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IPhyDisease 列表
     * @param context
     * @param request
     * @param iPhyDisease
     * @param pager
     */
    public ResultBean listIPhyDiseaseAll(ServletContext context, HttpServletRequest request){
        IPhyDisease iPhyDisease = new IPhyDisease();
        List<IPhyDisease> list = diseaseService.listIPhyDisease(iPhyDisease);
        logger.info("查询所有 IPhyDisease 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IPhyDisease
     * @param context
     * @param request
     * @param iPhyDisease
     */
    public ResultBean saveIPhyDisease(ServletContext context, HttpServletRequest request, IPhyDisease iPhyDisease){
        String empid = UtilTool.getEmployeeId(request);
        iPhyDisease.initSave(empid);
        iPhyDisease.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        diseaseService.saveIPhyDisease(iPhyDisease);
        logger.info("保存 IPhyDisease...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IPhyDisease
     * @param context
     * @param request
     * @param iPhyDisease
     */
    public ResultBean updateIPhyDisease(ServletContext context, HttpServletRequest request, IPhyDisease iPhyDisease){
        IPhyDisease tmp = diseaseService.getIPhyDiseaseByPk(iPhyDisease.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iPhyDisease.initUpdate(empid);
        diseaseService.saveIPhyDisease(iPhyDisease);
        logger.info("更新 IPhyDisease...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IPhyDisease
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIPhyDiseaseByPk(ServletContext context, HttpServletRequest request, String pk){
        IPhyDisease iPhyDisease = diseaseService.getIPhyDiseaseByPk(pk);
        logger.info("根据ID获得 IPhyDisease...{}", iPhyDisease.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iPhyDisease);
    }

    /**
     * 删除 IPhyDisease
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIPhyDiseaseByPks(ServletContext context, HttpServletRequest request, String[] pks){
        diseaseService.deleteIPhyDiseaseByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IPhyDisease...{}", pk);
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