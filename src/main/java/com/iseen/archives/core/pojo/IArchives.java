package com.iseen.archives.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_archives
 */
public class IArchives extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员id|1|1|1|1")
    private String memberId;
    @Remark("档案类型|1|1|1|1")
    private String archiveType;
    @Remark("档案名称|1|1|1|1")
    private String archiveName;
    @Remark("数据来源|1|1|1|1")
    private String dataFrom;
    @Remark("指标附件上传地址|1|1|1|1")
    private String indicatorUpload;
    @Remark("影像附件上传地址|1|1|1|1")
    private String imageUpload;
    @Remark("附件上传地址|1|1|1|1")
    private String allUpload;
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
    @Remark("是否删除|1|1|1|1")
    private String dr;

    //默认构造方法
    public IArchives(){
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

    public String getArchiveType(){
        return archiveType;
    }

    public void setArchiveType(String aArchiveType){
        this.archiveType = aArchiveType;
    }

    public String getArchiveName(){
        return archiveName;
    }

    public void setArchiveName(String aArchiveName){
        this.archiveName = aArchiveName;
    }

    public String getDataFrom(){
        return dataFrom;
    }

    public void setDataFrom(String aDataFrom){
        this.dataFrom = aDataFrom;
    }

    public String getIndicatorUpload(){
        return indicatorUpload;
    }

    public void setIndicatorUpload(String aIndicatorUpload){
        this.indicatorUpload = aIndicatorUpload;
    }

    public String getImageUpload(){
        return imageUpload;
    }

    public void setImageUpload(String aImageUpload){
        this.imageUpload = aImageUpload;
    }

    public String getAllUpload(){
        return allUpload;
    }

    public void setAllUpload(String aAllUpload){
        this.allUpload = aAllUpload;
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