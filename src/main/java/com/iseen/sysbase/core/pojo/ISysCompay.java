package com.iseen.sysbase.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_sys_compay
 */
public class ISysCompay extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("省份|1|1|1|1")
    private String provinceCode;
    @Remark("市区|1|1|1|1")
    private String districtCode;
    @Remark("区|1|1|1|1")
    private String companyArea;
    @Remark("公司全名|1|1|1|1")
    private String companyInfoName;
    @Remark("公司简称|1|1|1|1")
    private String companyShortName;
    @Remark("详细地址|1|1|1|1")
    private String companyInfoAdder;
    @Remark("联系人|1|1|1|1")
    private String companyInfoEmployee;
    @Remark("职务|1|1|1|1")
    private String adviseCare;
    @Remark("联系电话|1|1|1|1")
    private String companyInfoPhone;
    @Remark("E-amil|1|1|1|1")
    private String companyInfoEmail;
    @Remark("删除|2|1|1|1")
    private String dr;

    //默认构造方法
    public ISysCompay(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getProvinceCode(){
        return provinceCode;
    }

    public void setProvinceCode(String aProvinceCode){
        this.provinceCode = aProvinceCode;
    }

    public String getDistrictCode(){
        return districtCode;
    }

    public void setDistrictCode(String aDistrictCode){
        this.districtCode = aDistrictCode;
    }

    public String getCompanyArea(){
        return companyArea;
    }

    public void setCompanyArea(String aCompanyArea){
        this.companyArea = aCompanyArea;
    }

    public String getCompanyInfoName(){
        return companyInfoName;
    }

    public void setCompanyInfoName(String aCompanyInfoName){
        this.companyInfoName = aCompanyInfoName;
    }

    public String getCompanyShortName(){
        return companyShortName;
    }

    public void setCompanyShortName(String aCompanyShortName){
        this.companyShortName = aCompanyShortName;
    }

    public String getCompanyInfoAdder(){
        return companyInfoAdder;
    }

    public void setCompanyInfoAdder(String aCompanyInfoAdder){
        this.companyInfoAdder = aCompanyInfoAdder;
    }

    public String getCompanyInfoEmployee(){
        return companyInfoEmployee;
    }

    public void setCompanyInfoEmployee(String aCompanyInfoEmployee){
        this.companyInfoEmployee = aCompanyInfoEmployee;
    }

    public String getAdviseCare(){
        return adviseCare;
    }

    public void setAdviseCare(String aAdviseCare){
        this.adviseCare = aAdviseCare;
    }

    public String getCompanyInfoPhone(){
        return companyInfoPhone;
    }

    public void setCompanyInfoPhone(String aCompanyInfoPhone){
        this.companyInfoPhone = aCompanyInfoPhone;
    }

    public String getCompanyInfoEmail(){
        return companyInfoEmail;
    }

    public void setCompanyInfoEmail(String aCompanyInfoEmail){
        this.companyInfoEmail = aCompanyInfoEmail;
    }

    public String getDr(){
        return dr;
    }

    public void setDr(String aDr){
        this.dr = aDr;
    }

}