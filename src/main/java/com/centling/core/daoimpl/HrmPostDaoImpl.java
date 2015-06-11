package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：HRM_POST 对应daoImpl
 */
@Repository
public class HrmPostDaoImpl extends BaseHapiDaoimpl<HrmPost, Long> implements IHrmPostDao {

   public HrmPostDaoImpl(){
      super(HrmPost.class);
   }
}