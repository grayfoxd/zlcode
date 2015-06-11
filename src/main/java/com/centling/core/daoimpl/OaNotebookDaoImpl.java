package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.pojo.*;
import com.centling.core.dao.*;
/**
 * 表：OA_NOTEBOOK 对应daoImpl
 */
@Repository
public class OaNotebookDaoImpl extends BaseHapiDaoimpl<OaNotebook, Long> implements IOaNotebookDao {

   public OaNotebookDaoImpl(){
      super(OaNotebook.class);
   }
}