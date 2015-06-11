package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.ISysCompay;
import com.iseen.sysbase.core.dao.IISysCompayDao;
import com.iseen.sysbase.core.iservice.IsyscompanyService;
import com.centling.common.pages.Pager;
import com.iseen.sysbase.common.pack.syscompanyPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class syscompanyService implements IsyscompanyService{

    @Resource
    private IISysCompayDao iSysCompayDao;

    public int listISysCompayCount(ISysCompay iSysCompay){
        int count = iSysCompayDao.findByHqlWhereCount(syscompanyPack.packISysCompayQuery(iSysCompay));
        return count;
    }

    public List<ISysCompay> listISysCompay(ISysCompay iSysCompay, Pager pager){
        List<ISysCompay> list = iSysCompayDao.findByHqlWherePage(syscompanyPack.packISysCompayQuery(iSysCompay), pager);
        return list;
    }

    public List<ISysCompay> listISysCompay(ISysCompay iSysCompay){
        List<ISysCompay> list = iSysCompayDao.findByHqlWhere(syscompanyPack.packISysCompayQuery(iSysCompay));
        return list;
    }

    public ISysCompay saveISysCompay(ISysCompay iSysCompay){
        ISysCompay temp = (ISysCompay)iSysCompayDao.save(iSysCompay);
        return temp;
    }

    public ISysCompay getISysCompayByPk(String pk){
        ISysCompay iSysCompay = (ISysCompay)iSysCompayDao.getByPK(pk);
        return iSysCompay;
    }

    public void deleteISysCompayByPks(String[] pks){
        for (String pk : pks) {
            ISysCompay iSysCompay = iSysCompayDao.getByPK(pk);
            iSysCompayDao.remove(iSysCompay);
        }
    }
}