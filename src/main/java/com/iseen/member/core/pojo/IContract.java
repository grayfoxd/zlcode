package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_contract
 */
public class IContract extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("合同编码|1|1|1|1")
    private String contractCode;
    @Remark("合同名称|1|1|1|1")
    private String contractName;
    @Remark("期限类型|1|1|1|1")
    private String contractLimitType;
    @Remark("合同状态|1|1|1|1")
    private String contractStatus;
    @Remark("合同类型|1|1|1|1")
    private String contractTypeId;
    @Remark("开始日期|1|1|1|1")
    private String contractBegindate;
    @Remark("结束日期|1|1|1|1")
    private String contractEnddate;
    @Remark("合同内容|1|1|1|1")
    private String contractContent;
    @Remark("附件地址|1|1|1|1")
    private String contractFile;
    @Remark("会员ID|1|1|1|1")
    private String memberId;
    @Remark("套餐类型|1|1|1|1")
    private String servicePackageId;
    @Remark("合同金额|1|1|1|1")
    private String contractPrice;
    @Remark("签订日期|1|1|1|1")
    private String signedDate;
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
    public IContract(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getContractCode(){
        return contractCode;
    }

    public void setContractCode(String aContractCode){
        this.contractCode = aContractCode;
    }

    public String getContractName(){
        return contractName;
    }

    public void setContractName(String aContractName){
        this.contractName = aContractName;
    }

    public String getContractLimitType(){
        return contractLimitType;
    }

    public void setContractLimitType(String aContractLimitType){
        this.contractLimitType = aContractLimitType;
    }

    public String getContractStatus(){
        return contractStatus;
    }

    public void setContractStatus(String aContractStatus){
        this.contractStatus = aContractStatus;
    }

    public String getContractTypeId(){
        return contractTypeId;
    }

    public void setContractTypeId(String aContractTypeId){
        this.contractTypeId = aContractTypeId;
    }

    public String getContractBegindate(){
        return contractBegindate;
    }

    public void setContractBegindate(String aContractBegindate){
        this.contractBegindate = aContractBegindate;
    }

    public String getContractEnddate(){
        return contractEnddate;
    }

    public void setContractEnddate(String aContractEnddate){
        this.contractEnddate = aContractEnddate;
    }

    public String getContractContent(){
        return contractContent;
    }

    public void setContractContent(String aContractContent){
        this.contractContent = aContractContent;
    }

    public String getContractFile(){
        return contractFile;
    }

    public void setContractFile(String aContractFile){
        this.contractFile = aContractFile;
    }

    public String getMemberId(){
        return memberId;
    }

    public void setMemberId(String aMemberId){
        this.memberId = aMemberId;
    }

    public String getServicePackageId(){
        return servicePackageId;
    }

    public void setServicePackageId(String aServicePackageId){
        this.servicePackageId = aServicePackageId;
    }

    public String getContractPrice(){
        return contractPrice;
    }

    public void setContractPrice(String aContractPrice){
        this.contractPrice = aContractPrice;
    }

    public String getSignedDate(){
        return signedDate;
    }

    public void setSignedDate(String aSignedDate){
        this.signedDate = aSignedDate;
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