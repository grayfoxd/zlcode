package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_WARETYPE_RANGE 对应daoImpl
 */
@Repository
public class OaWaretypeRangeDaoImpl extends BaseHapiDaoimpl<OaWaretypeRange, Long> implements IOaWaretypeRangeDao {

   public OaWaretypeRangeDaoImpl(){
      super(OaWaretypeRange.class);
   }
}