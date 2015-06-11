package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_USER_GROUP 对应daoImpl
 */
@Repository
public class SysUserGroupDaoImpl extends BaseHapiDaoimpl<SysUserGroup, Long> implements ISysUserGroupDao {

   public SysUserGroupDaoImpl(){
      super(SysUserGroup.class);
   }
}