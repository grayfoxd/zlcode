package com.iseen.member.common.pack;

import org.apache.commons.lang.StringUtils;

import com.iseen.member.core.pojo.IMemberConsumption;
import com.centling.common.pack.HqlPack;
import com.centling.common.util.UtilWork;

public class ImemberconsumptionPack{

    public static String packIMemberConsumptionQuery(IMemberConsumption iMemberConsumption){
        StringBuffer result = new StringBuffer();
      
        //增加代码 
        String name = iMemberConsumption.getMemberName();
		if(StringUtils.isNotBlank(name)){
			
			//封装会员名字参数
				HqlPack.getStringLikerPack(name,"memberName", result);
			
		}
		//以下为需要封装的高级查询的参数
		//封装会员主键参数
	    HqlPack.getStringEqualPack(iMemberConsumption.getPrimaryKey(),"primaryKey", result);
	
		HqlPack.getStringLikerPack(iMemberConsumption.getConsumptionContent(),"consumptionContent", result);
	
		HqlPack.getNumEqualPack(iMemberConsumption.getConsumptionTime(), "consumptionTime", result);
		
        
        
        return result.toString();
    }

}