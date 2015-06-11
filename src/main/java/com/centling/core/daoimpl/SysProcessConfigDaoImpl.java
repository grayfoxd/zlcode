package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：sys_process_config 对应daoImpl
 */
@Repository
public class SysProcessConfigDaoImpl extends BaseHapiDaoimpl<SysProcessConfig, String> implements ISysProcessConfigDao {

    public SysProcessConfigDaoImpl(){
        super(SysProcessConfig.class);
    }
}