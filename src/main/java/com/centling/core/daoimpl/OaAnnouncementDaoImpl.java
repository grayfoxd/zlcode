package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_ANNOUNCEMENT 对应daoImpl
 */
@Repository
public class OaAnnouncementDaoImpl extends BaseHapiDaoimpl<OaAnnouncement, Long> implements IOaAnnouncementDao {

   public OaAnnouncementDaoImpl(){
      super(OaAnnouncement.class);
   }
}