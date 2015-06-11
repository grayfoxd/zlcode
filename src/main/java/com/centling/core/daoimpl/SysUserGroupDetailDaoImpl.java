package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_USER_GROUP_DETAIL 对应daoImpl
 */
@Repository
public class SysUserGroupDetailDaoImpl extends BaseHapiDaoimpl<SysUserGroupDetail, Long> implements ISysUserGroupDetailDao {

   public SysUserGroupDetailDaoImpl(){
      super(SysUserGroupDetail.class);
   }
}