package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IDiseaseLevel;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IDiseaseLevelService{

    public int listIDiseaseLevelCount(IDiseaseLevel iDiseaseLevel);
    public List<IDiseaseLevel> listIDiseaseLevel(IDiseaseLevel iDiseaseLevel, Pager pager);
    public List<IDiseaseLevel> listIDiseaseLevel(IDiseaseLevel iDiseaseLevel);
    public IDiseaseLevel saveIDiseaseLevel(IDiseaseLevel iDiseaseLevel);
    public IDiseaseLevel getIDiseaseLevelByPk(String pk);
    public void deleteIDiseaseLevelByPks(String[] pks, String empId);
    public int getIDiseaseLevelListCount(IDiseaseLevel iDiseaseLevel);
    public List<IDiseaseLevel> getDiseaseLevelList(IDiseaseLevel iDiseaseLevel, Pager pager);
}