package com.iseen.member.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.centling.common.pages.Pager;
import com.centling.common.util.UtilPrimaryKey;
import com.iseen.member.common.pack.ServicepackagePack;
import com.iseen.member.core.dao.IIServiceDetailDao;
import com.iseen.member.core.dao.IIServicePackageDao;
import com.iseen.member.core.iservice.IServicepackageService;
import com.iseen.member.core.pojo.IServiceDetail;
import com.iseen.member.core.pojo.IServicePackage;

@Service
public class ServicepackageService implements IServicepackageService {

	@Resource
	private IIServicePackageDao iServicePackageDao;

	@Resource
	private IIServiceDetailDao iServiceDetailDao;

	public int listIServicePackageCount(IServicePackage iServicePackage) {
		int count = iServicePackageDao.findByHqlWhereCount(ServicepackagePack
				.packIServicePackageQuery(iServicePackage));
		return count;
	}

	public List<IServicePackage> listIServicePackage(
			IServicePackage iServicePackage, Pager pager) {
		List<IServicePackage> list = iServicePackageDao.findByHqlWherePage(
				ServicepackagePack.packIServicePackageQuery(iServicePackage),
				pager);
		return list;
	}

	public List<IServicePackage> listIServicePackage(
			IServicePackage iServicePackage) {
		List<IServicePackage> list = iServicePackageDao
				.findByHqlWhere(ServicepackagePack
						.packIServicePackageQuery(iServicePackage));
		return list;
	}

	public IServicePackage saveIServicePackage(IServicePackage iServicePackage) {
		IServicePackage temp = (IServicePackage) iServicePackageDao
				.save(iServicePackage);
		return temp;
	}

	public IServicePackage getIServicePackageByPk(String pk) {
		IServicePackage iServicePackage = (IServicePackage) iServicePackageDao
				.getByPK(pk);
		return iServicePackage;
	}

	public void deleteIServicePackageByPks(String[] pks) {
		for (String pk : pks) {
			IServicePackage iServicePackage = iServicePackageDao.getByPK(pk);
			iServicePackage.setDr("Y");
			iServicePackageDao.save(iServicePackage);
			iServiceDetailDao
					.executeSql(" update i_service_detail set dr='Y' where i_service_package_id='"
							+ pk + "'");
		}
	}

	public void saveServicePackageAndDetail(IServicePackage iServicePackage,
			String[] serviceInfoids) {
		// TODO Auto-generated method stub
		this.saveIServicePackage(iServicePackage);
		IServicePackage tmp = (IServicePackage) iServicePackageDao
				.save(iServicePackage);
		iServiceDetailDao.executeSql("delete from i_service_detail where"
				+ " i_service_package_id='" + iServicePackage.getPrimaryKey()
				+ "'");
		for (String id : serviceInfoids) {
			IServiceDetail detail = new IServiceDetail();
			detail.setPrimaryKey(UtilPrimaryKey.getPrimaryKey());
			detail.setIservicepackageid(tmp.getPrimaryKey());
			detail.setIserviceinfoid(id);
			detail.setDr("N");
			iServiceDetailDao.save(detail);
		}

	}

	public List<IServiceDetail> servicedetail(String iServicePackagepkpk) {
		// TODO Auto-generated method stub
		List<IServiceDetail> list = iServiceDetailDao
				.findByHqlWhere(ServicepackagePack
						.packiservicedetail(iServicePackagepkpk));
		return list;
	}
}