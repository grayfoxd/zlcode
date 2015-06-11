package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_POSTS 对应daoImpl
 */
@Repository
public class OaPostsDaoImpl extends BaseHapiDaoimpl<OaPosts, Long> implements IOaPostsDao {

   public OaPostsDaoImpl(){
      super(OaPosts.class);
   }
}