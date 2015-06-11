package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_phy_advise 对应daoImpl
 */
@Repository
public class IPhyAdviseDaoImpl extends com.frame.core.BaseHapiDaoimpl<IPhyAdvise, String> implements IIPhyAdviseDao {

    public IPhyAdviseDaoImpl(){
        super(IPhyAdvise.class);
    }
}