package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_MEETAPPLY 对应daoImpl
 */
@Repository
public class OaMeetapplyDaoImpl extends BaseHapiDaoimpl<OaMeetapply, Long> implements IOaMeetapplyDao {

   public OaMeetapplyDaoImpl(){
      super(OaMeetapply.class);
   }
}