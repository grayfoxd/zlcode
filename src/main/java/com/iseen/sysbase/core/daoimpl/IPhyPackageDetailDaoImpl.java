package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_phy_package_detail 对应daoImpl
 */
@Repository
public class IPhyPackageDetailDaoImpl extends com.frame.core.BaseHapiDaoimpl<IPhyPackageDetail, String> implements IIPhyPackageDetailDao {

    public IPhyPackageDetailDaoImpl(){
        super(IPhyPackageDetail.class);
    }
}