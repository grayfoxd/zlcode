package com.iseen.member.core.service;

import com.iseen.member.core.pojo.IContractType;
import com.iseen.member.core.dao.IIContractTypeDao;
import com.iseen.member.core.iservice.IContracttypeService;
import com.centling.common.pages.Pager;
import com.iseen.member.common.pack.ContracttypePack;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContracttypeService implements IContracttypeService {

	@Resource
	private IIContractTypeDao iContractTypeDao;

	public int listIContractTypeCount(IContractType iContractType) {
		int count = iContractTypeDao.findByHqlWhereCount(ContracttypePack
				.packIContractTypeQuery(iContractType));
		return count;
	}

	public List<IContractType> listIContractType(IContractType iContractType,
			Pager pager) {
		List<IContractType> list = iContractTypeDao.findByHqlWherePage(
				ContracttypePack.packIContractTypeQuery(iContractType), pager);
		return list;
	}

	public List<IContractType> listIContractType(IContractType iContractType) {
		List<IContractType> list = iContractTypeDao
				.findByHqlWhere(ContracttypePack
						.packIContractTypeQuery(iContractType));
		return list;
	}

	public IContractType saveIContractType(IContractType iContractType) {
		IContractType temp = (IContractType) iContractTypeDao
				.save(iContractType);
		return temp;
	}

	public IContractType getIContractTypeByPk(String pk) {
		IContractType iContractType = (IContractType) iContractTypeDao
				.getByPK(pk);
		return iContractType;
	}

	public void deleteIContractTypeByPks(String[] pks) {
		for (String pk : pks) {
			IContractType iContractType = iContractTypeDao.getByPK(pk);
			iContractTypeDao.remove(iContractType);
		}
	}

	public void deleteIContractTypeByPks(String[] pks, String N) {
		for (String pk : pks) {
			IContractType iContractType = iContractTypeDao.getByPK(pk);
			iContractType.setDr("Y");
			iContractTypeDao.save(iContractType);
		}
	}
}