package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_member_consumption
 */
public class IMemberConsumption extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员ID|1|1|1|1")
    private String memberId;
    @Remark("会员姓名|1|1|1|1")
    private String memberName;
    @Remark("消费明细|1|1|1|1")
    private String consumptionContent;
    @Remark("消费时间|1|1|1|1")
    private String consumptionTime;
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
    public IMemberConsumption(){
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

    public String getConsumptionContent(){
        return consumptionContent;
    }

    public void setConsumptionContent(String aConsumptionContent){
        this.consumptionContent = aConsumptionContent;
    }

    public String getConsumptionTime(){
        return consumptionTime;
    }

    public void setConsumptionTime(String aConsumptionTime){
        this.consumptionTime = aConsumptionTime;
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