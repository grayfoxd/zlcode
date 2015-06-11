package com.iseen.archives.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_archives_disease
 */
public class IArchivesDisease extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员id|1|1|1|1")
    private String memberId;
    @Remark("疾病id|1|1|1|1")
    private String diaeaseId;
    @Remark("添加人|1|1|1|1")
    private String firstOperator;
    @Remark("添加时间|1|1|1|1")
    private String firstOpreatorTime;
    @Remark("最后修改人|1|1|1|1")
    private String lastOperator;
    @Remark("最后修改时间|1|1|1|1")
    private String lastOperatorTime;
    @Remark("备注|1|1|1|1")
    private String memo;
    @Remark("是否删除|1|1|1|1")
    private String dr;

    //默认构造方法
    public IArchivesDisease(){
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

    public String getDiaeaseId(){
        return diaeaseId;
    }

    public void setDiaeaseId(String aDiaeaseId){
        this.diaeaseId = aDiaeaseId;
    }

    public String getFirstOperator(){
        return firstOperator;
    }

    public void setFirstOperator(String aFirstOperator){
        this.firstOperator = aFirstOperator;
    }

    public String getFirstOpreatorTime(){
        return firstOpreatorTime;
    }

    public void setFirstOpreatorTime(String aFirstOpreatorTime){
        this.firstOpreatorTime = aFirstOpreatorTime;
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