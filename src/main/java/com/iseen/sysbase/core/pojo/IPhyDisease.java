package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_phy_disease
 */
public class IPhyDisease extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("诊断名称|1|1|1|1")
    private String diseaseName;
    @Remark("解说|1|1|1|1")
    private String diseaseComment;
    @Remark("临床意义|1|1|1|1")
    private String diseaseClinical;
    @Remark("建议|1|1|1|1")
    private String diseaseAdvise;
    @Remark("条件|1|1|1|1")
    private String conditions;
    @Remark("条件细节|1|1|1|1")
    private String conditionsDetail;
    @Remark("是否删除|1|1|1|1")
    private String dr;
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

    //默认构造方法
    public IPhyDisease(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getDiseaseName(){
        return diseaseName;
    }

    public void setDiseaseName(String aDiseaseName){
        this.diseaseName = aDiseaseName;
    }

    public String getDiseaseComment(){
        return diseaseComment;
    }

    public void setDiseaseComment(String aDiseaseComment){
        this.diseaseComment = aDiseaseComment;
    }

    public String getDiseaseClinical(){
        return diseaseClinical;
    }

    public void setDiseaseClinical(String aDiseaseClinical){
        this.diseaseClinical = aDiseaseClinical;
    }

    public String getDiseaseAdvise(){
        return diseaseAdvise;
    }

    public void setDiseaseAdvise(String aDiseaseAdvise){
        this.diseaseAdvise = aDiseaseAdvise;
    }

    public String getConditions(){
        return conditions;
    }

    public void setConditions(String aConditions){
        this.conditions = aConditions;
    }

    public String getConditionsDetail(){
        return conditionsDetail;
    }

    public void setConditionsDetail(String aConditionsDetail){
        this.conditionsDetail = aConditionsDetail;
    }

    public String getDr(){
        return dr;
    }

    public void setDr(String aDr){
        this.dr = aDr;
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

}