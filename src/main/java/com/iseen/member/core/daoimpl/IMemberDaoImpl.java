package com.iseen.member.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.member.core.pojo.*;
import com.iseen.member.core.dao.*;
/**
 * 表：i_member 对应daoImpl
 */
@Repository
public class IMemberDaoImpl extends com.frame.core.BaseHapiDaoimpl<IMember, String> implements IIMemberDao {

    public IMemberDaoImpl(){
        super(IMember.class);
    }
}