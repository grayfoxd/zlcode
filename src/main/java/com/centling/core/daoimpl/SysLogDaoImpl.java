package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_LOG 对应daoImpl
 */
@Repository
public class SysLogDaoImpl extends BaseHapiDaoimpl<SysLog, Long> implements ISysLogDao {

   public SysLogDaoImpl(){
      super(SysLog.class);
   }
}