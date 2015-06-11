package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_ALBUM 对应daoImpl
 */
@Repository
public class OaAlbumDaoImpl extends BaseHapiDaoimpl<OaAlbum, Long> implements IOaAlbumDao {

   public OaAlbumDaoImpl(){
      super(OaAlbum.class);
   }
}