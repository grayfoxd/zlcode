package com.iseen.member.core.iservice;

import java.util.List;

import com.centling.common.pages.Pager;
import com.iseen.member.core.pojo.IServiceDetail;
import com.iseen.member.core.pojo.IServicePackage;

public interface IServicepackageService{

    public int listIServicePackageCount(IServicePackage iServicePackage);
    public List<IServicePackage> listIServicePackage(IServicePackage iServicePackage, Pager pager);
    public List<IServicePackage> listIServicePackage(IServicePackage iServicePackage);
    public IServicePackage saveIServicePackage(IServicePackage iServicePackage);
    public IServicePackage getIServicePackageByPk(String pk);
    public void deleteIServicePackageByPks(String[] pks);
    public void saveServicePackageAndDetail(IServicePackage iServicePackage, String[] serviceInfoids);
    public List<IServiceDetail> servicedetail(String iServicePackagepkpk);
}