package com.iseen.archives.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.archives.core.pojo.*;
import com.iseen.archives.core.dao.*;
/**
 * 表：i_archives 对应daoImpl
 */
@Repository
public class IArchivesDaoImpl extends com.frame.core.BaseHapiDaoimpl<IArchives, String> implements IIArchivesDao {

    public IArchivesDaoImpl(){
        super(IArchives.class);
    }
}