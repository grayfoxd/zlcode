package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.ISysCompay;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IsyscompanyService{

    public int listISysCompayCount(ISysCompay iSysCompay);
    public List<ISysCompay> listISysCompay(ISysCompay iSysCompay, Pager pager);
    public List<ISysCompay> listISysCompay(ISysCompay iSysCompay);
    public ISysCompay saveISysCompay(ISysCompay iSysCompay);
    public ISysCompay getISysCompayByPk(String pk);
    public void deleteISysCompayByPks(String[] pks);
}