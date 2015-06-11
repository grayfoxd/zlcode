package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_MAIL_EMP 对应daoImpl
 */
@Repository
public class OaMailEmpDaoImpl extends BaseHapiDaoimpl<OaMailEmp, Long> implements IOaMailEmpDao {

   public OaMailEmpDaoImpl(){
      super(OaMailEmp.class);
   }
}