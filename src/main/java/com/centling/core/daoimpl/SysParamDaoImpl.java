package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_PARAM 对应daoImpl
 */
@Repository
public class SysParamDaoImpl extends BaseHapiDaoimpl<SysParam, Long> implements ISysParamDao {

   public SysParamDaoImpl(){
      super(SysParam.class);
   }
}