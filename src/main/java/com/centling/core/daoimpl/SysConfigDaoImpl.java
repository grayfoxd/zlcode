package com.centling.core.daoimpl;

import org.springframework.stereotype.Repository;

import com.centling.core.dao.ISysConfigDao;
import com.centling.core.pojo.SysConfig;

@Repository
public class SysConfigDaoImpl extends BaseHapiDaoimpl<SysConfig, Long> implements ISysConfigDao {

	public SysConfigDaoImpl() {
		super(SysConfig.class);
	}
}