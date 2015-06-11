package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IPhyAdvise;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IAdviseService{

    public int listIPhyAdviseCount(IPhyAdvise iPhyAdvise);
    public List<IPhyAdvise> listIPhyAdvise(IPhyAdvise iPhyAdvise, Pager pager);
    public List<IPhyAdvise> listIPhyAdvise(IPhyAdvise iPhyAdvise);
    public IPhyAdvise saveIPhyAdvise(IPhyAdvise iPhyAdvise);
    public IPhyAdvise getIPhyAdviseByPk(String pk);
    public void deleteIPhyAdviseByPks(String[] pks);
}