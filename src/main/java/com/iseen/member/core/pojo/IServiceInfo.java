package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_service_info
 */
public class IServiceInfo extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("编码|1|1|1|1")
    private String serviceInfoCode;
    @Remark("名称|1|1|1|1")
    private String serviceInfoName;
    @Remark("适用人群|1|1|1|1")
    private String crowd;
    @Remark("计量单位|1|1|1|1")
    private String measuringUnit;
    @Remark("计量单价|1|1|1|1")
    private String measuringUnitPrice;
    @Remark("添加人|1|1|1|1")
    private String firstOperator;
    @Remark("添加时间|1|1|1|1")
    private String firstOperatorTime;
    @Remark("最后修改人|1|1|1|1")
    private String lastOperator;
    @Remark("最后修改时间|1|1|1|1")
    private String lastOperatorTime;
    @Remark("备注|1|1|1|1")
    private String memo;
    @Remark("是否删除|2|1|1|1")
    private String dr;

    //默认构造方法
    public IServiceInfo(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getServiceInfoCode(){
        return serviceInfoCode;
    }

    public void setServiceInfoCode(String aServiceInfoCode){
        this.serviceInfoCode = aServiceInfoCode;
    }

    public String getServiceInfoName(){
        return serviceInfoName;
    }

    public void setServiceInfoName(String aServiceInfoName){
        this.serviceInfoName = aServiceInfoName;
    }

    public String getCrowd(){
        return crowd;
    }

    public void setCrowd(String aCrowd){
        this.crowd = aCrowd;
    }

    public String getMeasuringUnit(){
        return measuringUnit;
    }

    public void setMeasuringUnit(String aMeasuringUnit){
        this.measuringUnit = aMeasuringUnit;
    }

    public String getMeasuringUnitPrice(){
        return measuringUnitPrice;
    }

    public void setMeasuringUnitPrice(String aMeasuringUnitPrice){
        this.measuringUnitPrice = aMeasuringUnitPrice;
    }

    public String getFirstOperator(){
        return firstOperator;
    }

    public void setFirstOperator(String aFirstOperator){
        this.firstOperator = aFirstOperator;
    }

    public String getFirstOperatorTime(){
        return firstOperatorTime;
    }

    public void setFirstOperatorTime(String aFirstOperatorTime){
        this.firstOperatorTime = aFirstOperatorTime;
    }

    public String getLastOperator(){
        return lastOperator;
    }

    public void setLastOperator(String aLastOperator){
        this.lastOperator = aLastOperator;
    }

    public String getLastOperatorTime(){
        return lastOperatorTime;
    }

    public void setLastOperatorTime(String aLastOperatorTime){
        this.lastOperatorTime = aLastOperatorTime;
    }

    public String getMemo(){
        return memo;
    }

    public void setMemo(String aMemo){
        this.memo = aMemo;
    }

    public String getDr(){
        return dr;
    }

    public void setDr(String aDr){
        this.dr = aDr;
    }

}