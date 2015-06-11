package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_BOOK_TYPE 对应daoImpl
 */
@Repository
public class OaBookTypeDaoImpl extends BaseHapiDaoimpl<OaBookType, Long> implements IOaBookTypeDao {

   public OaBookTypeDaoImpl(){
      super(OaBookType.class);
   }
}