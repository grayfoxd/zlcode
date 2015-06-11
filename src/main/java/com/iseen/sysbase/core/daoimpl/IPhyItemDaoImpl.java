package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_phy_item 对应daoImpl
 */
@Repository
public class IPhyItemDaoImpl extends com.frame.core.BaseHapiDaoimpl<IPhyItem, String> implements IIPhyItemDao {

    public IPhyItemDaoImpl(){
        super(IPhyItem.class);
    }
}