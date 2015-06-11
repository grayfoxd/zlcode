package com.iseen.archives.core.service;

import com.iseen.archives.core.pojo.IArchives;
import com.iseen.archives.core.dao.IIArchivesDao;
import com.iseen.archives.core.iservice.IIarchivesService;
import com.centling.common.pages.Pager;
import com.iseen.archives.common.pack.IarchivesPack;
import com.iseen.member.core.pojo.IMember;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class IarchivesService implements IIarchivesService{

    @Resource
    private IIArchivesDao iArchivesDao;

    public int listIArchivesCount(IArchives iArchives){
        int count = iArchivesDao.findByHqlWhereCount(IarchivesPack.packIArchivesQuery(iArchives));
        return count;
    }

    public List<IArchives> listIArchives(IArchives iArchives, Pager pager){
        List<IArchives> list = iArchivesDao.findByHqlWherePage(IarchivesPack.packIArchivesQuery(iArchives), pager);
        return list;
    }

    public List<IArchives> listIArchives(IArchives iArchives){
        List<IArchives> list = iArchivesDao.findByHqlWhere(IarchivesPack.packIArchivesQuery(iArchives));
        return list;
    }

    public IArchives saveIArchives(IArchives iArchives){
        IArchives temp = (IArchives)iArchivesDao.save(iArchives);
        return temp;
    }

    public IArchives getIArchivesByPk(String pk){
        IArchives iArchives = (IArchives)iArchivesDao.getByPK(pk);
        return iArchives;
    }

    public void deleteIArchivesByPks(String[] pks){
        for (String pk : pks) {
            IArchives iArchives = iArchivesDao.getByPK(pk);
            iArchivesDao.remove(iArchives);
        }
    }
    
    public void deleteIArchivesByPks(String[] pks,String N){
        for (String pk : pks) {
            IArchives iArchives = iArchivesDao.getByPK(pk);
            iArchives.setDr("Y");
            iArchivesDao.remove(iArchives);
        }
    }

	public int listIMemberCount(IMember iMember) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public List<IMember> listIMember(IMember iMember, Pager pager) {
		// TODO 自动生成的方法存根
		return null;
	}

	public List<IMember> listIMember(IMember iMember) {
		// TODO 自动生成的方法存根
		return null;
	}

	public IMember saveIMember(IMember iMember) {
		// TODO 自动生成的方法存根
		return null;
	}

	public IMember getIMemberByPk(String pk) {
		// TODO 自动生成的方法存根
		return null;
	}

	public void deleteIMemberByPks(String[] pks) {
		// TODO 自动生成的方法存根
		
	}
}