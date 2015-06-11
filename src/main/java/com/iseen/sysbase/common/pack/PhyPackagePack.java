package com.iseen.sysbase.common.pack;

import com.iseen.sysbase.core.pojo.IPhyPackage;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class PhyPackagePack{

    public static String packIPhyPackageQuery(IPhyPackage iPhyPackage){
        StringBuffer result = new StringBuffer();
        HqlPack.getStringEqualPack("N", "dr", result);
        return result.toString();
    }

}