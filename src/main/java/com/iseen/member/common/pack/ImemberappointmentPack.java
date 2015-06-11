package com.iseen.member.common.pack;

import org.apache.commons.lang.StringUtils;

import com.iseen.member.core.pojo.IMemberAppointment;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class ImemberappointmentPack{

    public static String packIMemberAppointmentQuery(IMemberAppointment iMemberAppointment){
        StringBuffer result = new StringBuffer();
      
        //增加代码 
        String name = iMemberAppointment.getMemberName();
		if(StringUtils.isNotBlank(name)){
			
			//封装会员名字参数
				HqlPack.getStringLikerPack(name,"memberName", result);
			
		}
		//以下为需要封装的高级查询的参数
		//封装会员主键参数
	    HqlPack.getStringEqualPack(iMemberAppointment.getPrimaryKey(),"primaryKey", result);
	
		HqlPack.getStringLikerPack(iMemberAppointment.getMemberName(),"memberName", result);
	
		HqlPack.getNumEqualPack(iMemberAppointment.getAppointmentType(), "appointmentType", result);
		
		HqlPack.getNumEqualPack(iMemberAppointment.getExpectedTime(), "expectedTime", result);
		
		HqlPack.getNumEqualPack(iMemberAppointment.getEndTime(), "endTime", result);
            
        return result.toString();
    }

}