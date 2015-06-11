package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_USER_METHODS 对应daoImpl
 */
@Repository
public class SysUserMethodsDaoImpl extends BaseHapiDaoimpl<SysUserMethods, Long> implements ISysUserMethodsDao {

   public SysUserMethodsDaoImpl(){
      super(SysUserMethods.class);
   }
}