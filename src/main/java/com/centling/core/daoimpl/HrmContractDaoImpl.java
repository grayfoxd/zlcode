package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：hrm_contract 对应daoImpl
 */
@Repository
public class HrmContractDaoImpl extends BaseHapiDaoimpl<HrmContract, String> implements IHrmContractDao {

    public HrmContractDaoImpl(){
        super(HrmContract.class);
    }
}