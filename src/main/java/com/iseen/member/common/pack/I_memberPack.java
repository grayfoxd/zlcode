package com.iseen.member.common.pack;

import org.apache.commons.lang.StringUtils;

import com.iseen.member.core.pojo.IMember;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class I_memberPack{

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

}