package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_METHOD_INFO 对应daoImpl
 */
@Repository
public class SysMethodInfoDaoImpl extends BaseHapiDaoimpl<SysMethodInfo, String> implements ISysMethodInfoDao {

   public SysMethodInfoDaoImpl(){
      super(SysMethodInfo.class);
   }
}