package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_MAIL_SEND 对应daoImpl
 */
@Repository
public class OaMailSendDaoImpl extends BaseHapiDaoimpl<OaMailSend, Long> implements IOaMailSendDao {

   public OaMailSendDaoImpl(){
      super(OaMailSend.class);
   }
}