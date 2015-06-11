package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_ROLE 对应daoImpl
 */
@Repository
public class SysRoleDaoImpl extends BaseHapiDaoimpl<SysRole, Long> implements ISysRoleDao {

   public SysRoleDaoImpl(){
      super(SysRole.class);
   }
}