package com.iseen.archives.core.daoimpl;

import org.springframework.stereotype.Repository;
import com.iseen.archives.core.pojo.*;
import com.iseen.archives.core.dao.*;
/**
 * 表：i_archives_drugallergy 对应daoImpl
 */
@Repository
public class IArchivesDrugallergyDaoImpl extends com.frame.core.BaseHapiDaoimpl<IArchivesDrugallergy, String> implements IIArchivesDrugallergyDao {

    public IArchivesDrugallergyDaoImpl(){
        super(IArchivesDrugallergy.class);
    }
}