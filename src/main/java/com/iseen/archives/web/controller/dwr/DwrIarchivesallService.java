package com.iseen.archives.web.controller.dwr;

import com.iseen.archives.core.pojo.IArchivesStart;
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
import com.iseen.archives.core.iservice.IIarchivesallService;

/**********************************************
 * Class name:
 * Description:
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrIarchivesallService {

    private final static Logger logger = LoggerFactory.getLogger(DwrIarchivesallService.class);

    @Resource
    private IIarchivesallService iarchivesallService;

    /**
     * 查询 IArchivesStart 分页列表
     * @param context
     * @param request
     * @param iArchivesStart
     * @param pager
     */
    public ResultBean listIArchivesStart(ServletContext context, HttpServletRequest request, IArchivesStart iArchivesStart, Pager pager){
        List<IArchivesStart> list = null;
        pager = PagerHelper.getPager(pager,iarchivesallService.listIArchivesStartCount(iArchivesStart));
        list = iarchivesallService.listIArchivesStart(iArchivesStart, pager);
        logger.info("查询 IArchivesStart 分页列表...");
        return WebUtilWork.WebResultPack(list, pager);
    }

    /**
     * 查询所有 IArchivesStart 列表
     * @param context
     * @param request
     * @param iArchivesStart
     * @param pager
     */
    public ResultBean listIArchivesStartAll(ServletContext context, HttpServletRequest request){
        IArchivesStart iArchivesStart = new IArchivesStart();
        List<IArchivesStart> list = iarchivesallService.listIArchivesStart(iArchivesStart);
        logger.info("查询所有 IArchivesStart 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IArchivesStart
     * @param context
     * @param request
     * @param iArchivesStart
     */
    public ResultBean saveIArchivesStart(ServletContext context, HttpServletRequest request, IArchivesStart iArchivesStart){
        String empid = UtilTool.getEmployeeId(request);
        iArchivesStart.initSave(empid);
        iArchivesStart.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
        iarchivesallService.saveIArchivesStart(iArchivesStart);
        logger.info("保存 IArchivesStart...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IArchivesStart
     * @param context
     * @param request
     * @param iArchivesStart
     */
    public ResultBean updateIArchivesStart(ServletContext context, HttpServletRequest request, IArchivesStart iArchivesStart){
        IArchivesStart tmp = iarchivesallService.getIArchivesStartByPk(iArchivesStart.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        iArchivesStart.initUpdate(empid);
        iarchivesallService.saveIArchivesStart(iArchivesStart);
        logger.info("更新 IArchivesStart...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IArchivesStart
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIArchivesStartByPk(ServletContext context, HttpServletRequest request, String pk){
        IArchivesStart iArchivesStart = iarchivesallService.getIArchivesStartByPk(pk);
        logger.info("根据ID获得 IArchivesStart...{}", iArchivesStart.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iArchivesStart);
    }

    /**
     * 删除 IArchivesStart
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIArchivesStartByPks(ServletContext context, HttpServletRequest request, String[] pks){
        iarchivesallService.deleteIArchivesStartByPks(pks);
        for (String pk : pks) {
            logger.info("删除 IArchivesStart...{}", pk);
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