package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_sys_compay 对应daoImpl
 */
@Repository
public class ISysCompayDaoImpl extends com.frame.core.BaseHapiDaoimpl<ISysCompay, String> implements IISysCompayDao {

    public ISysCompayDaoImpl(){
        super(ISysCompay.class);
    }
}