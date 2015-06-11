package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IPhyAdvise;
import com.iseen.sysbase.core.dao.IIPhyAdviseDao;
import com.iseen.sysbase.core.iservice.IAdviseService;
import com.centling.common.pages.Pager;
import com.iseen.sysbase.common.pack.AdvisePack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdviseService implements IAdviseService{

    @Resource
    private IIPhyAdviseDao iPhyAdviseDao;

    public int listIPhyAdviseCount(IPhyAdvise iPhyAdvise){
        int count = iPhyAdviseDao.findByHqlWhereCount(AdvisePack.packIPhyAdviseQuery(iPhyAdvise));
        return count;
    }

    public List<IPhyAdvise> listIPhyAdvise(IPhyAdvise iPhyAdvise, Pager pager){
        List<IPhyAdvise> list = iPhyAdviseDao.findByHqlWherePage(AdvisePack.packIPhyAdviseQuery(iPhyAdvise), pager);
        return list;
    }

    public List<IPhyAdvise> listIPhyAdvise(IPhyAdvise iPhyAdvise){
        List<IPhyAdvise> list = iPhyAdviseDao.findByHqlWhere(AdvisePack.packIPhyAdviseQuery(iPhyAdvise));
        return list;
    }

    public IPhyAdvise saveIPhyAdvise(IPhyAdvise iPhyAdvise){
        IPhyAdvise temp = (IPhyAdvise)iPhyAdviseDao.save(iPhyAdvise);
        return temp;
    }

    public IPhyAdvise getIPhyAdviseByPk(String pk){
        IPhyAdvise iPhyAdvise = (IPhyAdvise)iPhyAdviseDao.getByPK(pk);
        return iPhyAdvise;
    }

    public void deleteIPhyAdviseByPks(String[] pks){
        for (String pk : pks) {
            IPhyAdvise iPhyAdvise = iPhyAdviseDao.getByPK(pk);
            iPhyAdviseDao.remove(iPhyAdvise);
        }
    }
}