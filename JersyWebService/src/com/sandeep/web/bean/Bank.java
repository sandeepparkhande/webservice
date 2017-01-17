package com.sandeep.web.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;


@XmlRootElement
public class Bank{
	
	private String employeeId;
	private String employeeName;
	private String bankName;
	private String bankBalance;
	
	public Bank() {
	}
	public String getBankName() {
		return bankName;
	}
	
	@XmlElement
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankBalance() {
		return bankBalance;
	}
	
	@XmlElement
	public void setBankBalance(String bankBalance) {
		this.bankBalance = bankBalance;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	@XmlElement
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	
	public String getEmployeeName() {
		return employeeName;
	}
	@XmlElement
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Bank(String employeeId, String employeeName, String bankName, String bankBalance) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.bankName = bankName;
		this.bankBalance = bankBalance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankBalance == null) ? 0 : bankBalance.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (bankBalance == null) {
			if (other.bankBalance != null)
				return false;
		} else if (!bankBalance.equals(other.bankBalance))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}
	
}
