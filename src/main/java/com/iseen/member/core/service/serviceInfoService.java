package com.iseen.member.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.serviceInfoPack;
import com.iseen.member.core.dao.IIServiceInfoDao;
import com.iseen.member.core.iservice.IserviceInfoService;
import com.iseen.member.core.pojo.IServiceInfo;

@Service
public class serviceInfoService implements IserviceInfoService{

    @Resource
    private IIServiceInfoDao iServiceInfoDao;

    public int listIServiceInfoCount(IServiceInfo iServiceInfo){
        int count = iServiceInfoDao.findByHqlWhereCount(serviceInfoPack.packIServiceInfoQuery(iServiceInfo));
        return count;
    }

    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo, Pager pager){
        List<IServiceInfo> list = iServiceInfoDao.findByHqlWherePage(serviceInfoPack.packIServiceInfoQuery(iServiceInfo), pager);
        return list;
    }

    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo){
        List<IServiceInfo> list = iServiceInfoDao.findByHqlWhere(serviceInfoPack.packIServiceInfoQuery(iServiceInfo));
        return list;
    }

    public IServiceInfo saveIServiceInfo(IServiceInfo iServiceInfo){
        IServiceInfo temp = (IServiceInfo)iServiceInfoDao.save(iServiceInfo);
        return temp;
    }

    public IServiceInfo getIServiceInfoByPk(String pk){
        IServiceInfo iServiceInfo = (IServiceInfo)iServiceInfoDao.getByPK(pk);
        return iServiceInfo;
    }

    public void deleteIServiceInfoByPks(String[] pks){
        for (String pk : pks) {
            IServiceInfo iServiceInfo = iServiceInfoDao.getByPK(pk);
            iServiceInfoDao.remove(iServiceInfo);
        }
    }
    
	public void deleteIServiceInfoByPks(String[] pks, String N) {
		for (String pk : pks) {
			IServiceInfo iServiceInfo = iServiceInfoDao.getByPK(pk);
			iServiceInfo.setDr("Y");
			iServiceInfoDao.save(iServiceInfo);
		}
	}

	public List<IServiceInfo> listIServiceInfo(String pks) {
		// TODO Auto-generated method stub
		List<IServiceInfo> list=iServiceInfoDao.findByHqlWhere(serviceInfoPack.packQuerypks(pks));
		return list;
	}

	public List<IServiceInfo> listIServiceInfo(String[] pks) {
		// TODO Auto-generated method stub
		return null;
	}
	
}