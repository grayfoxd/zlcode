package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：HRM_DEPARTMENT 对应daoImpl
 */
@Repository
public class HrmDepartmentDaoImpl extends BaseHapiDaoimpl<HrmDepartment, Long> implements IHrmDepartmentDao {

   public HrmDepartmentDaoImpl(){
      super(HrmDepartment.class);
   }
}