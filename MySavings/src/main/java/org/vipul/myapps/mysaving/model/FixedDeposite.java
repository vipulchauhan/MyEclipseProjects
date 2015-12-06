package org.vipul.myapps.mysaving.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.vipul.myapps.mysaving.utils.SavingsUtil;

@Entity
public class FixedDeposite implements Account {

	@Id
	@GeneratedValue
	private Long id;
	private String accountNo;
	private Double interestRate;
	private Double balance;
	private Date startDate;
	private Date endDate;
	private Double endBalance;

	public FixedDeposite(String accountNo, Double interestRate, Double balance, Date startDate, Date endDate,
			Double endBalance) {
		super();
		this.accountNo = accountNo;
		this.interestRate = interestRate;
		this.balance = balance;
		this.startDate = startDate;
		this.endDate = endDate;
		this.endBalance = endBalance;
	}

	public FixedDeposite() {
		super();
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return SavingsUtil.dateString(startDate);

	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return SavingsUtil.dateString(endDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(Double endBalance) {
		this.endBalance = endBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FixedDeposite other = (FixedDeposite) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FixedDeposite [id=" + id + ", accountNo=" + accountNo + ", interestRate=" + interestRate + ", balance="
				+ balance + ", startDate=" + startDate + ", endDate=" + endDate + ", endBalance=" + endBalance + "]";
	}

}
