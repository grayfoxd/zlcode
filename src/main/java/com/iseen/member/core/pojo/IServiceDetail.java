package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_service_detail
 */
public class IServiceDetail extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("套餐主键ID |1|1|1|1")
    private String iservicepackageid;
    @Remark("服务项目主键|1|1|1|1")
    private String iserviceinfoid;
    @Remark("添加人|1|1|1|1")
    private String firstOperator;
    @Remark("添加时间|1|1|1|1")
    private String firstOperatorTime;
    @Remark("最后添加人|1|1|1|1")
    private String lastOperator;
    @Remark("备注|1|1|1|1")
    private String memo;
    @Remark("是否删除|2|1|1|1")
    private String dr;

    //默认构造方法
    public IServiceDetail(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getIservicepackageid(){
        return iservicepackageid;
    }

    public void setIservicepackageid(String aIServicePackageId){
        this.iservicepackageid = aIServicePackageId;
    }

    public String getIserviceinfoid(){
        return iserviceinfoid;
    }

    public void setIserviceinfoid(String aIServiceInfoId){
        this.iserviceinfoid = aIServiceInfoId;
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