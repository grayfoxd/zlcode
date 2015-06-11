package com.iseen.archives.core.service;

import com.iseen.archives.core.pojo.IArchivesStart;
import com.iseen.archives.core.dao.IIArchivesStartDao;
import com.iseen.archives.core.iservice.IIarchivesallService;
import com.centling.common.pages.Pager;
import com.iseen.archives.common.pack.IarchivesallPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class IarchivesallService implements IIarchivesallService{

    @Resource
    private IIArchivesStartDao iArchivesStartDao;

    public int listIArchivesStartCount(IArchivesStart iArchivesStart){
        int count = iArchivesStartDao.findByHqlWhereCount(IarchivesallPack.packIArchivesStartQuery(iArchivesStart));
        return count;
    }

    public List<IArchivesStart> listIArchivesStart(IArchivesStart iArchivesStart, Pager pager){
        List<IArchivesStart> list = iArchivesStartDao.findByHqlWherePage(IarchivesallPack.packIArchivesStartQuery(iArchivesStart), pager);
        return list;
    }

    public List<IArchivesStart> listIArchivesStart(IArchivesStart iArchivesStart){
        List<IArchivesStart> list = iArchivesStartDao.findByHqlWhere(IarchivesallPack.packIArchivesStartQuery(iArchivesStart));
        return list;
    }

    public IArchivesStart saveIArchivesStart(IArchivesStart iArchivesStart){
        IArchivesStart temp = (IArchivesStart)iArchivesStartDao.save(iArchivesStart);
        return temp;
    }

    public IArchivesStart getIArchivesStartByPk(String pk){
        IArchivesStart iArchivesStart = (IArchivesStart)iArchivesStartDao.getByPK(pk);
        return iArchivesStart;
    }

    public void deleteIArchivesStartByPks(String[] pks){
        for (String pk : pks) {
            IArchivesStart iArchivesStart = iArchivesStartDao.getByPK(pk);
            iArchivesStartDao.remove(iArchivesStart);
        }
    }
}