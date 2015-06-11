package com.iseen.archives.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.archives.core.pojo.*;
import com.iseen.archives.core.dao.*;
/**
 * 表：i_archives_disease 对应daoImpl
 */
@Repository
public class IArchivesDiseaseDaoImpl extends com.frame.core.BaseHapiDaoimpl<IArchivesDisease, String> implements IIArchivesDiseaseDao {

    public IArchivesDiseaseDaoImpl(){
        super(IArchivesDisease.class);
    }
}