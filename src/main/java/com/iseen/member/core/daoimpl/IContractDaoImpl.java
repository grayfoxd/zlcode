package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_contract 对应daoImpl
 */
@Repository
public class IContractDaoImpl extends com.frame.core.BaseHapiDaoimpl<IContract, String> implements IIContractDao {

    public IContractDaoImpl(){
        super(IContract.class);
    }
}