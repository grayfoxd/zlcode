package com.iseen.archives.core.iservice;

import com.iseen.archives.core.pojo.IArchivesStart;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IIarchivesallService{

    public int listIArchivesStartCount(IArchivesStart iArchivesStart);
    public List<IArchivesStart> listIArchivesStart(IArchivesStart iArchivesStart, Pager pager);
    public List<IArchivesStart> listIArchivesStart(IArchivesStart iArchivesStart);
    public IArchivesStart saveIArchivesStart(IArchivesStart iArchivesStart);
    public IArchivesStart getIArchivesStartByPk(String pk);
    public void deleteIArchivesStartByPks(String[] pks);
}