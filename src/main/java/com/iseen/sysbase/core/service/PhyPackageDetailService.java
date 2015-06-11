package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IPhyPackageDetail;
import com.iseen.sysbase.core.dao.IIPhyPackageDetailDao;
import com.iseen.sysbase.core.iservice.IPhyPackageDetailService;
import com.centling.common.pages.Pager;
import com.centling.common.util.UtilWork;
import com.iseen.sysbase.common.pack.PhyPackageDetailPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PhyPackageDetailService implements IPhyPackageDetailService{

    @Resource
    private IIPhyPackageDetailDao iPhyPackageDetailDao;

    public int listIPhyPackageDetailCount(IPhyPackageDetail iPhyPackageDetail){
        int count = iPhyPackageDetailDao.findByHqlWhereCount(PhyPackageDetailPack.packIPhyPackageDetailQuery(iPhyPackageDetail));
        return count;
    }

    public List<IPhyPackageDetail> listIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail, Pager pager){
        List<IPhyPackageDetail> list = iPhyPackageDetailDao.findByHqlWherePage(PhyPackageDetailPack.packIPhyPackageDetailQuery(iPhyPackageDetail), pager);
        return list;
    }

    public List<IPhyPackageDetail> listIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail){
        List<IPhyPackageDetail> list = iPhyPackageDetailDao.findByHqlWhere(PhyPackageDetailPack.packIPhyPackageDetailQuery(iPhyPackageDetail));
        return list;
    }

    public IPhyPackageDetail saveIPhyPackageDetail(IPhyPackageDetail iPhyPackageDetail){
        IPhyPackageDetail temp = (IPhyPackageDetail)iPhyPackageDetailDao.save(iPhyPackageDetail);
        return temp;
    }

    public IPhyPackageDetail getIPhyPackageDetailByPk(String pk){
        IPhyPackageDetail iPhyPackageDetail = (IPhyPackageDetail)iPhyPackageDetailDao.getByPK(pk);
        return iPhyPackageDetail;
    }

    public void deleteIPhyPackageDetailByPks(String[] pks, String empId){
        for (String pk : pks) {
            IPhyPackageDetail iPhyPackageDetail = iPhyPackageDetailDao.getByPK(pk);
            iPhyPackageDetail.setDr("Y");
            iPhyPackageDetail.setLastOperator(empId);
            iPhyPackageDetail.setLastOperatorTime(UtilWork.getNowTime());
            iPhyPackageDetailDao.save(iPhyPackageDetail);
        }
    }
    
    public void deleteIPhyPackageDetailByPks(List<IPhyPackageDetail> detailList, String empId){
        for (IPhyPackageDetail detailInfo : detailList) {
        	detailInfo.setDr("Y");
        	detailInfo.setLastOperator(empId);
        	detailInfo.setLastOperatorTime(UtilWork.getNowTime());
            iPhyPackageDetailDao.save(detailInfo);
        }
    }
    
    public void deleteIPhyPackageDetailByPackagePks(String[] packagePks, String empId){
    	for(String packagePk: packagePks){
    		List<IPhyPackageDetail> list = getIPhyPackageDetailsByPackageId(packagePk);
    		deleteIPhyPackageDetailByPks(list, empId);
    	}
    }
    
    public List<IPhyPackageDetail> getIPhyPackageDetailsByPackageId(String packagePk){
    	List<IPhyPackageDetail> list = iPhyPackageDetailDao.findByHqlWhere(PhyPackageDetailPack.packIPhyPackageDetailItemsQuery(packagePk));
        return list;
    }
}