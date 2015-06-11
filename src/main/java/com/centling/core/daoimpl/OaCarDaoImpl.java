package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CAR 对应daoImpl
 */
@Repository
public class OaCarDaoImpl extends BaseHapiDaoimpl<OaCar, Long> implements IOaCarDao {

   public OaCarDaoImpl(){
      super(OaCar.class);
   }
}