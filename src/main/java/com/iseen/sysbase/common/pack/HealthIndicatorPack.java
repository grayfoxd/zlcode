package com.iseen.sysbase.common.pack;

import com.iseen.sysbase.core.pojo.IHealthIndicator;
import com.iseen.sysbase.core.pojo.IPhyItem;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class HealthIndicatorPack{

    public static String packIHealthIndicatorQuery(IHealthIndicator iHealthIndicator){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

    
    public static String packIHealthIndicatorList(IHealthIndicator iHealthIndicator){
    	StringBuffer result = new StringBuffer();
        HqlPack.getStringEqualPack(iHealthIndicator.getParentId(), "parentId", result);
        HqlPack.getStringEqualPack("N", "dr", result);
        result.append(" order by model.primaryKey");
        return result.toString();
    }
}