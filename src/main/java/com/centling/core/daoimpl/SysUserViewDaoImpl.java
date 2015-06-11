package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_USER_VIEW 对应daoImpl
 */
@Repository
public class SysUserViewDaoImpl extends BaseHapiDaoimpl<SysUserView, Long> implements ISysUserViewDao {

   public SysUserViewDaoImpl(){
      super(SysUserView.class);
   }
}