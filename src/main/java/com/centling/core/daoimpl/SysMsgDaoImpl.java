package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_MSG 对应daoImpl
 */
@Repository
public class SysMsgDaoImpl extends BaseHapiDaoimpl<SysMsg, Long> implements ISysMsgDao {

   public SysMsgDaoImpl(){
      super(SysMsg.class);
   }
}