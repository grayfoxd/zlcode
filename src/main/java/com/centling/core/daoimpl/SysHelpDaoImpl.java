package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_HELP 对应daoImpl
 */
@Repository
public class SysHelpDaoImpl extends BaseHapiDaoimpl<SysHelp, Long> implements ISysHelpDao {

   public SysHelpDaoImpl(){
      super(SysHelp.class);
   }
}