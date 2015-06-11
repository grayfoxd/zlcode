package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：sys_method_help 对应daoImpl
 */
@Repository
public class SysMethodHelpDaoImpl extends BaseHapiDaoimpl<SysMethodHelp, Long> implements ISysMethodHelpDao {

   public SysMethodHelpDaoImpl(){
      super(SysMethodHelp.class);
   }
}