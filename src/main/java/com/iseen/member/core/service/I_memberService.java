package com.iseen.member.core.service;

import com.iseen.member.core.pojo.IMember;
import com.iseen.member.core.dao.IIMemberDao;
import com.iseen.member.core.iservice.II_memberService;
import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.I_memberPack;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class I_memberService implements II_memberService{

    @Resource
    private IIMemberDao iMemberDao;

    public int listIMemberCount(IMember iMember){
        int count = iMemberDao.findByHqlWhereCount(I_memberPack.packIMemberQuery(iMember));
        return count;
    }

    public List<IMember> listIMember(IMember iMember, Pager pager){
        List<IMember> list = iMemberDao.findByHqlWherePage(I_memberPack.packIMemberQuery(iMember), pager);
        return list;
    }

    public List<IMember> listIMember(IMember iMember){
        List<IMember> list = iMemberDao.findByHqlWhere(I_memberPack.packIMemberQuery(iMember));
        return list;
    }

    public IMember saveIMember(IMember iMember){
    	System.out.println("service方法已经执行");
    	System.out.println("id"+iMember.getMemberId());
    	System.out.println("会员名"+iMember.getMemberName());
     	System.out.println("性别为"+iMember.getMemberSex());
    	System.out.println("会员年龄"+iMember.getMemberAge());
    	System.out.println("会员生日"+iMember.getMemberBirthday());
    	System.out.println("会员国籍"+iMember.getMemberCountry());
    	System.out.println(iMember.getMemberOriginplace());
    	System.out.println(iMember.getMemberNation());//
    	System.out.println("身份证"+iMember.getMemberIdcard());
    	System.out.println("婚姻状况"+iMember.getMemberIsmarry());//
    	System.out.println("住址"+iMember.getMemberAddress());
    	System.out.println("手机"+iMember.getMemberPhone());
    	System.out.println("入会时间"+iMember.getMemberJointime());
    	System.out.println("血型"+iMember.getBloodType());
    	System.out.println("rh"+iMember.getRh());
    	 System.out.println("页面传递过来的参数为"+iMember.getMemberSex());
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
            iMember.setDr("Y");//将是否删除的属性设置为Y
            iMemberDao.remove(iMember);
        }
    }
}