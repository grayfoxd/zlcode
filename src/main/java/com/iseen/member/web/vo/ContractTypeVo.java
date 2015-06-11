package com.iseen.member.web.vo;


/**
 * 合同类型vo
 * @author JasonFeng
 *
 */
public class ContractTypeVo {

	private String contractTypeCode;
	
	private String contractTypeName;
	
    private String firstOperator;

    private String firstOperatorTime;
    
    private String lastOperator;

    private String lastOperatorTime;

    private String memo;

	public String getContractTypeCode() {
		return contractTypeCode;
	}

	public void setContractTypeCode(String contractTypeCode) {
		this.contractTypeCode = contractTypeCode;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public String getFirstOperator() {
		return firstOperator;
	}

	public void setFirstOperator(String firstOperator) {
		this.firstOperator = firstOperator;
	}

	public String getFirstOperatorTime() {
		return firstOperatorTime;
	}

	public void setFirstOperatorTime(String firstOperatorTime) {
		this.firstOperatorTime = firstOperatorTime;
	}

	public String getLastOperator() {
		return lastOperator;
	}

	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}

	public String getLastOperatorTime() {
		return lastOperatorTime;
	}

	public void setLastOperatorTime(String lastOperatorTime) {
		this.lastOperatorTime = lastOperatorTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
