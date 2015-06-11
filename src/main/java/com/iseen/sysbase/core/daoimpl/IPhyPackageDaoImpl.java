package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_phy_package 对应daoImpl
 */
@Repository
public class IPhyPackageDaoImpl extends com.frame.core.BaseHapiDaoimpl<IPhyPackage, String> implements IIPhyPackageDao {

    public IPhyPackageDaoImpl(){
        super(IPhyPackage.class);
    }
}