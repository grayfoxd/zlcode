package com.iseen.member.core.service;

import com.iseen.member.core.pojo.IMemberAppointment;
import com.iseen.member.core.dao.IIMemberAppointmentDao;
import com.iseen.member.core.iservice.IImemberappointmentService;
import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.ImemberappointmentPack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImemberappointmentService implements IImemberappointmentService{

    @Resource
    private IIMemberAppointmentDao iMemberAppointmentDao;

    public int listIMemberAppointmentCount(IMemberAppointment iMemberAppointment){
        int count = iMemberAppointmentDao.findByHqlWhereCount(ImemberappointmentPack.packIMemberAppointmentQuery(iMemberAppointment));
        return count;
    }

    public List<IMemberAppointment> listIMemberAppointment(IMemberAppointment iMemberAppointment, Pager pager){
        List<IMemberAppointment> list = iMemberAppointmentDao.findByHqlWherePage(ImemberappointmentPack.packIMemberAppointmentQuery(iMemberAppointment), pager);
        return list;
    }

    public List<IMemberAppointment> listIMemberAppointment(IMemberAppointment iMemberAppointment){
        List<IMemberAppointment> list = iMemberAppointmentDao.findByHqlWhere(ImemberappointmentPack.packIMemberAppointmentQuery(iMemberAppointment));
        return list;
    }

    public IMemberAppointment saveIMemberAppointment(IMemberAppointment iMemberAppointment){
        IMemberAppointment temp = (IMemberAppointment)iMemberAppointmentDao.save(iMemberAppointment);
        return temp;
    }

    public IMemberAppointment getIMemberAppointmentByPk(String pk){
        IMemberAppointment iMemberAppointment = (IMemberAppointment)iMemberAppointmentDao.getByPK(pk);
        return iMemberAppointment;
    }

    public void deleteIMemberAppointmentByPks(String[] pks){
        for (String pk : pks) {
            IMemberAppointment iMemberAppointment = iMemberAppointmentDao.getByPK(pk);
            iMemberAppointment.setDr("Y");//将是否删除的属性设置为Y
            iMemberAppointmentDao.remove(iMemberAppointment);
        }
    }
}