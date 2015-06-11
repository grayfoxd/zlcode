package com.iseen.member.web.controller.dwr;

import com.iseen.member.core.pojo.IServiceInfo;
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
import com.iseen.member.core.iservice.IContractService;

/**********************************************
 * Class name:
 * Description:合同部分
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrContractService {

    private final static Logger logger = LoggerFactory.getLogger(DwrContractService.class);

    @Resource
    private IContractService contractService;

    /**
     * 查询 IServiceInfo 分页列表
     * @param context
     * @param request
     * @param iServiceInfo
     * @param pager
     */
    public ResultBean listIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo, Pager pager){
        List<IServiceInfo> list = null;
        pager = PagerHelper.getPager(pager,contractService.listIServiceInfoCount(iServiceInfo));
        list = contractService.listIServiceInfo(iServiceInfo, pager);
        logger.info("查询 IServiceInfo 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IServiceInfo 列表
     * @param context
     * @param request
     * @param iServiceInfo
     * @param pager
     */
    public ResultBean listIServiceInfoAll(ServletContext context, HttpServletRequest request){
        IServiceInfo iServiceInfo = new IServiceInfo();
        List<IServiceInfo> list = contractService.listIServiceInfo(iServiceInfo);
        logger.info("查询所有 IServiceInfo 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IServiceInfo
     * @param context
     * @param request
     * @param iServiceInfo
     */
    public ResultBean saveIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo){
        String empid = UtilTool.getEmployeeId(request);
        iServiceInfo.initSave(empid);
        iServiceInfo.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        contractService.saveIServiceInfo(iServiceInfo);
        logger.info("保存 IServiceInfo...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IServiceInfo
     * @param context
     * @param request
     * @param iServiceInfo
     */
    public ResultBean updateIServiceInfo(ServletContext context, HttpServletRequest request, IServiceInfo iServiceInfo){
        IServiceInfo tmp = contractService.getIServiceInfoByPk(iServiceInfo.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iServiceInfo.initUpdate(empid);
        contractService.saveIServiceInfo(iServiceInfo);
        logger.info("更新 IServiceInfo...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IServiceInfo
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIServiceInfoByPk(ServletContext context, HttpServletRequest request, String pk){
        IServiceInfo iServiceInfo = contractService.getIServiceInfoByPk(pk);
        logger.info("根据ID获得 IServiceInfo...{}", iServiceInfo.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iServiceInfo);
    }

    /**
     * 删除 IServiceInfo
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIServiceInfoByPks(ServletContext context, HttpServletRequest request, String[] pks){
        contractService.deleteIServiceInfoByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IServiceInfo...{}", pk);
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