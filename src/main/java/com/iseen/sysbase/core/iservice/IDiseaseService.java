package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IPhyDisease;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IDiseaseService{

    public int listIPhyDiseaseCount(IPhyDisease iPhyDisease);
    public List<IPhyDisease> listIPhyDisease(IPhyDisease iPhyDisease, Pager pager);
    public List<IPhyDisease> listIPhyDisease(IPhyDisease iPhyDisease);
    public IPhyDisease saveIPhyDisease(IPhyDisease iPhyDisease);
    public IPhyDisease getIPhyDiseaseByPk(String pk);
    public void deleteIPhyDiseaseByPks(String[] pks);
}