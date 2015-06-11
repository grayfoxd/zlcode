package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：oa_car_apply 对应daoImpl
 */
@Repository
public class OaCarApplyDaoImpl extends BaseHapiDaoimpl<OaCarApply, Long> implements IOaCarApplyDao {

   public OaCarApplyDaoImpl(){
      super(OaCarApply.class);
   }
}