package com.iseen.core.pojo;

import com.centling.common.annotation.Remark;

/**
 * 数据库表名：t_phy_department
 */
public class TPhyDepartment extends com.centling.core.pojo.BaseStringBean implements java.io.Serializable {

    @Remark("科室名称|1|1|1|1")
    private String name;
    @Remark("科室编码|1|1|1|1")
    private String code;
    @Remark("科室类型|1|1|1|1")
    private String type;
    @Remark("顺序号|1|1|1|1")
    private Integer sortOrder;
    @Remark("科室信息|1|1|1|1")
    private String info;
    @Remark("备注资料|1|1|1|1")
    private String remarks;
    @Remark("最后维护人员|2|1|1|1")
    private String operator;
    @Remark("最后维护时间|2|1|1|1")
    private String operatorTime;

    //默认构造方法
    public TPhyDepartment(){
        super();
    }

    //构造方法(手工生成)


    //get和set方法
    public String getName(){
        return name;
    }

    public void setName(String aName){
        this.name = aName;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String aCode){
        this.code = aCode;
    }

    public String getType(){
        return type;
    }

    public void setType(String aType){
        this.type = aType;
    }

    public Integer getSortOrder(){
        return sortOrder;
    }

    public void setSortOrder(Integer aSortOrder){
        this.sortOrder = aSortOrder;
    }

    public String getInfo(){
        return info;
    }

    public void setInfo(String aInfo){
        this.info = aInfo;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String aRemarks){
        this.remarks = aRemarks;
    }

    public String getOperator(){
        return operator;
    }

    public void setOperator(String aOperator){
        this.operator = aOperator;
    }

    public String getOperatorTime(){
        return operatorTime;
    }

    public void setOperatorTime(String aOperatorTime){
        this.operatorTime = aOperatorTime;
    }

}