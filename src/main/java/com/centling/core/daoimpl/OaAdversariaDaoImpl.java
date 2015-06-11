package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_ADVERSARIA 对应daoImpl
 */
@Repository
public class OaAdversariaDaoImpl extends BaseHapiDaoimpl<OaAdversaria, Long> implements IOaAdversariaDao {

   public OaAdversariaDaoImpl(){
      super(OaAdversaria.class);
   }
}