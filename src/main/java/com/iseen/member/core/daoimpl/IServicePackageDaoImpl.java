package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_service_package 对应daoImpl
 */
@Repository
public class IServicePackageDaoImpl extends com.frame.core.BaseHapiDaoimpl<IServicePackage, String> implements IIServicePackageDao {

    public IServicePackageDaoImpl(){
        super(IServicePackage.class);
    }
}