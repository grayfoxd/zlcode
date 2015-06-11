package com.iseen.member.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：i_member
 */
public class IMember extends com.frame.core.BaseStringBean implements java.io.Serializable {

    @Remark("会员ID|1|1|1|1")
    private String memberId;
    @Remark("会员姓名|1|1|1|1")
    private String memberName;
    @Remark("会员性别|1|1|1|1")
    private String memberSex;
    @Remark("会员年龄|1|1|1|1")
    private Integer memberAge;
    @Remark("出生日期|1|1|1|1")
    private String memberBirthday;
    @Remark("国籍|1|1|1|1")
    private String memberCountry;
    @Remark("出生地|1|1|1|1")
    private String memberBirthplace;
    @Remark("籍贯|1|1|1|1")
    private String memberOriginplace;
    @Remark("民族|1|1|1|1")
    private String memberNation;
    @Remark("身份证号|1|1|1|1")
    private String memberIdcard;
    @Remark("婚姻|1|1|1|1")
    private String memberIsmarry;
    @Remark("住址|1|1|1|1")
    private String memberAddress;
    @Remark("电话|1|1|1|1")
    private String memberPhone;
    @Remark("入会时间|1|1|1|1")
    private String memberJointime;
    @Remark("血型|1|1|1|1")
    private String bloodType;
    @Remark("rh|1|1|1|1")
    private String rh;
    @Remark("公司ID|1|1|1|1")
    private String companyId;
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
    public IMember(){
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

    public String getMemberName(){
        return memberName;
    }

    public void setMemberName(String aMemberName){
        this.memberName = aMemberName;
    }

    public String getMemberSex(){
        return memberSex;
    }

    public void setMemberSex(String aMemberSex){
        this.memberSex = aMemberSex;
    }

    public Integer getMemberAge(){
        return memberAge;
    }

    public void setMemberAge(Integer aMemberAge){
        this.memberAge = aMemberAge;
    }

    public String getMemberBirthday(){
        return memberBirthday;
    }

    public void setMemberBirthday(String aMemberBirthday){
        this.memberBirthday = aMemberBirthday;
    }

    public String getMemberCountry(){
        return memberCountry;
    }

    public void setMemberCountry(String aMemberCountry){
        this.memberCountry = aMemberCountry;
    }

    public String getMemberBirthplace(){
        return memberBirthplace;
    }

    public void setMemberBirthplace(String aMemberBirthplace){
        this.memberBirthplace = aMemberBirthplace;
    }

    public String getMemberOriginplace(){
        return memberOriginplace;
    }

    public void setMemberOriginplace(String aMemberOriginplace){
        this.memberOriginplace = aMemberOriginplace;
    }

    public String getMemberNation(){
        return memberNation;
    }

    public void setMemberNation(String aMemberNation){
        this.memberNation = aMemberNation;
    }

    public String getMemberIdcard(){
        return memberIdcard;
    }

    public void setMemberIdcard(String aMemberIdcard){
        this.memberIdcard = aMemberIdcard;
    }

    public String getMemberIsmarry(){
        return memberIsmarry;
    }

    public void setMemberIsmarry(String aMemberIsmarry){
        this.memberIsmarry = aMemberIsmarry;
    }

    public String getMemberAddress(){
        return memberAddress;
    }

    public void setMemberAddress(String aMemberAddress){
        this.memberAddress = aMemberAddress;
    }

    public String getMemberPhone(){
        return memberPhone;
    }

    public void setMemberPhone(String aMemberPhone){
        this.memberPhone = aMemberPhone;
    }

    public String getMemberJointime(){
        return memberJointime;
    }

    public void setMemberJointime(String aMemberJointime){
        this.memberJointime = aMemberJointime;
    }

    public String getBloodType(){
        return bloodType;
    }

    public void setBloodType(String aBloodType){
        this.bloodType = aBloodType;
    }

    public String getRh(){
        return rh;
    }

    public void setRh(String aRh){
        this.rh = aRh;
    }

    public String getCompanyId(){
        return companyId;
    }

    public void setCompanyId(String aCompanyId){
        this.companyId = aCompanyId;
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