package com.iseen.member.core.service;

import com.iseen.member.core.pojo.IServiceInfo;
import com.iseen.member.core.dao.IIServiceInfoDao;
import com.iseen.member.core.iservice.IContractService;
import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.ContractPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService{

    @Resource
    private IIServiceInfoDao iServiceInfoDao;

    public int listIServiceInfoCount(IServiceInfo iServiceInfo){
        int count = iServiceInfoDao.findByHqlWhereCount(ContractPack.packIServiceInfoQuery(iServiceInfo));
        return count;
    }

    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo, Pager pager){
        List<IServiceInfo> list = iServiceInfoDao.findByHqlWherePage(ContractPack.packIServiceInfoQuery(iServiceInfo), pager);
        return list;
    }

    public List<IServiceInfo> listIServiceInfo(IServiceInfo iServiceInfo){
        List<IServiceInfo> list = iServiceInfoDao.findByHqlWhere(ContractPack.packIServiceInfoQuery(iServiceInfo));
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
}