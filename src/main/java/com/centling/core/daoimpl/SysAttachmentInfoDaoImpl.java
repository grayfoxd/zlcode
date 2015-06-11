package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：SYS_ATTACHMENT_INFO 对应daoImpl
 */
@Repository
public class SysAttachmentInfoDaoImpl extends BaseHapiDaoimpl<SysAttachmentInfo, Long> implements ISysAttachmentInfoDao {

   public SysAttachmentInfoDaoImpl(){
      super(SysAttachmentInfo.class);
   }
}