package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CHAT_GROUPS 对应daoImpl
 */
@Repository
public class OaChatGroupsDaoImpl extends BaseHapiDaoimpl<OaChatGroups, Long> implements IOaChatGroupsDao {

   public OaChatGroupsDaoImpl(){
      super(OaChatGroups.class);
   }
}