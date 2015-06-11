package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_PHOTO 对应daoImpl
 */
@Repository
public class OaPhotoDaoImpl extends BaseHapiDaoimpl<OaPhoto, Long> implements IOaPhotoDao {

   public OaPhotoDaoImpl(){
      super(OaPhoto.class);
   }
}