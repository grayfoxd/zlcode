package com.iseen.archives.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.archives.core.pojo.*;
import com.iseen.archives.core.dao.*;
/**
 * 表：i_archives_start 对应daoImpl
 */
@Repository
public class IArchivesStartDaoImpl extends com.frame.core.BaseHapiDaoimpl<IArchivesStart, String> implements IIArchivesStartDao {

    public IArchivesStartDaoImpl(){
        super(IArchivesStart.class);
    }
}