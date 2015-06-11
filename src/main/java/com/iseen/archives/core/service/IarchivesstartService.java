package com.iseen.archives.core.service;

import com.iseen.archives.core.pojo.IArchivesDrugallergy;
import com.iseen.member.core.pojo.IMember;
import com.iseen.archives.core.pojo.IArchivesDisease;
import com.iseen.archives.core.dao.IIArchivesDrugallergyDao;
import com.iseen.member.core.dao.IIMemberDao;
import com.iseen.archives.core.dao.IIArchivesDiseaseDao;
import com.iseen.archives.core.iservice.IIarchivesstartService;
import com.centling.common.pages.Pager;
import com.iseen.archives.common.pack.IarchivesstartPack;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class IarchivesstartService implements IIarchivesstartService{

    @Resource
    private IIArchivesDrugallergyDao iArchivesDrugallergyDao;

    @Resource
    private IIMemberDao iMemberDao;

    @Resource
    private IIArchivesDiseaseDao iArchivesDiseaseDao;

    public int listIArchivesDrugallergyCount(IArchivesDrugallergy iArchivesDrugallergy){
        int count = iArchivesDrugallergyDao.findByHqlWhereCount(IarchivesstartPack.packIArchivesDrugallergyQuery(iArchivesDrugallergy));
        return count;
    }

    public List<IArchivesDrugallergy> listIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy, Pager pager){
        List<IArchivesDrugallergy> list = iArchivesDrugallergyDao.findByHqlWherePage(IarchivesstartPack.packIArchivesDrugallergyQuery(iArchivesDrugallergy), pager);
        return list;
    }

    public List<IArchivesDrugallergy> listIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy){
        List<IArchivesDrugallergy> list = iArchivesDrugallergyDao.findByHqlWhere(IarchivesstartPack.packIArchivesDrugallergyQuery(iArchivesDrugallergy));
        return list;
    }

    public IArchivesDrugallergy saveIArchivesDrugallergy(IArchivesDrugallergy iArchivesDrugallergy){
        IArchivesDrugallergy temp = (IArchivesDrugallergy)iArchivesDrugallergyDao.save(iArchivesDrugallergy);
        return temp;
    }

    public IArchivesDrugallergy getIArchivesDrugallergyByPk(String pk){
        IArchivesDrugallergy iArchivesDrugallergy = (IArchivesDrugallergy)iArchivesDrugallergyDao.getByPK(pk);
        return iArchivesDrugallergy;
    }

    public void deleteIArchivesDrugallergyByPks(String[] pks){
        for (String pk : pks) {
            IArchivesDrugallergy iArchivesDrugallergy = iArchivesDrugallergyDao.getByPK(pk);
            iArchivesDrugallergyDao.remove(iArchivesDrugallergy);
        }
    }
    
    
    public int listIMemberCount(IMember iMember){
    	 System.out.println("页面传递过来的参数为"+iMember.getMemberSex());
        int count = iMemberDao.findByHqlWhereCount(IarchivesstartPack.packIMemberQuery(iMember));
        return count;
    }

    public List<IMember> listIMember(IMember iMember, Pager pager){
        List<IMember> list = iMemberDao.findByHqlWherePage(IarchivesstartPack.packIMemberQuery(iMember), pager);
        return list;
    }

    public List<IMember> listIMember(IMember iMember){
        List<IMember> list = iMemberDao.findByHqlWhere(IarchivesstartPack.packIMemberQuery(iMember));
        return list;
    }

    public IMember saveIMember(IMember iMember){
    	System.out.println("service方法已经执行");
    	System.out.println(iMember.getMemberId());
    	System.out.println(iMember.getMemberName());
     	System.out.println("性别为"+iMember.getMemberSex());
    	System.out.println(iMember.getMemberAge());
    	System.out.println(iMember.getMemberBirthday());
    	System.out.println(iMember.getMemberCountry());
    	System.out.println(iMember.getMemberBirthday());
    	System.out.println(iMember.getMemberOriginplace());
    	System.out.println(iMember.getMemberNation());//
    	System.out.println(iMember.getMemberIdcard());
    	System.out.println(iMember.getMemberIsmarry());//
    	System.out.println(iMember.getMemberAddress());
    	System.out.println(iMember.getMemberPhone());
    	System.out.println(iMember.getMemberJointime());
    	System.out.println(iMember.getBloodType());
    	System.out.println(iMember.getRh());
    	
    	
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
    
    
    public void deleteIMemberByPks(String[] pks,String N){
        for (String pk : pks) {
            IMember iMember = iMemberDao.getByPK(pk);
            iMember.setDr("Y");
            iMemberDao.remove(iMember);
        }
    }
    public int listIArchivesDiseaseCount(IArchivesDisease iArchivesDisease){
        int count = iArchivesDiseaseDao.findByHqlWhereCount(IarchivesstartPack.packIArchivesDiseaseQuery(iArchivesDisease));
        return count;
    }

    public List<IArchivesDisease> listIArchivesDisease(IArchivesDisease iArchivesDisease, Pager pager){
        List<IArchivesDisease> list = iArchivesDiseaseDao.findByHqlWherePage(IarchivesstartPack.packIArchivesDiseaseQuery(iArchivesDisease), pager);
        return list;
    }

    public List<IArchivesDisease> listIArchivesDisease(IArchivesDisease iArchivesDisease){
        List<IArchivesDisease> list = iArchivesDiseaseDao.findByHqlWhere(IarchivesstartPack.packIArchivesDiseaseQuery(iArchivesDisease));
        return list;
    }

    public IArchivesDisease saveIArchivesDisease(IArchivesDisease iArchivesDisease){
        IArchivesDisease temp = (IArchivesDisease)iArchivesDiseaseDao.save(iArchivesDisease);
        return temp;
    }

    public IArchivesDisease getIArchivesDiseaseByPk(String pk){
        IArchivesDisease iArchivesDisease = (IArchivesDisease)iArchivesDiseaseDao.getByPK(pk);
        return iArchivesDisease;
    }

    public void deleteIArchivesDiseaseByPks(String[] pks){
        for (String pk : pks) {
            IArchivesDisease iArchivesDisease = iArchivesDiseaseDao.getByPK(pk);
            iArchivesDiseaseDao.remove(iArchivesDisease);
        }
    }
}