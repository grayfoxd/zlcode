package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IPhyPackage;
import com.iseen.sysbase.core.dao.IIPhyPackageDao;
import com.iseen.sysbase.core.iservice.IPhyPackageService;
import com.centling.common.pages.Pager;
import com.centling.common.util.UtilWork;
import com.centling.core.iservice.IHrmEmployeeService;
import com.iseen.sysbase.common.pack.PhyPackagePack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PhyPackageService implements IPhyPackageService{

    @Resource
    private IIPhyPackageDao iPhyPackageDao;

    public int listIPhyPackageCount(IPhyPackage iPhyPackage){
        int count = iPhyPackageDao.findByHqlWhereCount(PhyPackagePack.packIPhyPackageQuery(iPhyPackage));
        return count;
    }

    public List<IPhyPackage> listIPhyPackage(IPhyPackage iPhyPackage, Pager pager){
        List<IPhyPackage> list = iPhyPackageDao.findByHqlWherePage(PhyPackagePack.packIPhyPackageQuery(iPhyPackage), pager);
        return list;
    }

    public List<IPhyPackage> listIPhyPackage(IPhyPackage iPhyPackage){
        List<IPhyPackage> list = iPhyPackageDao.findByHqlWhere(PhyPackagePack.packIPhyPackageQuery(iPhyPackage));
        return list;
    }

    public IPhyPackage saveIPhyPackage(IPhyPackage iPhyPackage){
        IPhyPackage temp = (IPhyPackage)iPhyPackageDao.save(iPhyPackage);
        return temp;
    }

    public IPhyPackage getIPhyPackageByPk(String pk){
        IPhyPackage iPhyPackage = (IPhyPackage)iPhyPackageDao.getByPK(pk);
        return iPhyPackage;
    }

    public void deleteIPhyPackageByPks(String[] pks, String empId){
        for (String pk : pks) {
            IPhyPackage iPhyPackage = iPhyPackageDao.getByPK(pk);
            iPhyPackage.setDr("Y");
            iPhyPackage.setLastOperator(empId);
            iPhyPackage.setLastOperatorTime(UtilWork.getNowTime());
            iPhyPackageDao.save(iPhyPackage);
        }
    }
}