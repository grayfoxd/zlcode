package com.iseen.archives.core.iservice;

import com.iseen.archives.core.pojo.IArchives;

import java.util.List;

import com.centling.common.pages.Pager;

public interface IIarchivesService{

    public int listIArchivesCount(IArchives iArchives);
    public List<IArchives> listIArchives(IArchives iArchives, Pager pager);
    public List<IArchives> listIArchives(IArchives iArchives);
    public IArchives saveIArchives(IArchives iArchives);
    public IArchives getIArchivesByPk(String pk);
    public void deleteIArchivesByPks(String[] pks);
	public void deleteIArchivesByPks(String[] pks, String N);
}