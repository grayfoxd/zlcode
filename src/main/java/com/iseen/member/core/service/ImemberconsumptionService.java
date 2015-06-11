package com.iseen.member.core.service;

import com.iseen.member.core.pojo.IMemberConsumption;
import com.iseen.member.core.dao.IIMemberConsumptionDao;
import com.iseen.member.core.iservice.IImemberconsumptionService;
import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.ImemberconsumptionPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImemberconsumptionService implements IImemberconsumptionService{

    @Resource
    private IIMemberConsumptionDao iMemberConsumptionDao;

    public int listIMemberConsumptionCount(IMemberConsumption iMemberConsumption){
        int count = iMemberConsumptionDao.findByHqlWhereCount(ImemberconsumptionPack.packIMemberConsumptionQuery(iMemberConsumption));
        return count;
    }

    public List<IMemberConsumption> listIMemberConsumption(IMemberConsumption iMemberConsumption, Pager pager){
        List<IMemberConsumption> list = iMemberConsumptionDao.findByHqlWherePage(ImemberconsumptionPack.packIMemberConsumptionQuery(iMemberConsumption), pager);
        return list;
    }

    public List<IMemberConsumption> listIMemberConsumption(IMemberConsumption iMemberConsumption){
        List<IMemberConsumption> list = iMemberConsumptionDao.findByHqlWhere(ImemberconsumptionPack.packIMemberConsumptionQuery(iMemberConsumption));
        return list;
    }

    public IMemberConsumption saveIMemberConsumption(IMemberConsumption iMemberConsumption){
        IMemberConsumption temp = (IMemberConsumption)iMemberConsumptionDao.save(iMemberConsumption);
        return temp;
    }

    public IMemberConsumption getIMemberConsumptionByPk(String pk){
        IMemberConsumption iMemberConsumption = (IMemberConsumption)iMemberConsumptionDao.getByPK(pk);
        return iMemberConsumption;
    }

    public void deleteIMemberConsumptionByPks(String[] pks){
        for (String pk : pks) {
            IMemberConsumption iMemberConsumption = iMemberConsumptionDao.getByPK(pk);
            iMemberConsumption.setDr("Y");//将是否删除的属性设置为Y
            iMemberConsumptionDao.remove(iMemberConsumption);
        }
    }
}