package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_FORUMS 对应daoImpl
 */
@Repository
public class OaForumsDaoImpl extends BaseHapiDaoimpl<OaForums, Long> implements IOaForumsDao {

   public OaForumsDaoImpl(){
      super(OaForums.class);
   }
}