package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IPhyPackageDetail;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IPhyPackageDetailService{

    public int listIPhyPackageDetailCount(IPhyPackageDetail iPhyPackageDetail);
    public List<IPhyPackageDetail> listIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail, Pager pager);
    public List<IPhyPackageDetail> listIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail);
    public IPhyPackageDetail saveIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail);
    public IPhyPackageDetail getIPhyPackageDetailByPk(String pk);
    public void deleteIPhyPackageDetailByPks(String[] pks, String empId);
    public List<IPhyPackageDetail> getIPhyPackageDetailsByPackageId(String packagePk);
    public void deleteIPhyPackageDetailByPackagePks(String[] packagePks, String empId);
    public void deleteIPhyPackageDetailByPks(List<IPhyPackageDetail> detailList, String empId);
}