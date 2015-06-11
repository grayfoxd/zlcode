package com.centling.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.centling.core.dao.ISysAttachmentInfoDao;
import com.centling.core.dao.ISysImageInfoDao;
import com.centling.core.iservice.IFileProcessService;
import com.centling.core.pojo.SysAttachmentInfo;
import com.centling.core.pojo.SysImageInfo;
@Service
public class FileProcessService implements IFileProcessService {
	@Resource
	private ISysImageInfoDao sysImageInfodao;
	@Resource
	private ISysAttachmentInfoDao sysAttachmentDao;
	
	public SysImageInfo getImageInfoByPk(long pk){
		return sysImageInfodao.getByPK(pk);
	}
	
	public SysAttachmentInfo getAttachmentInfoByPk(long pk){
		return sysAttachmentDao.getByPK(pk);
	}
}
