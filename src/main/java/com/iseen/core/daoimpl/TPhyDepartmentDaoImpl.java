package com.iseen.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.core.pojo.*;
import com.iseen.core.dao.*;

/**
 * 表：t_phy_department 对应daoImpl
 */
@Repository
public class TPhyDepartmentDaoImpl extends com.centling.core.daoimpl.BaseHapiDaoimpl<TPhyDepartment, String> implements ITPhyDepartmentDao {

    public TPhyDepartmentDaoImpl(){
        super(TPhyDepartment.class);
    }
}