package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_NETDISK_SHARE 对应daoImpl
 */
@Repository
public class OaNetdiskShareDaoImpl extends BaseHapiDaoimpl<OaNetdiskShare, Long> implements IOaNetdiskShareDao {

   public OaNetdiskShareDaoImpl(){
      super(OaNetdiskShare.class);
   }
}