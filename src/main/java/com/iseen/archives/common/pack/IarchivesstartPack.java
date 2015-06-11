package com.iseen.archives.common.pack;

import org.apache.commons.lang.StringUtils;

import com.iseen.archives.core.pojo.IArchivesDrugallergy;
import com.iseen.member.core.pojo.IMember;
import com.iseen.archives.core.pojo.IArchivesDisease;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.StringTool;
import com.centling.common.util.UtilWork;

public class IarchivesstartPack{

    public static String packIArchivesDrugallergyQuery(IArchivesDrugallergy iArchivesDrugallergy){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

    //原来这个方法是用来写高级查询的
    public static String packIMemberQuery(IMember iMember){
        StringBuffer result = new StringBuffer();
       
       //增加代码 
        String name = iMember.getMemberName();
		if(StringUtils.isNotBlank(name)){
			
			//封装会员名字参数
				HqlPack.getStringLikerPack(name,"memberName", result);
			
		}
		//以下为需要封装的高级查询的参数
		//封装会员主键参数
	    HqlPack.getStringEqualPack(iMember.getPrimaryKey(),"primaryKey", result);
	    //
		HqlPack.getStringLikerPack(iMember.getMemberPhone(),"memberPhone", result);
		//HqlPack.timeBuilder(iMember.getHrmEmployeeBirthday(),"hrmEmployeeBirthday",result,false,false);
		//HqlPack.timeBuilder(iMember.getHrmEmployeeInTime(),"hrmEmployeeInTime",result,false,false);*/
		HqlPack.getNumEqualPack(iMember.getMemberSex(), "memberSex", result);
		/*HqlPack.getNumEqualPack(iMember.getHrmEmployeeDepid(), "hrmEmployeeDepid", result);
		HqlPack.getNumEqualPack(iMember.getHrmEmployeeActive(), "hrmEmployeeActive", result);
		HqlPack.getNumEqualPack(l, "companyId", result);
		HqlPack.getInPackString(iMember.getEmployeeIds(), "primaryKey", result);
		HqlPack.getInPack(iMember.getHrmEmployeeDepidTree(), "hrmEmployeeDepid", result);*/
        
        
        
        
        return result.toString();
    }

    public static String packIArchivesDiseaseQuery(IArchivesDisease iArchivesDisease){
        StringBuffer result = new StringBuffer();
        //result.append(" order by model.recordDate desc");
        return result.toString();
    }

}