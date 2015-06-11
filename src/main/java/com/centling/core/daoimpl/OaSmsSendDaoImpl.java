package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_SMS_SEND 对应daoImpl
 */
@Repository
public class OaSmsSendDaoImpl extends BaseHapiDaoimpl<OaSmsSend, Long> implements IOaSmsSendDao {

   public OaSmsSendDaoImpl(){
      super(OaSmsSend.class);
   }
}