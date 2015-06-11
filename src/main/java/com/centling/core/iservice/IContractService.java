package com.centling.core.iservice;

import com.centling.core.pojo.HrmContract;
import com.centling.core.pojo.HrmContractType;
import java.util.List;
import com.centling.common.pages.Pager;

public interface IContractService{

    public int listHrmContractCount(HrmContract hrmContract);
    public List<HrmContract> listHrmContract(HrmContract hrmContract, Pager pager);
    public HrmContract saveHrmContract(HrmContract hrmContract);
    public HrmContract getHrmContractByPk(String pk);
    public void deleteHrmContractByPks(String[] pks);

    public int listHrmContractTypeCount(HrmContractType hrmContractType);
    public List<HrmContractType> listHrmContractType(HrmContractType hrmContractType, Pager pager);
    public HrmContractType saveHrmContractType(HrmContractType hrmContractType);
    public HrmContractType getHrmContractTypeByPk(String pk);
    public void deleteHrmContractTypeByPks(String[] pks);

}