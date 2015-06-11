package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_service_log
 */
public class IServiceLog extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员ID|1|1|1|1")
    private String memberId;
    @Remark("会员姓名|1|1|1|1")
    private String memberName;
    @Remark("服务记录|1|1|1|1")
    private String serviceRecord;
    @Remark("记录时间|1|1|1|1")
    private String recordTime;
    @Remark("服务类型|1|1|1|1")
    private Integer serviceType;
    @Remark("流程ID|1|1|1|1")
    private String processInstanceId;
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
    public IServiceLog(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getMemberId(){
        return memberId;
    }

    public void setMemberId(String aMemberId){
        this.memberId = aMemberId;
    }

    public String getMemberName(){
        return memberName;
    }

    public void setMemberName(String aMemberName){
        this.memberName = aMemberName;
    }

    public String getServiceRecord(){
        return serviceRecord;
    }

    public void setServiceRecord(String aServiceRecord){
        this.serviceRecord = aServiceRecord;
    }

    public String getRecordTime(){
        return recordTime;
    }

    public void setRecordTime(String aRecordTime){
        this.recordTime = aRecordTime;
    }

    public Integer getServiceType(){
        return serviceType;
    }

    public void setServiceType(Integer aServiceType){
        this.serviceType = aServiceType;
    }

    public String getProcessInstanceId(){
        return processInstanceId;
    }

    public void setProcessInstanceId(String aProcessInstanceId){
        this.processInstanceId = aProcessInstanceId;
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