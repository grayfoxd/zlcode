package com.iseen.member.web.controller.dwr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.centling.common.module.ResultBean;
import com.centling.common.pages.Pager;
import com.centling.common.pages.PagerHelper;
import com.centling.common.util.CopyUtil;
import com.centling.common.util.UtilPrimaryKey;
import com.centling.common.util.UtilTool;
import com.centling.common.util.UtilWork;
import com.centling.common.util.WebUtilWork;
import com.centling.core.iservice.IHrmEmployeeService;
import com.iseen.member.core.iservice.IContracttypeService;
import com.iseen.member.core.pojo.IContractType;
import com.iseen.member.web.vo.ContractTypeVo;

/**********************************************
 * Class name:
 * Description: 合同类型
 * Others:
 * History:
 **********************************************/
@Controller
public class DwrContracttypeService {

    private final static Logger logger = LoggerFactory.getLogger(DwrContracttypeService.class);

    @Resource
    private IContracttypeService contracttypeService;
    
    @Resource
    private IHrmEmployeeService hrmEmployeeService;

    /**
     * 查询 IContractType 分页列表
     * @param context
     * @param request
     * @param iContractType
     * @param pager
     */
    
    public ResultBean listIContractType(ServletContext context, HttpServletRequest request, IContractType iContractType, Pager pager){
        List<IContractType> list = null;
		pager = PagerHelper.getPager(pager,
				contracttypeService.listIContractTypeCount(iContractType));
		list = contracttypeService.listIContractType(iContractType, pager);
		Iterator<IContractType> it = list.iterator();
		List<IContractType> vo_list = new ArrayList<IContractType>();
		while (it.hasNext()) {
			IContractType icontracttype = (IContractType) it.next();
			try {
				icontracttype.setFirstOperator(hrmEmployeeService
						.getEmployeeByPK(icontracttype.getFirstOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								icontracttype.getFirstOperator())
								.getHrmEmployeeName());
				icontracttype.setLastOperator(hrmEmployeeService
						.getEmployeeByPK(icontracttype.getLastOperator()) == null ? ""
						: hrmEmployeeService.getEmployeeByPK(
								icontracttype.getLastOperator())
								.getHrmEmployeeName());
				vo_list.add(icontracttype);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		logger.info("查询 IContractType 分页列表...");
		return WebUtilWork.WebResultPack(vo_list, pager);
    }

    /**
     * 查询所有 IContractType 列表
     * @param context
     * @param request
     * @param iContractType
     * @param pager
     */
    public ResultBean listIContractTypeAll(ServletContext context, HttpServletRequest request){
        IContractType iContractType = new IContractType();
        List<IContractType> list = contracttypeService.listIContractType(iContractType);
        logger.info("查询所有 IContractType 列表...");
        return WebUtilWork.WebResultPack(list);
    }

    /**
     * 保存 IContractType
     * @param context
     * @param request
     * @param iContractType
     */
    public ResultBean saveIContractType(ServletContext context, HttpServletRequest request, IContractType iContractType){
        String empid = UtilTool.getEmployeeId(request);
        try {
			iContractType.initSave(empid);
			iContractType.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iContractType.setFirstOperator(UtilTool.getEmployeeId(request));
			iContractType.setFirstOperatorTime(UtilWork.getNowTime());
			iContractType.setLastOperator(UtilTool.getEmployeeId(request));
			iContractType.setLastOperatorTime(UtilWork.getNowTime());
			iContractType.setLastmodiId(UtilTool.getEmployeeId(request));
			iContractType.setLastmodiDate(UtilWork.getNowTime());
			iContractType.setDr("N");
			contracttypeService.saveIContractType(iContractType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		logger.info("保存 IContractType...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 更新 IContractType
     * @param context
     * @param request
     * @param iContractType
     */
    public ResultBean updateIContractType(ServletContext context, HttpServletRequest request, IContractType iContractType){
        IContractType tmp = contracttypeService.getIContractTypeByPk(iContractType.getPrimaryKey());
        String empid = UtilTool.getEmployeeId(request);
        try {
        	tmp.setContractTypeCode(iContractType.getContractTypeCode());
        	tmp.setContractTypeName(iContractType.getContractTypeName());
        	tmp.setMemo(iContractType.getMemo());
        	tmp.initUpdate(empid);
        	tmp.setLastOperator(UtilTool.getEmployeeId(request));
        	tmp.setLastOperatorTime(UtilWork.getNowTime());
			contracttypeService.saveIContractType(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("更新 IContractType...");
        return WebUtilWork.WebResultPack(null);
    }

    /**
     * 根据ID获得 IContractType
     * @param context
     * @param request
     * @param pk
     */
    public ResultBean getIContractTypeByPk(ServletContext context, HttpServletRequest request, String pk){
        IContractType iContractType = contracttypeService.getIContractTypeByPk(pk);
        iContractType.setFirstOperator(hrmEmployeeService
				.getEmployeeByPK(iContractType.getFirstOperator()) == null ? ""
				: hrmEmployeeService.getEmployeeByPK(
						iContractType.getFirstOperator())
						.getHrmEmployeeName());
        iContractType.setLastOperator(hrmEmployeeService
				.getEmployeeByPK(iContractType.getLastOperator()) == null ? ""
				: hrmEmployeeService.getEmployeeByPK(
						iContractType.getLastOperator())
						.getHrmEmployeeName());
        logger.info("根据ID获得 IContractType...{}", iContractType.getPrimaryKey());
        return WebUtilWork.WebObjectPack(iContractType);
    }

    /**
     * 删除 IContractType
     * @param context
     * @param request
     * @param pks
     */
    public ResultBean deleteIContractTypeByPks(ServletContext context, HttpServletRequest request, String[] pks){
        try {
			contracttypeService.deleteIContractTypeByPks(pks,null);
			for (String pk : pks) {
			    logger.info("删除 IContractType...{}", pk);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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