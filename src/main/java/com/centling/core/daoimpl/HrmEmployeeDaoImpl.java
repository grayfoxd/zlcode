package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：HRM_EMPLOYEE 对应daoImpl
 */
@Repository
public class HrmEmployeeDaoImpl extends BaseHapiDaoimpl<HrmEmployee, String> implements IHrmEmployeeDao {

   public HrmEmployeeDaoImpl(){
      super(HrmEmployee.class);
   }
}