package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：sys_process_type 对应daoImpl
 */
@Repository
public class SysProcessTypeDaoImpl extends BaseHapiDaoimpl<SysProcessType, String> implements ISysProcessTypeDao {

    public SysProcessTypeDaoImpl(){
        super(SysProcessType.class);
    }
}