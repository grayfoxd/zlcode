package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_disease_level 对应daoImpl
 */
@Repository
public class IDiseaseLevelDaoImpl extends com.frame.core.BaseHapiDaoimpl<IDiseaseLevel, String> implements IIDiseaseLevelDao {

    public IDiseaseLevelDaoImpl(){
        super(IDiseaseLevel.class);
    }
}