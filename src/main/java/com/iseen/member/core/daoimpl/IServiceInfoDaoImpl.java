package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_service_info 对应daoImpl
 */
@Repository
public class IServiceInfoDaoImpl extends com.frame.core.BaseHapiDaoimpl<IServiceInfo, String> implements IIServiceInfoDao {

    public IServiceInfoDaoImpl(){
        super(IServiceInfo.class);
    }
}