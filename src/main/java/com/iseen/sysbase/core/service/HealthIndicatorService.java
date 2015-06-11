package com.iseen.sysbase.core.service;

import com.iseen.sysbase.core.pojo.IHealthIndicator;
import com.iseen.sysbase.core.pojo.IPhyItem;
import com.iseen.sysbase.core.dao.IIHealthIndicatorDao;
import com.iseen.sysbase.core.iservice.IHealthIndicatorService;
import com.centling.common.pages.Pager;
import com.centling.common.util.UtilWork;
import com.iseen.sysbase.common.pack.HealthIndicatorPack;
import com.iseen.sysbase.common.pack.PhyItemPack;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class HealthIndicatorService implements IHealthIndicatorService{

    @Resource
    private IIHealthIndicatorDao iHealthIndicatorDao;

    public int listIHealthIndicatorCount(IHealthIndicator iHealthIndicator){
        int count = iHealthIndicatorDao.findByHqlWhereCount(HealthIndicatorPack.packIHealthIndicatorQuery(iHealthIndicator));
        return count;
    }
    
    public int getIHealthIndicatorListCount(IHealthIndicator iHealthIndicator){
        int count = iHealthIndicatorDao.findByHqlWhereCount(HealthIndicatorPack.packIHealthIndicatorList(iHealthIndicator));
        return count;
    }

    public List<IHealthIndicator> listIHealthIndicator(IHealthIndicator iHealthIndicator, Pager pager){
        List<IHealthIndicator> list = iHealthIndicatorDao.findByHqlWherePage(HealthIndicatorPack.packIHealthIndicatorQuery(iHealthIndicator), pager);
        return list;
    }

    public List<IHealthIndicator> listIHealthIndicator(IHealthIndicator iHealthIndicator){
        List<IHealthIndicator> list = iHealthIndicatorDao.findByHqlWhere(HealthIndicatorPack.packIHealthIndicatorQuery(iHealthIndicator));
        return list;
    }

    public IHealthIndicator saveIHealthIndicator(IHealthIndicator iHealthIndicator){
        IHealthIndicator temp = (IHealthIndicator)iHealthIndicatorDao.save(iHealthIndicator);
        return temp;
    }

    public IHealthIndicator getIHealthIndicatorByPk(String pk){
        IHealthIndicator iHealthIndicator = (IHealthIndicator)iHealthIndicatorDao.getByPK(pk);
        return iHealthIndicator;
    }

    public void deleteIHealthIndicatorByPks(String[] pks, String empId){
        for (String pk : pks) {
            IHealthIndicator iHealthIndicator = iHealthIndicatorDao.getByPK(pk);
            iHealthIndicator.setDr("Y");
            iHealthIndicator.setLastOperator(empId);
            iHealthIndicator.setLastOperatorTime(UtilWork.getNowTime());
            iHealthIndicatorDao.save(iHealthIndicator);
        }
    }
    
    public List<IHealthIndicator> getHealthIndicatorList(IHealthIndicator iHealthIndicator, Pager pager){
    	List<IHealthIndicator> list = iHealthIndicatorDao.findByHqlWherePage(HealthIndicatorPack.packIHealthIndicatorList(iHealthIndicator), pager);
        return list;
    }
    
    public List<IHealthIndicator> getIHealthIndicatorListByUpCode(String code) {
		List<IHealthIndicator> itemList = iHealthIndicatorDao.findByHqlWhere(" and model.parentId ='" + code + "' and dr = 'N' order by model.primaryKey");
		return itemList;
	}
    
    public int getHealthIndicatorListByUpCodeCount(String code){
    	return iHealthIndicatorDao.findByHqlWhereCount(" and model.parentId ='" + code + "' and dr = 'N'");
    }
    
    /**
	 * 根据上级目录和目录名称统计项目目录数量
	 */
	public int getHealthIndicatorByNameAndParentId(String name,String parentId, String PK) {
		int count = 0;
		if(PK != null && PK.length() > 0){
			count = iHealthIndicatorDao.findByHqlWhereCount(" and model.indicatorName='"+name+"' and model.parentId='"+parentId+"' and model.primaryKey<> '"+PK+"'");
		}else{
			count = iHealthIndicatorDao.findByHqlWhereCount(" and model.indicatorName='"+name+"' and model.parentId='"+parentId+"'");
		}
		return count;
	}
	
	/**
	 * 根据节点查询下级信息
	 */
	public List<IHealthIndicator> getHealthIndicatorListByPK(String pk) {
		List<IHealthIndicator> list = iHealthIndicatorDao.findByHqlWhere(" and model.primaryKey= '"+pk+"'");
		return list;
	}
    
}