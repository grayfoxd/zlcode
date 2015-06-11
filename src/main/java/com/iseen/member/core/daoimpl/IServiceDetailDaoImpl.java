package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_service_detail 对应daoImpl
 */
@Repository
public class IServiceDetailDaoImpl extends com.frame.core.BaseHapiDaoimpl<IServiceDetail, String> implements IIServiceDetailDao {

    public IServiceDetailDaoImpl(){
        super(IServiceDetail.class);
    }
}