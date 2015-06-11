package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_NETMAIL_SET 对应daoImpl
 */
@Repository
public class OaNetmailSetDaoImpl extends BaseHapiDaoimpl<OaNetmailSet, Long> implements IOaNetmailSetDao {

   public OaNetmailSetDaoImpl(){
      super(OaNetmailSet.class);
   }
}