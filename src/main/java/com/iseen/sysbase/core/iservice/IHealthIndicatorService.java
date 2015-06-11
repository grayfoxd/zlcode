package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IHealthIndicator;
import com.iseen.sysbase.core.pojo.IPhyItem;

import java.util.List;
import com.centling.common.pages.Pager;

public interface IHealthIndicatorService{

    public int listIHealthIndicatorCount(IHealthIndicator iHealthIndicator);
    public List<IHealthIndicator> listIHealthIndicator(IHealthIndicator iHealthIndicator, Pager pager);
    public List<IHealthIndicator> listIHealthIndicator(IHealthIndicator iHealthIndicator);
    public IHealthIndicator saveIHealthIndicator(IHealthIndicator iHealthIndicator);
    public IHealthIndicator getIHealthIndicatorByPk(String pk);
    public void deleteIHealthIndicatorByPks(String[] pks, String empId);
    public int getIHealthIndicatorListCount(IHealthIndicator iHealthIndicator);
    public List<IHealthIndicator> getHealthIndicatorList(IHealthIndicator iHealthIndicator, Pager pager);
    public List<IHealthIndicator> getIHealthIndicatorListByUpCode(String code);
    public int getHealthIndicatorListByUpCodeCount(String code);
    public int getHealthIndicatorByNameAndParentId(String name,String parentId, String PK);
    public List<IHealthIndicator> getHealthIndicatorListByPK(String pk);
}