package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_member_appointment 对应daoImpl
 */
@Repository
public class IMemberAppointmentDaoImpl extends com.frame.core.BaseHapiDaoimpl<IMemberAppointment, String> implements IIMemberAppointmentDao {

    public IMemberAppointmentDaoImpl(){
        super(IMemberAppointment.class);
    }
}