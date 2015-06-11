package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_WORK_LOG 对应daoImpl
 */
@Repository
public class OaWorkLogDaoImpl extends BaseHapiDaoimpl<OaWorkLog, Long> implements IOaWorkLogDao {

   public OaWorkLogDaoImpl(){
      super(OaWorkLog.class);
   }
}