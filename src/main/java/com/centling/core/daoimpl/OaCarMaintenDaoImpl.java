package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CAR_MAINTEN 对应daoImpl
 */
@Repository
public class OaCarMaintenDaoImpl extends BaseHapiDaoimpl<OaCarMainten, Long> implements IOaCarMaintenDao {
 
   public OaCarMaintenDaoImpl(){
      super(OaCarMainten.class);
   }
}