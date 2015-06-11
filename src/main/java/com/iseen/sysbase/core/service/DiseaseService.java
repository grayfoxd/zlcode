package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IPhyDisease;
import com.iseen.sysbase.core.dao.IIPhyDiseaseDao;
import com.iseen.sysbase.core.iservice.IDiseaseService;
import com.centling.common.pages.Pager;
import com.iseen.sysbase.common.pack.DiseasePack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService implements IDiseaseService{

    @Resource
    private IIPhyDiseaseDao iPhyDiseaseDao;

    public int listIPhyDiseaseCount(IPhyDisease iPhyDisease){
        int count = iPhyDiseaseDao.findByHqlWhereCount(DiseasePack.packIPhyDiseaseQuery(iPhyDisease));
        return count;
    }

    public List<IPhyDisease> listIPhyDisease(IPhyDisease iPhyDisease, Pager pager){
        List<IPhyDisease> list = iPhyDiseaseDao.findByHqlWherePage(DiseasePack.packIPhyDiseaseQuery(iPhyDisease), pager);
        return list;
    }

    public List<IPhyDisease> listIPhyDisease(IPhyDisease iPhyDisease){
        List<IPhyDisease> list = iPhyDiseaseDao.findByHqlWhere(DiseasePack.packIPhyDiseaseQuery(iPhyDisease));
        return list;
    }

    public IPhyDisease saveIPhyDisease(IPhyDisease iPhyDisease){
        IPhyDisease temp = (IPhyDisease)iPhyDiseaseDao.save(iPhyDisease);
        return temp;
    }

    public IPhyDisease getIPhyDiseaseByPk(String pk){
        IPhyDisease iPhyDisease = (IPhyDisease)iPhyDiseaseDao.getByPK(pk);
        return iPhyDisease;
    }

    public void deleteIPhyDiseaseByPks(String[] pks){
        for (String pk : pks) {
            IPhyDisease iPhyDisease = iPhyDiseaseDao.getByPK(pk);
            iPhyDiseaseDao.remove(iPhyDisease);
        }
    }
}