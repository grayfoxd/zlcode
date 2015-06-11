package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CAR_USE 对应daoImpl
 */
@Repository
public class OaCarUseDaoImpl extends BaseHapiDaoimpl<OaCarUse, Long> implements IOaCarUseDao {

   public OaCarUseDaoImpl(){
      super(OaCarUse.class);
   }
}