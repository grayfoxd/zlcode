package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_VOTE 对应daoImpl
 */
@Repository
public class OaVoteDaoImpl extends BaseHapiDaoimpl<OaVote, Long> implements IOaVoteDao {

   public OaVoteDaoImpl(){
      super(OaVote.class);
   }
}