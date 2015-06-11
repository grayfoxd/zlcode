package com.iseen.sysbase.web.controller.dwr;

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
import com.iseen.sysbase.core.iservice.IPhyItemService;

/**********************************************
 * Class name: Description: Others: History:
 **********************************************/
@Controller
public class DwrPhyItemService {

	private final static Logger logger = LoggerFactory
			.getLogger(DwrPhyItemService.class);

	@Resource
	private IPhyItemService phyItemService;
	@Resource
	private IHrmEmployeeService hrmEmployeeService;

	/**
	 * 查询 IPhyItem 分页列表
	 * 
	 * @param context
	 * @param request
	 * @param iPhyItem
	 * @param pager
	 */
	public ResultBean listIPhyItem(ServletContext context,
			HttpServletRequest request, IPhyItem iPhyItem, Pager pager) {
		List<IPhyItem> list = null;
		pager = PagerHelper.getPager(pager,
				phyItemService.listIPhyItemCount(iPhyItem));
		list = phyItemService.listIPhyItem(iPhyItem, pager);
		logger.info("查询 IPhyItem 分页列表...");
		return WebUtilWork.WebResultPack(list, pager);
	}

	public ResultBean getIPhyItemList(ServletContext context,
			HttpServletRequest request, IPhyItem iPhyItem, Pager pager) {
		List<IPhyItem> list = null;
		pager = PagerHelper.getPager(pager,
				phyItemService.getIPhyItemListCount(iPhyItem));
		list = phyItemService.getPhyItemList(iPhyItem, pager);

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				IPhyItem item = list.get(i);
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
	 * 查询所有 IPhyItem 列表
	 * 
	 * @param context
	 * @param request
	 * @param iPhyItem
	 * @param pager
	 */
	public ResultBean listIPhyItemAll(ServletContext context,
			HttpServletRequest request) {
		IPhyItem iPhyItem = new IPhyItem();
		List<IPhyItem> list = phyItemService.listIPhyItem(iPhyItem);
		logger.info("查询所有 IPhyItem 列表...");
		return WebUtilWork.WebResultPack(list);
	}

	/**
	 * 保存 IPhyItem
	 * 
	 * @param context
	 * @param request
	 * @param iPhyItem
	 */
	public ResultBean saveIPhyItem(ServletContext context,
			HttpServletRequest request, IPhyItem iPhyItem) {
		String empid = UtilTool.getEmployeeId(request);
		iPhyItem.initSave(empid);

		try {
			// eric.jin modify
			iPhyItem.setFirstOperator(empid);
			iPhyItem.setFirstOperatorTime(UtilWork.getNowTime());
			iPhyItem.setLastOperator(empid);
			iPhyItem.setLastOperatorTime(UtilWork.getNowTime());
			iPhyItem.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			iPhyItem.setDr("N");
			phyItemService.saveIPhyItem(iPhyItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("保存 IPhyItem...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 更新 IPhyItem
	 * 
	 * @param context
	 * @param request
	 * @param iPhyItem
	 */
	public ResultBean updateIPhyItem(ServletContext context,
			HttpServletRequest request, IPhyItem iPhyItem) {
		IPhyItem tmp = phyItemService.getIPhyItemByPk(iPhyItem.getPrimaryKey());
		String empid = UtilTool.getEmployeeId(request);
		iPhyItem.initUpdate(empid);

		try {
			// eric.jin modify
			iPhyItem.setLastOperator(empid);
			iPhyItem.setLastOperatorTime(UtilWork.getNowTime());

			phyItemService.saveIPhyItem(iPhyItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("更新 IPhyItem...");
		return WebUtilWork.WebResultPack(null);
	}

	/**
	 * 根据ID获得 IPhyItem
	 * 
	 * @param context
	 * @param request
	 * @param pk
	 */
	public ResultBean getIPhyItemByPk(ServletContext context,
			HttpServletRequest request, String pk) {
		System.out.println("enter getIPhyItemByPk()");
		IPhyItem iPhyItem = phyItemService.getIPhyItemByPk(pk);
		if (iPhyItem != null) {

			iPhyItem.setFirstOperator(hrmEmployeeService
					.getEmployeeByPK(iPhyItem.getFirstOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iPhyItem.getFirstOperator()).getHrmEmployeeName());

			iPhyItem.setLastOperator(hrmEmployeeService
					.getEmployeeByPK(iPhyItem.getLastOperator()) == null ? ""
					: hrmEmployeeService.getEmployeeByPK(
							iPhyItem.getLastOperator()).getHrmEmployeeName());

			logger.info("根据ID获得 IPhyItem...{}", iPhyItem.getPrimaryKey());
		}
		return WebUtilWork.WebObjectPack(iPhyItem);
	}

	/**
	 * 删除 IPhyItem
	 * 
	 * @param context
	 * @param request
	 * @param pks
	 */
	public ResultBean deleteIPhyItemByPks(ServletContext context,
			HttpServletRequest request, String[] pks) {
		String empid = UtilTool.getEmployeeId(request);

		phyItemService.deleteIPhyItemByPks(pks, empid);
		for (String pk : pks) {
			logger.info("删除 IPhyItem...{}", pk);
		}
		return WebUtilWork.WebResultPack(null);
	}

	public List<IPhyItem> getIPhyItemByUpCode(String code) {
		List<IPhyItem> itemList = null;
		IPhyItem tmp = phyItemService.getIPhyItemByPk(code);
		if (tmp != null && tmp.getIsLeaf().equals('1')) {
			itemList = new ArrayList<IPhyItem>();
		} else {
			itemList = phyItemService.getIPhyItemListByUpCode(code);
		}
		logger.info("DwrPhyItemService.getIPhyItemByUpCode itemList length:"
				+ itemList.size());
		return itemList;
	}

	public int getIPhyItemByUpCodeCount(String code) {
		int count = 0;
		IPhyItem tmp = phyItemService.getIPhyItemByPk(code);
		if (tmp != null && tmp.getIsLeaf().equals('1')) {
			return count;
		}
		logger.info("DwrPhyItemService.getIPhyItemByUpCodeCount count:" + count);
		return phyItemService.getPhyItemListByUpCodeCount(code);
	}

	public ResultBean updatePhyItem(ServletContext context,
			HttpServletRequest request, IPhyItem phyItem) {
		if (StringUtils.isBlank(phyItem.getParentId())) {
			phyItem.setParentId("-1");
		}

		IPhyItem item = phyItemService.getIPhyItemByPk(phyItem.getPrimaryKey());
		int count = phyItemService.getPhyItemByNameAndParentId(
				phyItem.getItemName(), phyItem.getParentId(),
				phyItem.getPrimaryKey());
		if (count > 0) {
			return new ResultBean(false, "同一级别下，项目目录名称不能重名！");
		}

		if (!phyItem.getParentId().equals(item.getParentId())) {// 上级编码有变动
			boolean bl = false;
			// 判断上级目录是否为自己和自己的下级目录
			List<IPhyItem> list = phyItemService.getPhyItemListByPK(item
					.getPrimaryKey());
			for (IPhyItem pi : list) {
				if (pi.getPrimaryKey().equals(phyItem.getParentId())) {
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
		phyItem.initUpdate(empid);
		phyItem.setLastOperator(empid);
		phyItem.setLastOperatorTime(UtilWork.getNowTime());
		if(item!=null){
			phyItem.setFirstOperator(item.getFirstOperator());
			phyItem.setFirstOperatorTime(item.getFirstOperatorTime());
			phyItem.setDr(item.getDr());
		}
		
		phyItemService.saveIPhyItem(phyItem);

		logger.info("更新项目目录信息...");
		return WebUtilWork.WebResultPack(null);
	}
	
	public ResultBean getIPhyItemsByPks(ServletContext context,
			HttpServletRequest request, String pks){
		System.out.println("getIPhyItemsByPks pks:" + pks);
		List<IPhyItem> list = phyItemService.getPhyItemListByPks(pks);
		System.out.println("getIPhyItemsByPks phyitem list size:" + list.size());
		return WebUtilWork.WebResultPack(list);
	}

	/**********************************************
	 * 以上代码由CTOA代码生成工具自动生成，请根据具体需求进行修改。
	 * 开发人员在此注释以下编写业务逻辑代码，并将自己写的代码框起来，便于后期代码合并，例如：
	 **********************************************/

	/********************** JC-begin **********************/
	public void method() {
		System.out.println("JC's code here");
	}

	/********************** JC-end **********************/

	/********************** Jacy-begin **********************/
	public void method2() {
		System.out.println("Jacy's code here");
	}
	/********************** Jacy-end **********************/

}