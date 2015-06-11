package com.iseen.sysbase.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.sysbase.core.pojo.*;
import com.iseen.sysbase.core.dao.*;
/**
 * 表：i_health_indicator 对应daoImpl
 */
@Repository
public class IHealthIndicatorDaoImpl extends com.frame.core.BaseHapiDaoimpl<IHealthIndicator, String> implements IIHealthIndicatorDao {

    public IHealthIndicatorDaoImpl(){
        super(IHealthIndicator.class);
    }
}