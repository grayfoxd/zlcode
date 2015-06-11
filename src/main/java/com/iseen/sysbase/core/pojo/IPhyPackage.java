package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_phy_package
 */
public class IPhyPackage extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("套餐名称|1|1|1|1")
    private String packageName;
    @Remark("市场价格|1|1|1|1")
    private String marketPrice;
    @Remark("实际价格|1|1|1|1")
    private String actualPrice;
    @Remark("适用性别|1|1|1|1")
    private String gender;
    @Remark("状态|1|1|1|1")
    private String status;
    @Remark("公司ID|1|1|1|1")
    private String compnayId;
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
    public IPhyPackage(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getPackageName(){
        return packageName;
    }

    public void setPackageName(String aPackageName){
        this.packageName = aPackageName;
    }

    public String getMarketPrice(){
        return marketPrice;
    }

    public void setMarketPrice(String aMarketPrice){
        this.marketPrice = aMarketPrice;
    }

    public String getActualPrice(){
        return actualPrice;
    }

    public void setActualPrice(String aActualPrice){
        this.actualPrice = aActualPrice;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String aGender){
        this.gender = aGender;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String aStatus){
        this.status = aStatus;
    }

    public String getCompnayId(){
        return compnayId;
    }

    public void setCompnayId(String aCompnayId){
        this.compnayId = aCompnayId;
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