package com.iseen.sysbase.common.pack;

import com.iseen.sysbase.core.pojo.IDiseaseLevel;
import com.iseen.sysbase.core.pojo.IPhyItem;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class DiseaseLevelPack{

    public static String packIDiseaseLevelQuery(IDiseaseLevel iDiseaseLevel){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }
    
    public static String packIDiseaseLevelList(IDiseaseLevel iDiseaseLevel){
    	StringBuffer result = new StringBuffer();
        HqlPack.getStringEqualPack(iDiseaseLevel.getPhyItemId(), "phyItemId", result);
        HqlPack.getStringEqualPack("N", "dr", result);
        result.append(" order by model.primaryKey");
        return result.toString();
    }

}