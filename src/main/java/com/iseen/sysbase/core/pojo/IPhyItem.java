package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_phy_item
 */
public class IPhyItem extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("项目编号|1|1|1|1")
    private String itemCode;
    @Remark("项目名称|1|1|1|1")
    private String itemName;
    @Remark("适用性别|1|1|1|1")
    private Integer gender;
    @Remark("顺序|1|1|1|1")
    private Integer displaySequence;
    @Remark("检索代码|1|1|1|1")
    private String retrieveCode;
    @Remark("上级结点|1|1|1|1")
    private String parentId;
    @Remark("是否叶子结点|1|1|1|1")
    private String isLeaf;
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
    public IPhyItem(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getItemCode(){
        return itemCode;
    }

    public void setItemCode(String aItemCode){
        this.itemCode = aItemCode;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String aItemName){
        this.itemName = aItemName;
    }

    public Integer getGender(){
        return gender;
    }

    public void setGender(Integer aGender){
        this.gender = aGender;
    }

    public Integer getDisplaySequence(){
        return displaySequence;
    }

    public void setDisplaySequence(Integer aDisplaySequence){
        this.displaySequence = aDisplaySequence;
    }

    public String getRetrieveCode(){
        return retrieveCode;
    }

    public void setRetrieveCode(String aRetrieveCode){
        this.retrieveCode = aRetrieveCode;
    }

    public String getParentId(){
        return parentId;
    }

    public void setParentId(String aParentId){
        this.parentId = aParentId;
    }

    public String getIsLeaf(){
        return isLeaf;
    }

    public void setIsLeaf(String aIsLeaf){
        this.isLeaf = aIsLeaf;
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