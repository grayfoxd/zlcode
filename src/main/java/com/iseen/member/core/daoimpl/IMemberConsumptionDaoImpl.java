package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_member_consumption 对应daoImpl
 */
@Repository
public class IMemberConsumptionDaoImpl extends com.frame.core.BaseHapiDaoimpl<IMemberConsumption, String> implements IIMemberConsumptionDao {

    public IMemberConsumptionDaoImpl(){
        super(IMemberConsumption.class);
    }
}