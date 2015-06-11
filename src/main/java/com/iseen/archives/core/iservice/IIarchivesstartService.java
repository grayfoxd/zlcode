package com.iseen.archives.core.iservice;

import com.iseen.archives.core.pojo.IArchivesDrugallergy;
import com.iseen.member.core.pojo.IMember;
import com.iseen.archives.core.pojo.IArchivesDisease;

import java.util.List;

import com.centling.common.pages.Pager;

public interface IIarchivesstartService{

    public int listIArchivesDrugallergyCount(IArchivesDrugallergy iArchivesDrugallergy);
    public List<IArchivesDrugallergy> listIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy, Pager pager);
    public List<IArchivesDrugallergy> listIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy);
    public IArchivesDrugallergy saveIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy);
    public IArchivesDrugallergy getIArchivesDrugallergyByPk(String pk);
    public void deleteIArchivesDrugallergyByPks(String[] pks);
    public int listIMemberCount(IMember iMember);
    public List<IMember> listIMember(IMember iMember, Pager pager);
    public List<IMember> listIMember(IMember iMember);
    public IMember saveIMember(IMember iMember);
    public IMember getIMemberByPk(String pk);
    public void deleteIMemberByPks(String[] pks);
    public int listIArchivesDiseaseCount(IArchivesDisease iArchivesDisease);
    public List<IArchivesDisease> listIArchivesDisease(IArchivesDisease iArchivesDisease, Pager pager);
    public List<IArchivesDisease> listIArchivesDisease(IArchivesDisease iArchivesDisease);
    public IArchivesDisease saveIArchivesDisease(IArchivesDisease iArchivesDisease);
    public IArchivesDisease getIArchivesDiseaseByPk(String pk);
    public void deleteIArchivesDiseaseByPks(String[] pks);
	public void deleteIMemberByPks(String[] pks, String N);
}