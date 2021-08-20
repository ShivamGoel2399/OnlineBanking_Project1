package com.app.model;

public class Customer {
	
	private long customerid;
	private String customername;
	private long customerphoneno;
	private String customergender;
	private String customerpassword;
	private String customeremailid;
	private String customerpancard;

	public Customer() {}

	public Customer( String customername, long customerphoneno, String customergender,
			String customerpassword, String customeremailid, String customerpancard) {
		super();
		this.customername = customername;
		this.customerphoneno = customerphoneno;
		this.customergender = customergender;
		this.customerpassword = customerpassword;
		this.customeremailid = customeremailid;
		this.customerpancard = customerpancard;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public long getCustomerphoneno() {
		return customerphoneno;
	}

	public void setCustomerphoneno(long customerphoneno) {
		this.customerphoneno = customerphoneno;
	}

	public String getCustomergender() {
		return customergender;
	}

	public void setCustomergender(String customergender) {
		this.customergender = customergender;
	}

	public String getCustomerpassword() {
		return customerpassword;
	}

	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public String getCustomerpancard() {
		return customerpancard;
	}

	public void setCustomerpancard(String customerpancard) {
		this.customerpancard = customerpancard;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customerphoneno="
				+ customerphoneno + ", customergender=" + customergender + ", customerpassword=" + customerpassword
				+ ", customeremailid=" + customeremailid + ", customerpancard=" + customerpancard + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customeremailid == null) ? 0 : customeremailid.hashCode());
		result = prime * result + ((customergender == null) ? 0 : customergender.hashCode());
		result = prime * result + (int) (customerid ^ (customerid >>> 32));
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + ((customerpancard == null) ? 0 : customerpancard.hashCode());
		result = prime * result + ((customerpassword == null) ? 0 : customerpassword.hashCode());
		result = prime * result + (int) (customerphoneno ^ (customerphoneno >>> 32));
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
		Customer other = (Customer) obj;
		if (customeremailid == null) {
			if (other.customeremailid != null)
				return false;
		} else if (!customeremailid.equals(other.customeremailid))
			return false;
		if (customergender == null) {
			if (other.customergender != null)
				return false;
		} else if (!customergender.equals(other.customergender))
			return false;
		if (customerid != other.customerid)
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (customerpancard == null) {
			if (other.customerpancard != null)
				return false;
		} else if (!customerpancard.equals(other.customerpancard))
			return false;
		if (customerpassword == null) {
			if (other.customerpassword != null)
				return false;
		} else if (!customerpassword.equals(other.customerpassword))
			return false;
		if (customerphoneno != other.customerphoneno)
			return false;
		return true;
	}

	
	
	
	
	

}
