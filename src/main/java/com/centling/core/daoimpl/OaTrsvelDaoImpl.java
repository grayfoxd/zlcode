package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_TRSVEL 对应daoImpl
 */
@Repository
public class OaTrsvelDaoImpl extends BaseHapiDaoimpl<OaTrsvel, Long> implements IOaTrsvelDao {

   public OaTrsvelDaoImpl(){
      super(OaTrsvel.class);
   }
}