package com.iseen.sysbase.common.pack;

import com.iseen.sysbase.core.pojo.IPhyItem;
import com.centling.common.pack.HqlPack;

public class PhyItemPack{

    public static String packIPhyItemQuery(IPhyItem iPhyItem){
        StringBuffer result = new StringBuffer();
        return result.toString();
    }
    
    public static String packIPhyItemList(IPhyItem iPhyItem){
    	StringBuffer result = new StringBuffer();
        HqlPack.getStringEqualPack(iPhyItem.getParentId(), "parentId", result);
        HqlPack.getStringEqualPack("N", "dr", result);
        result.append(" order by model.primaryKey");
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
			result.append(" and model.primaryKey in ("+spks.toString()+")");
		}
		return result.toString();
	}

}