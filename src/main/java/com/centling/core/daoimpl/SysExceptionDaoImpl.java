package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_EXCEPTION 对应daoImpl
 */
@Repository
public class SysExceptionDaoImpl extends BaseHapiDaoimpl<SysException, Long> implements ISysExceptionDao {

   public SysExceptionDaoImpl(){
      super(SysException.class);
   }
}