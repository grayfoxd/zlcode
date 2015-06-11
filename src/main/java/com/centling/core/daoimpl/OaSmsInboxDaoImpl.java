package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_SMS_INBOX 对应daoImpl
 */
@Repository
public class OaSmsInboxDaoImpl extends BaseHapiDaoimpl<OaSmsInbox, Long> implements IOaSmsInboxDao {

   public OaSmsInboxDaoImpl(){
      super(OaSmsInbox.class);
   }
}