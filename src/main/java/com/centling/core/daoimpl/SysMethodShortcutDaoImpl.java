package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：sys_method_shortcut 对应daoImpl
 */
@Repository
public class SysMethodShortcutDaoImpl extends BaseHapiDaoimpl<SysMethodShortcut, Long> implements ISysMethodShortcutDao {

   public SysMethodShortcutDaoImpl(){
      super(SysMethodShortcut.class);
   }
}