package com.iseen.member.common.pack;

import com.iseen.member.core.pojo.IServicePackage;
import com.centling.common.util.UtilWork;

public class ServicepackagePack{

    public static String packIServicePackageQuery(IServicePackage iServicePackage){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

    public static String packiservicedetail(String str){
    	StringBuffer result = new StringBuffer();
    	if(null!=str&&!"".equals(str.trim())){
    		result.append(" and model.iservicepackageid='"+str+"'");
    	}
    	return result.toString();
    }
}