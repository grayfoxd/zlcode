package com.centling.core.iservice;

import com.centling.core.pojo.SysAttachmentInfo;
import com.centling.core.pojo.SysImageInfo;

public interface IFileProcessService {
	public SysImageInfo getImageInfoByPk(long pk);
	
	public SysAttachmentInfo getAttachmentInfoByPk(long pk);
}
