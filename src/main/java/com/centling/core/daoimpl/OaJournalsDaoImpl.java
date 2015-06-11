package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_JOURNALS 对应daoImpl
 */
@Repository
public class OaJournalsDaoImpl extends BaseHapiDaoimpl<OaJournals, Long> implements IOaJournalsDao {

   public OaJournalsDaoImpl(){
      super(OaJournals.class);
   }
}