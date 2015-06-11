package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_ROLE_DETAIL 对应daoImpl
 */
@Repository
public class SysRoleDetailDaoImpl extends BaseHapiDaoimpl<SysRoleDetail, Long> implements ISysRoleDetailDao {

   public SysRoleDetailDaoImpl(){
      super(SysRoleDetail.class);
   }
}