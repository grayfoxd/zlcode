package com.iseen.member.core.iservice;

import com.iseen.member.core.pojo.IMember;
import java.util.List;
import com.centling.common.pages.Pager;

public interface II_memberService{

    public int listIMemberCount(IMember iMember);
    public List<IMember> listIMember(IMember iMember, Pager pager);
    public List<IMember> listIMember(IMember iMember);
    public IMember saveIMember(IMember iMember);
    public IMember getIMemberByPk(String pk);
    public void deleteIMemberByPks(String[] pks);
}