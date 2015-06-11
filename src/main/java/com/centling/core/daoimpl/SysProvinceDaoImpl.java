package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_PROVINCE 对应daoImpl
 */
@Repository
public class SysProvinceDaoImpl extends BaseHapiDaoimpl<SysProvince, String> implements ISysProvinceDao {

   public SysProvinceDaoImpl(){
      super(SysProvince.class);
   }
}