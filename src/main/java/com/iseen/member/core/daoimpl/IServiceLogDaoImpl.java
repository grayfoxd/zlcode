package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_service_log 对应daoImpl
 */
@Repository
public class IServiceLogDaoImpl extends com.frame.core.BaseHapiDaoimpl<IServiceLog, String> implements IIServiceLogDao {

    public IServiceLogDaoImpl(){
        super(IServiceLog.class);
    }
}