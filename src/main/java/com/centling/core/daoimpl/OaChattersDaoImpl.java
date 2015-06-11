package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CHATTERS 对应daoImpl
 */
@Repository
public class OaChattersDaoImpl extends BaseHapiDaoimpl<OaChatters, Long> implements IOaChattersDao {

   public OaChattersDaoImpl(){
      super(OaChatters.class);
   }
}