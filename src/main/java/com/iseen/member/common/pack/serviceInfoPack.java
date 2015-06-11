package com.iseen.member.common.pack;

import com.iseen.member.core.pojo.IServiceInfo;

public class serviceInfoPack {

	/**
	 * 查询条件
	 * @param iServiceInfo
	 * @return
	 */
	public static String packIServiceInfoQuery(IServiceInfo iServiceInfo) {
		StringBuffer result = new StringBuffer();
		if (null != iServiceInfo.getServiceInfoCode()
				&& !"".equals(iServiceInfo.getServiceInfoCode().trim()))
			result.append("  and model.serviceInfoCode like '%"
					+ iServiceInfo.getServiceInfoCode().trim() + "%'");
		if (null != iServiceInfo.getServiceInfoName()
				&& !"".equals(iServiceInfo.getServiceInfoName().trim()))
			result.append("  and model.serviceInfoName like '%"
					+ iServiceInfo.getServiceInfoName().trim() + "%'");
		if (null != iServiceInfo.getCrowd()
				&& !"".equals(iServiceInfo.getCrowd().trim()))
			result.append("  and model.crowd like '%"
					+ iServiceInfo.getCrowd().trim() + "%'");
		if (null != iServiceInfo.getMeasuringUnit()
				&& !"".equals(iServiceInfo.getMeasuringUnit().trim()))
			result.append("  and model.measuringUnit like '%"
					+ iServiceInfo.getMeasuringUnit().trim() + "%'");
		 result.append("  and dr='N' order by model.firstOperatorTime desc");
		return result.toString();
	}

	public static String packQuerypks(String pks){
		String[] pkss=pks.split(",");
		StringBuffer spks=new StringBuffer();
		for(String pk:pkss){
			spks.append("'"+pk+"',");
		}
		spks.append("''");
		StringBuffer result = new StringBuffer();
		if(null!=pks&&!"".equals(pks.trim())){
			result.append(" and model.id in ("+spks.toString()+")");
		}
		return result.toString();
	}
}