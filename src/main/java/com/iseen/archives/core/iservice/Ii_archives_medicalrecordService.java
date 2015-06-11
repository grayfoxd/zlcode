package com.iseen.archives.core.iservice;

import com.iseen.archives.core.pojo.IArchivesMedicalrecord;
import com.iseen.member.core.pojo.IMember;

import java.util.List;

import com.centling.common.pages.Pager;

public interface Ii_archives_medicalrecordService{

    public int listIArchivesMedicalrecordCount(IArchivesMedicalrecord iArchivesMedicalrecord);
    public List<IArchivesMedicalrecord> listIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord, Pager pager);
    public List<IArchivesMedicalrecord> listIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord);
    public IArchivesMedicalrecord saveIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord);
    public IArchivesMedicalrecord getIArchivesMedicalrecordByPk(String pk);
    public void deleteIArchivesMedicalrecordByPks(String[] pks);
    public int listIMemberCount(IMember iMember);
    public List<IMember> listIMember(IMember iMember, Pager pager);
    public List<IMember> listIMember(IMember iMember);
    public IMember saveIMember(IMember iMember);
    public IMember getIMemberByPk(String pk);
    public void deleteIMemberByPks(String[] pks);
	public void deleteIArchivesMedicalrecordByPks(String[] pks, String N);
}