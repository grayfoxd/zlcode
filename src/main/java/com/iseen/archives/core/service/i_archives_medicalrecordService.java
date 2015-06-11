package com.iseen.archives.core.service;

import com.iseen.archives.core.pojo.IArchivesMedicalrecord;
import com.iseen.member.core.pojo.IMember;
import com.iseen.archives.core.dao.IIArchivesMedicalrecordDao;
import com.iseen.member.core.dao.IIMemberDao;
import com.iseen.archives.core.iservice.Ii_archives_medicalrecordService;
import com.centling.common.pages.Pager;
import com.iseen.archives.common.pack.i_archives_medicalrecordPack;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class i_archives_medicalrecordService implements Ii_archives_medicalrecordService{

    @Resource
    private IIArchivesMedicalrecordDao iArchivesMedicalrecordDao;

    @Resource
    private IIMemberDao iMemberDao;

    public int listIArchivesMedicalrecordCount(IArchivesMedicalrecord iArchivesMedicalrecord){
        int count = iArchivesMedicalrecordDao.findByHqlWhereCount(i_archives_medicalrecordPack.packIArchivesMedicalrecordQuery(iArchivesMedicalrecord));
        return count;
    }

    public List<IArchivesMedicalrecord> listIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord, Pager pager){
        List<IArchivesMedicalrecord> list = iArchivesMedicalrecordDao.findByHqlWherePage(i_archives_medicalrecordPack.packIArchivesMedicalrecordQuery(iArchivesMedicalrecord), pager);
        return list;
    }

    public List<IArchivesMedicalrecord> listIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord){
        List<IArchivesMedicalrecord> list = iArchivesMedicalrecordDao.findByHqlWhere(i_archives_medicalrecordPack.packIArchivesMedicalrecordQuery(iArchivesMedicalrecord));
        return list;
    }

    public IArchivesMedicalrecord saveIArchivesMedicalrecord(IArchivesMedicalrecord iArchivesMedicalrecord){
        IArchivesMedicalrecord temp = (IArchivesMedicalrecord)iArchivesMedicalrecordDao.save(iArchivesMedicalrecord);
        return temp;
    }

    public IArchivesMedicalrecord getIArchivesMedicalrecordByPk(String pk){
        IArchivesMedicalrecord iArchivesMedicalrecord = (IArchivesMedicalrecord)iArchivesMedicalrecordDao.getByPK(pk);
        return iArchivesMedicalrecord;
    }

    public void deleteIArchivesMedicalrecordByPks(String[] pks){
        for (String pk : pks) {
            IArchivesMedicalrecord iArchivesMedicalrecord = iArchivesMedicalrecordDao.getByPK(pk);
            iArchivesMedicalrecordDao.remove(iArchivesMedicalrecord);
        }
    }
    
    public void deleteIArchivesMedicalrecordByPks(String[] pks,String N){
        for (String pk : pks) {
            IArchivesMedicalrecord iArchivesMedicalrecord = iArchivesMedicalrecordDao.getByPK(pk);
            iArchivesMedicalrecord.setDr("Y");
            iArchivesMedicalrecordDao.remove(iArchivesMedicalrecord);
        }
    }
    public int listIMemberCount(IMember iMember){
        int count = iMemberDao.findByHqlWhereCount(i_archives_medicalrecordPack.packIMemberQuery(iMember));
        return count;
    }

    public List<IMember> listIMember(IMember iMember, Pager pager){
        List<IMember> list = iMemberDao.findByHqlWherePage(i_archives_medicalrecordPack.packIMemberQuery(iMember), pager);
        return list;
    }

    public List<IMember> listIMember(IMember iMember){
        List<IMember> list = iMemberDao.findByHqlWhere(i_archives_medicalrecordPack.packIMemberQuery(iMember));
        return list;
    }

    public IMember saveIMember(IMember iMember){
        IMember temp = (IMember)iMemberDao.save(iMember);
        return temp;
    }

    public IMember getIMemberByPk(String pk){
        IMember iMember = (IMember)iMemberDao.getByPK(pk);
        return iMember;
    }

    public void deleteIMemberByPks(String[] pks){
        for (String pk : pks) {
            IMember iMember = iMemberDao.getByPK(pk);
            iMemberDao.remove(iMember);
        }
    }
}