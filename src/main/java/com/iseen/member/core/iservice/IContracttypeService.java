package com.iseen.member.core.iservice;

import com.iseen.member.core.pojo.IContractType;

import java.util.List;

import com.centling.common.pages.Pager;

public interface IContracttypeService{

    public int listIContractTypeCount(IContractType iContractType);
    public List<IContractType> listIContractType(IContractType iContractType, Pager pager);
    public List<IContractType> listIContractType(IContractType iContractType);
    /**
     * @param iContractType
     * @return
     */
    public IContractType saveIContractType(IContractType iContractType);
    /**
     * @param pk
     * @return
     */
    public IContractType getIContractTypeByPk(String pk);
    /**
     * 物理删除
     * @param pks
     */
    public void deleteIContractTypeByPks(String[] pks);
    /**
     * 删除方法
     * @param pks ：主键
     * @param N：Y代表物理删除，否则逻辑删除
     */
    public void deleteIContractTypeByPks(String[] pks,String N);
}