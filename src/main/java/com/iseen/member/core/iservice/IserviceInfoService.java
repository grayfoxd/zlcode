package com.iseen.member.core.iservice;

import com.iseen.member.core.pojo.IServiceInfo;

import java.util.List;

import com.centling.common.pages.Pager;

public interface IserviceInfoService{

    public int listIServiceInfoCount(IServiceInfo iServiceInfo);
    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo, Pager pager);
    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo);
    public List<IServiceInfo> listIServiceInfo(String[] pks);
    public List<IServiceInfo> listIServiceInfo(String pks);
    public IServiceInfo saveIServiceInfo(IServiceInfo iServiceInfo);
    public IServiceInfo getIServiceInfoByPk(String pk);
    public void deleteIServiceInfoByPks(String[] pks);
    public void deleteIServiceInfoByPks(String[] pks, String N);
}