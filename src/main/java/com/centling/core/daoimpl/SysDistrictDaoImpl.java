package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_DISTRICT 对应daoImpl
 */
@Repository
public class SysDistrictDaoImpl extends BaseHapiDaoimpl<SysDistrict, Long> implements ISysDistrictDao {

   public SysDistrictDaoImpl(){
      super(SysDistrict.class);
   }
}