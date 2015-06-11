package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_IMAGE_INFO 对应daoImpl
 */
@Repository
public class SysImageInfoDaoImpl extends BaseHapiDaoimpl<SysImageInfo, Long> implements ISysImageInfoDao {

   public SysImageInfoDaoImpl(){
      super(SysImageInfo.class);
   }
}