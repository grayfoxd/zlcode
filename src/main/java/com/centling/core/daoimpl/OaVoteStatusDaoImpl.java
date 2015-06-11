package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_VOTE_STATUS 对应daoImpl
 */
@Repository
public class OaVoteStatusDaoImpl extends BaseHapiDaoimpl<OaVoteStatus, Long> implements IOaVoteStatusDao {

   public OaVoteStatusDaoImpl(){
      super(OaVoteStatus.class);
   }
}