package com.iseen.archives.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_archives_medicalrecord
 */
public class IArchivesMedicalrecord extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员id|1|1|1|1")
    private String memberId;
    @Remark("医院名称|1|1|1|1")
    private String hospitalName;
    @Remark("诊断日期|1|1|1|1")
    private String diagnoseData;
    @Remark("病历内容|1|1|1|1")
    private String diagnoseContent;
    @Remark("科室|1|1|1|1")
    private String department;
    @Remark("附件上传地址|1|1|1|1")
    private String fileUploadaddress;
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
    public IArchivesMedicalrecord(){
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

    public String getHospitalName(){
        return hospitalName;
    }

    public void setHospitalName(String aHospitalName){
        this.hospitalName = aHospitalName;
    }

    public String getDiagnoseData(){
        return diagnoseData;
    }

    public void setDiagnoseData(String aDiagnoseData){
        this.diagnoseData = aDiagnoseData;
    }

    public String getDiagnoseContent(){
        return diagnoseContent;
    }

    public void setDiagnoseContent(String aDiagnoseContent){
        this.diagnoseContent = aDiagnoseContent;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String aDepartment){
        this.department = aDepartment;
    }

    public String getFileUploadaddress(){
        return fileUploadaddress;
    }

    public void setFileUploadaddress(String aFileUploadaddress){
        this.fileUploadaddress = aFileUploadaddress;
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