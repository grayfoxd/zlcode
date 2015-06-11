package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_JOURNALS_TYPE 对应daoImpl
 */
@Repository
public class OaJournalsTypeDaoImpl extends BaseHapiDaoimpl<OaJournalsType, Long> implements IOaJournalsTypeDao {

   public OaJournalsTypeDaoImpl(){
      super(OaJournalsType.class);
   }
}