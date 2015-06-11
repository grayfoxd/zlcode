package com.iseen.member.core.iservice;

import com.iseen.member.core.pojo.IMemberAppointment;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IImemberappointmentService{

    public int listIMemberAppointmentCount(IMemberAppointment iMemberAppointment);
    public List<IMemberAppointment> listIMemberAppointment(IMemberAppointment iMemberAppointment, Pager pager);
    public List<IMemberAppointment> listIMemberAppointment(IMemberAppointment iMemberAppointment);
    public IMemberAppointment saveIMemberAppointment(IMemberAppointment iMemberAppointment);
    public IMemberAppointment getIMemberAppointmentByPk(String pk);
    public void deleteIMemberAppointmentByPks(String[] pks);
}