package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_phy_advise
 */
public class IPhyAdvise extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("疾病主键|2|1|1|1")
    private String iphydiseaseid;
    @Remark("疾病名称|1|1|1|1")
    private String diseaseName;
    @Remark("合理饮食|1|1|1|1")
    private String adviseDiet;
    @Remark("坚持运动|1|1|1|1")
    private String adviseSport;
    @Remark("生活方式|1|1|1|1")
    private String adviseLifestyle;
    @Remark("跟进检测|1|1|1|1")
    private String adviseCare;
    @Remark("是否删除|2|1|1|1")
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
    public IPhyAdvise(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getIphydiseaseid(){
        return iphydiseaseid;
    }

    public void setIphydiseaseid(String aIPhyDiseaseId){
        this.iphydiseaseid = aIPhyDiseaseId;
    }

    public String getDiseaseName(){
        return diseaseName;
    }

    public void setDiseaseName(String aDiseaseName){
        this.diseaseName = aDiseaseName;
    }

    public String getAdviseDiet(){
        return adviseDiet;
    }

    public void setAdviseDiet(String aAdviseDiet){
        this.adviseDiet = aAdviseDiet;
    }

    public String getAdviseSport(){
        return adviseSport;
    }

    public void setAdviseSport(String aAdviseSport){
        this.adviseSport = aAdviseSport;
    }

    public String getAdviseLifestyle(){
        return adviseLifestyle;
    }

    public void setAdviseLifestyle(String aAdviseLifestyle){
        this.adviseLifestyle = aAdviseLifestyle;
    }

    public String getAdviseCare(){
        return adviseCare;
    }

    public void setAdviseCare(String aAdviseCare){
        this.adviseCare = aAdviseCare;
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