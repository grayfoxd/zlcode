package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：sys_log_runtime 对应daoImpl
 */
@Repository
public class SysLogRuntimeDaoImpl extends BaseHapiDaoimpl<SysLogRuntime, Long> implements ISysLogRuntimeDao {

   public SysLogRuntimeDaoImpl(){
      super(SysLogRuntime.class);
   }
}