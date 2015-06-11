package com.iseen.sysbase.core.iservice;

import com.iseen.sysbase.core.pojo.IPhyItem;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IPhyItemService{

    public int listIPhyItemCount(IPhyItem iPhyItem);
    public List<IPhyItem> listIPhyItem(IPhyItem iPhyItem, Pager pager);
    public List<IPhyItem> getPhyItemList(IPhyItem iPhyItem, Pager pager);
    public List<IPhyItem> listIPhyItem(IPhyItem iPhyItem);
    public IPhyItem saveIPhyItem(IPhyItem iPhyItem);
    public IPhyItem getIPhyItemByPk(String pk);
    public void deleteIPhyItemByPks(String[] pks, String empid);
    public List<IPhyItem> getIPhyItemListByUpCode(String code);
    public int getPhyItemListByUpCodeCount(String code);
    public int getIPhyItemListCount(IPhyItem iPhyItem);
    public int getPhyItemByNameAndParentId(String name,String parentId, String PK);
    public List<IPhyItem> getPhyItemListByPK(String pk);
    public List<IPhyItem> getPhyItemListByPks(String pks);
}