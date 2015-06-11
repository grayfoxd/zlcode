package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_LEAVEREGISTRATION 对应daoImpl
 */
@Repository
public class OaLeaveregistrationDaoImpl extends BaseHapiDaoimpl<OaLeaveregistration, Long> implements IOaLeaveregistrationDao {

   public OaLeaveregistrationDaoImpl(){
      super(OaLeaveregistration.class);
   }
}