package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_ERROR 对应daoImpl
 */
@Repository
public class SysErrorDaoImpl extends BaseHapiDaoimpl<SysError, Long> implements ISysErrorDao {

   public SysErrorDaoImpl(){
      super(SysError.class);
   }
}