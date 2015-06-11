package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_contract_type 对应daoImpl
 */
@Repository
public class IContractTypeDaoImpl extends com.frame.core.BaseHapiDaoimpl<IContractType, String> implements IIContractTypeDao {

    public IContractTypeDaoImpl(){
        super(IContractType.class);
    }
}