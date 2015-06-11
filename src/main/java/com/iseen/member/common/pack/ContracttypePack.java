package com.iseen.member.common.pack;

import com.iseen.member.core.pojo.IContractType;

/**
 * 合同类型扩展
 * @author JasonFeng
 *
 */
public class ContracttypePack {
	/**
	 * 合同类型查询
	 * @param iContractType
	 * @return
	 */
	public static String packIContractTypeQuery(IContractType iContractType) {
		StringBuffer result = new StringBuffer();
		if (null != iContractType.getContractTypeCode()
				&& !"".equals(iContractType.getContractTypeCode())){
			result.append("  and model.contractTypeCode like '%"
					+ iContractType.getContractTypeCode().trim() + "%'");
		}
			
		if (null != iContractType.getContractTypeName()
				&& !"".equals(iContractType.getContractTypeName())){
			result.append(" and model.contractTypeName like '%"
					+ iContractType.getContractTypeName().trim() + "%' ");
		}
		result.append(" and model.dr='N' order by model.contractTypeCode desc");
		return result.toString();
	}

}