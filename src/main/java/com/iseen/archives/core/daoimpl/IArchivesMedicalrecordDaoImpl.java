package com.iseen.archives.core.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.centling.common.pages.Pager;
import com.iseen.archives.core.pojo.*;
import com.iseen.archives.core.dao.*;
/**
 * 表：i_archives_medicalrecord 对应daoImpl
 */
@Repository
public class IArchivesMedicalrecordDaoImpl extends com.frame.core.BaseHapiDaoimpl<IArchivesMedicalrecord, String> implements IIArchivesMedicalrecordDao {

	
	
    @SuppressWarnings("unchecked")
	@Override
	public List<IArchivesMedicalrecord> findByHqlWherePage(String hqlWhere,
			Pager pager) {
    	StringBuffer queryString = new StringBuffer();
    	//此处不通
		queryString.append("from  IArchivesMedicalrecord"
				+ " as model where 1=1 ");
		// TODO 自动生成的方法存根
		return getSession().createQuery(queryString.toString()).setFirstResult(
				pager.getStartRow()).setMaxResults(pager.getPageSize()).list();
	}

	public IArchivesMedicalrecordDaoImpl(){
        super(IArchivesMedicalrecord.class);
    }
    
}