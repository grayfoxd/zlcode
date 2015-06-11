package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_REGULATIONS 对应daoImpl
 */
@Repository
public class OaRegulationsDaoImpl extends BaseHapiDaoimpl<OaRegulations, Long> implements IOaRegulationsDao {

   public OaRegulationsDaoImpl(){
      super(OaRegulations.class);
   }
}