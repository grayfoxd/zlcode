package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：hrm_contract_type 对应daoImpl
 */
@Repository
public class HrmContractTypeDaoImpl extends BaseHapiDaoimpl<HrmContractType, String> implements IHrmContractTypeDao {

    public HrmContractTypeDaoImpl(){
        super(HrmContractType.class);
    }
}