package com.iseen.archives.common.pack;

import com.iseen.archives.core.pojo.IArchivesMedicalrecord;
import com.iseen.member.core.pojo.IMember;
import com.centling.common.util.UtilWork;

public class ImedicalrecordPack{

    public static String packIArchivesMedicalrecordQuery(IArchivesMedicalrecord iArchivesMedicalrecord){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

    public static String packIMemberQuery(IMember iMember){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

}