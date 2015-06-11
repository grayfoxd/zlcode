package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IPhyPackage;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IPhyPackageService{

    public int listIPhyPackageCount(IPhyPackage iPhyPackage);
    public List<IPhyPackage> listIPhyPackage(IPhyPackage iPhyPackage, Pager pager);
    public List<IPhyPackage> listIPhyPackage(IPhyPackage iPhyPackage);
    public IPhyPackage saveIPhyPackage(IPhyPackage iPhyPackage);
    public IPhyPackage getIPhyPackageByPk(String pk);
    public void deleteIPhyPackageByPks(String[] pks, String empId);
}