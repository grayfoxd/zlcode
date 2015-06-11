package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IPhyItem;
import com.iseen.sysbase.core.dao.IIPhyItemDao;
import com.iseen.sysbase.core.iservice.IPhyItemService;
import com.centling.common.pages.Pager;
import com.centling.common.util.UtilWork;
import com.iseen.sysbase.common.pack.PhyItemPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PhyItemService implements IPhyItemService{

    @Resource
    private IIPhyItemDao iPhyItemDao;

    public int listIPhyItemCount(IPhyItem iPhyItem){
        int count = iPhyItemDao.findByHqlWhereCount(PhyItemPack.packIPhyItemQuery(iPhyItem));
        return count;
    }
    
    public int getIPhyItemListCount(IPhyItem iPhyItem){
        int count = iPhyItemDao.findByHqlWhereCount(PhyItemPack.packIPhyItemList(iPhyItem));
        return count;
    }

    public List<IPhyItem> listIPhyItem(IPhyItem iPhyItem, Pager pager){
        List<IPhyItem> list = iPhyItemDao.findByHqlWherePage(PhyItemPack.packIPhyItemQuery(iPhyItem), pager);
        return list;
    }
    
    public List<IPhyItem> getPhyItemList(IPhyItem iPhyItem, Pager pager){
    	List<IPhyItem> list = iPhyItemDao.findByHqlWherePage(PhyItemPack.packIPhyItemList(iPhyItem), pager);
        return list;
    }

    public List<IPhyItem> listIPhyItem(IPhyItem iPhyItem){
        List<IPhyItem> list = iPhyItemDao.findByHqlWhere(PhyItemPack.packIPhyItemQuery(iPhyItem));
        return list;
    }

    public IPhyItem saveIPhyItem(IPhyItem iPhyItem){
        IPhyItem temp = (IPhyItem)iPhyItemDao.save(iPhyItem);
        return temp;
    }

    public IPhyItem getIPhyItemByPk(String pk){
        IPhyItem iPhyItem = (IPhyItem)iPhyItemDao.getByPK(pk);
        return iPhyItem;
    }
 

    public void deleteIPhyItemByPks(String[] pks, String empid){
        for (String pk : pks) {
            IPhyItem iPhyItem = iPhyItemDao.getByPK(pk);
            iPhyItem.setDr("Y");
            iPhyItem.setLastOperator(empid);
			iPhyItem.setLastOperatorTime(UtilWork.getNowTime());
            iPhyItemDao.save(iPhyItem);
        }
    }
    
    public List<IPhyItem> getIPhyItemListByUpCode(String code) {
		List<IPhyItem> itemList = iPhyItemDao.findByHqlWhere(" and model.parentId ='" + code + "' and dr = 'N' order by model.primaryKey");
		return itemList;
	}
    
    public int getPhyItemListByUpCodeCount(String code){
    	return iPhyItemDao.findByHqlWhereCount(" and model.parentId ='" + code + "' and dr = 'N'");
    }
    
    /**
	 * 根据上级目录和目录名称统计项目目录数量
	 */
	public int getPhyItemByNameAndParentId(String name,String parentId, String PK) {
		int count = 0;
		if(PK != null && PK.length() > 0){
			count = iPhyItemDao.findByHqlWhereCount(" and model.itemName='"+name+"' and model.parentId='"+parentId+"' and model.primaryKey<> '"+PK+"'");
		}else{
			count = iPhyItemDao.findByHqlWhereCount(" and model.itemName='"+name+"' and model.parentId='"+parentId+"'");
		}
		return count;
	}
	
	/**
	 * 根据节点查询下级信息
	 */
	public List<IPhyItem> getPhyItemListByPK(String pk) {
		List<IPhyItem> list = iPhyItemDao.findByHqlWhere(" and model.primaryKey= '"+pk+"'");
		return list;
	}
	
	public List<IPhyItem> getPhyItemListByPks(String pks){
		List<IPhyItem> list = iPhyItemDao.findByHqlWhere(PhyItemPack.packQuerypks(pks));
		return list;
	}
}