package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IDiseaseLevel;
import com.iseen.sysbase.core.pojo.IPhyItem;
import com.iseen.sysbase.core.dao.IIDiseaseLevelDao;
import com.iseen.sysbase.core.iservice.IDiseaseLevelService;
import com.centling.common.pages.Pager;
import com.centling.common.util.UtilWork;
import com.iseen.sysbase.common.pack.DiseaseLevelPack;
import com.iseen.sysbase.common.pack.PhyItemPack;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DiseaseLevelService implements IDiseaseLevelService{

    @Resource
    private IIDiseaseLevelDao iDiseaseLevelDao;

    public int listIDiseaseLevelCount(IDiseaseLevel iDiseaseLevel){
        int count = iDiseaseLevelDao.findByHqlWhereCount(DiseaseLevelPack.packIDiseaseLevelQuery(iDiseaseLevel));
        return count;
    }
    
    public int getIDiseaseLevelListCount(IDiseaseLevel iDiseaseLevel){
        int count = iDiseaseLevelDao.findByHqlWhereCount(DiseaseLevelPack.packIDiseaseLevelList(iDiseaseLevel));
        return count;
    }
    
    public List<IDiseaseLevel> getDiseaseLevelList(IDiseaseLevel iDiseaseLevel, Pager pager){
    	List<IDiseaseLevel> list = iDiseaseLevelDao.findByHqlWherePage(DiseaseLevelPack.packIDiseaseLevelList(iDiseaseLevel), pager);
        return list;
    }

    public List<IDiseaseLevel> listIDiseaseLevel(IDiseaseLevel iDiseaseLevel, Pager pager){
        List<IDiseaseLevel> list = iDiseaseLevelDao.findByHqlWherePage(DiseaseLevelPack.packIDiseaseLevelQuery(iDiseaseLevel), pager);
        return list;
    }

    public List<IDiseaseLevel> listIDiseaseLevel(IDiseaseLevel iDiseaseLevel){
        List<IDiseaseLevel> list = iDiseaseLevelDao.findByHqlWhere(DiseaseLevelPack.packIDiseaseLevelQuery(iDiseaseLevel));
        return list;
    }

    public IDiseaseLevel saveIDiseaseLevel(IDiseaseLevel iDiseaseLevel){
        IDiseaseLevel temp = (IDiseaseLevel)iDiseaseLevelDao.save(iDiseaseLevel);
        return temp;
    }

    public IDiseaseLevel getIDiseaseLevelByPk(String pk){
        IDiseaseLevel iDiseaseLevel = (IDiseaseLevel)iDiseaseLevelDao.getByPK(pk);
        return iDiseaseLevel;
    }

    public void deleteIDiseaseLevelByPks(String[] pks, String empid){
        for (String pk : pks) {
            IDiseaseLevel iDiseaseLevel = iDiseaseLevelDao.getByPK(pk);
            iDiseaseLevel.setDr("Y");
            iDiseaseLevel.setLastOperator(empid);
            iDiseaseLevel.setLastOperatorTime(UtilWork.getNowTime());
            iDiseaseLevelDao.save(iDiseaseLevel);
        }
    }
}