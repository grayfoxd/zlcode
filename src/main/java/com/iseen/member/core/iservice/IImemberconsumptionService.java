package com.iseen.member.core.iservice;

import com.iseen.member.core.pojo.IMemberConsumption;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IImemberconsumptionService{

    public int listIMemberConsumptionCount(IMemberConsumption iMemberConsumption);
    public List<IMemberConsumption> listIMemberConsumption(IMemberConsumption iMemberConsumption, Pager pager);
    public List<IMemberConsumption> listIMemberConsumption(IMemberConsumption iMemberConsumption);
    public IMemberConsumption saveIMemberConsumption(IMemberConsumption iMemberConsumption);
    public IMemberConsumption getIMemberConsumptionByPk(String pk);
    public void deleteIMemberConsumptionByPks(String[] pks);
}