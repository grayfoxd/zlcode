package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_CAR_MAINTAIN 对应daoImpl
 */
@Repository
public class OaCarMaintainDaoImpl extends BaseHapiDaoimpl<OaCarMaintain, Long> implements IOaCarMaintainDao {

   public OaCarMaintainDaoImpl(){
      super(OaCarMaintain.class);
   }
}