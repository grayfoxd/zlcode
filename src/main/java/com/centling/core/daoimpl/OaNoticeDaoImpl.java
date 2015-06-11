package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_NOTICE 对应daoImpl
 */
@Repository
public class OaNoticeDaoImpl extends BaseHapiDaoimpl<OaNotice, Long> implements IOaNoticeDao {

   public OaNoticeDaoImpl(){
      super(OaNotice.class);
   }
}