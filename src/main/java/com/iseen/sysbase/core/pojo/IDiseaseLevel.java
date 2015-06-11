package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_disease_level
 */
public class IDiseaseLevel extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("异常等级名称|1|1|1|1")
    private String diseaseLevelName;
    @Remark("异常等级值|1|1|1|1")
    private String diseaseLevelValue;
    @Remark("适用性别|1|1|1|1")
    private String gender;
    @Remark("年龄范围|1|1|1|1")
    private String ageRange;
    @Remark("参考下限(男)|1|1|1|1")
    private String refMinMale;
    @Remark("参考下限(女)|1|1|1|1")
    private String refMinFemale;
    @Remark("参考上限(男)|1|1|1|1")
    private String refMaxMale;
    @Remark("参考上限(女)|1|1|1|1")
    private String refMaxFemale;
    @Remark("参考结果|1|1|1|1")
    private String refResult;
    @Remark("检测项目ID|1|1|1|1")
    private String phyItemId;
    @Remark("添加人|1|1|1|1")
    private String firstOperator;
    @Remark("创建时间|1|1|1|1")
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
    public IDiseaseLevel(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getDiseaseLevelName(){
        return diseaseLevelName;
    }

    public void setDiseaseLevelName(String aDiseaseLevelName){
        this.diseaseLevelName = aDiseaseLevelName;
    }

    public String getDiseaseLevelValue(){
        return diseaseLevelValue;
    }

    public void setDiseaseLevelValue(String aDiseaseLevelValue){
        this.diseaseLevelValue = aDiseaseLevelValue;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String aGender){
        this.gender = aGender;
    }

    public String getAgeRange(){
        return ageRange;
    }

    public void setAgeRange(String aAgeRange){
        this.ageRange = aAgeRange;
    }

    public String getRefMinMale(){
        return refMinMale;
    }

    public void setRefMinMale(String aRefMinMale){
        this.refMinMale = aRefMinMale;
    }

    public String getRefMinFemale(){
        return refMinFemale;
    }

    public void setRefMinFemale(String aRefMinFemale){
        this.refMinFemale = aRefMinFemale;
    }

    public String getRefMaxMale(){
        return refMaxMale;
    }

    public void setRefMaxMale(String aRefMaxMale){
        this.refMaxMale = aRefMaxMale;
    }

    public String getRefMaxFemale(){
        return refMaxFemale;
    }

    public void setRefMaxFemale(String aRefMaxFemale){
        this.refMaxFemale = aRefMaxFemale;
    }

    public String getRefResult(){
        return refResult;
    }

    public void setRefResult(String aRefResult){
        this.refResult = aRefResult;
    }

    public String getPhyItemId(){
        return phyItemId;
    }

    public void setPhyItemId(String aPhyItemId){
        this.phyItemId = aPhyItemId;
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