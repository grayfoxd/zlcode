package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_NETMAIL_INBOX 对应daoImpl
 */
@Repository
public class OaNetmailInboxDaoImpl extends BaseHapiDaoimpl<OaNetmailInbox, Long> implements IOaNetmailInboxDao {

   public OaNetmailInboxDaoImpl(){
      super(OaNetmailInbox.class);
   }
}