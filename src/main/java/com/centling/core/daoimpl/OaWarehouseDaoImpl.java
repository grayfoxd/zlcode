package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_WAREHOUSE 对应daoImpl
 */
@Repository
public class OaWarehouseDaoImpl extends BaseHapiDaoimpl<OaWarehouse, Long> implements IOaWarehouseDao {

   public OaWarehouseDaoImpl(){
      super(OaWarehouse.class);
   }
}