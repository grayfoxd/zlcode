package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_phy_disease 对应daoImpl
 */
@Repository
public class IPhyDiseaseDaoImpl extends com.frame.core.BaseHapiDaoimpl<IPhyDisease, String> implements IIPhyDiseaseDao {

    public IPhyDiseaseDaoImpl(){
        super(IPhyDisease.class);
    }
}