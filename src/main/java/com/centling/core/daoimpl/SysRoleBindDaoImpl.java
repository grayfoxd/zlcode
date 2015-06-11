package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_ROLE_BIND 对应daoImpl
 */
@Repository
public class SysRoleBindDaoImpl extends BaseHapiDaoimpl<SysRoleBind, Long> implements ISysRoleBindDao {

   public SysRoleBindDaoImpl(){
      super(SysRoleBind.class);
   }
}