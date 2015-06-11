package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_MAIL_INBOX 对应daoImpl
 */
@Repository
public class OaMailInboxDaoImpl extends BaseHapiDaoimpl<OaMailInbox, Long> implements IOaMailInboxDao {

   public OaMailInboxDaoImpl(){
      super(OaMailInbox.class);
   }
}