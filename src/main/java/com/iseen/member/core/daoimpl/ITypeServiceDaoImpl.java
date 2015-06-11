package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_type_service 对应daoImpl
 */
@Repository
public class ITypeServiceDaoImpl extends com.frame.core.BaseHapiDaoimpl<ITypeService, String> implements IITypeServiceDao {

    public ITypeServiceDaoImpl(){
        super(ITypeService.class);
    }
}