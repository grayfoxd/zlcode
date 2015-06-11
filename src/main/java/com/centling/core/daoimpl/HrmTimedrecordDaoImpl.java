package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：HRM_TIMEDRECORD 对应daoImpl
 */
@Repository
public class HrmTimedrecordDaoImpl extends BaseHapiDaoimpl<HrmTimedrecord, Long> implements IHrmTimedrecordDao {

   public HrmTimedrecordDaoImpl(){
      super(HrmTimedrecord.class);
   }
}