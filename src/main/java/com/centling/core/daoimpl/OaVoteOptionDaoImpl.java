package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_VOTE_OPTION 对应daoImpl
 */
@Repository
public class OaVoteOptionDaoImpl extends BaseHapiDaoimpl<OaVoteOption, Long> implements IOaVoteOptionDao {

   public OaVoteOptionDaoImpl(){
      super(OaVoteOption.class);
   }
}