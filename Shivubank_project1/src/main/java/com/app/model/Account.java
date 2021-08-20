package com.app.model;

public class Account {
	
	private long customeraccountno;
	private float accountbalance;
	private String accounttype;
	private boolean accountstatus;
	private long customerid;
	private String customeraadharno;
	
    public Account() {	}

	public Account(float accountbalance, String accounttype, long customerid,
			String customeraadharno) {
		super();
		this.accountbalance = accountbalance;
		this.accounttype = accounttype;
		this.customerid = customerid;
		this.customeraadharno = customeraadharno;
	}

	public long getCustomeraccountno() {
		return customeraccountno;
	}

	public void setCustomeraccountno(long customeraccountno) {
		this.customeraccountno = customeraccountno;
	}

	public float getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(float accountbalance) {
		this.accountbalance = accountbalance;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public boolean isAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(boolean accountstatus) {
		this.accountstatus = accountstatus;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getCustomeraadharno() {
		return customeraadharno;
	}

	public void setCustomeraadharno(String customeraadharno) {
		this.customeraadharno = customeraadharno;
	}

	@Override
	public String toString() {
		return "Account [customeraccountno=" + customeraccountno + ", accountbalance=" + accountbalance
				+ ", accounttype=" + accounttype + ", accountstatus=" + accountstatus + ", customerid=" + customerid
				+ ", customeraadharno=" + customeraadharno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountbalance);
		result = prime * result + (accountstatus ? 1231 : 1237);
		result = prime * result + ((accounttype == null) ? 0 : accounttype.hashCode());
		result = prime * result + ((customeraadharno == null) ? 0 : customeraadharno.hashCode());
		result = prime * result + (int) (customeraccountno ^ (customeraccountno >>> 32));
		result = prime * result + (int) (customerid ^ (customerid >>> 32));
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
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountbalance) != Float.floatToIntBits(other.accountbalance))
			return false;
		if (accountstatus != other.accountstatus)
			return false;
		if (accounttype == null) {
			if (other.accounttype != null)
				return false;
		} else if (!accounttype.equals(other.accounttype))
			return false;
		if (customeraadharno == null) {
			if (other.customeraadharno != null)
				return false;
		} else if (!customeraadharno.equals(other.customeraadharno))
			return false;
		if (customeraccountno != other.customeraccountno)
			return false;
		if (customerid != other.customerid)
			return false;
		return true;
	}
    
    
    
}
