package com.app.model;

public class Employee {
	
	private long employeeid;
	private String employeename;
	private String employeepassword;
	
	public Employee() {}

	public Employee(String employeename, String employeepassword) {
		super();
		this.employeename = employeename;
		this.employeepassword = employeepassword;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeepassword() {
		return employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeepassword="
				+ employeepassword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeid ^ (employeeid >>> 32));
		result = prime * result + ((employeename == null) ? 0 : employeename.hashCode());
		result = prime * result + ((employeepassword == null) ? 0 : employeepassword.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeid != other.employeeid)
			return false;
		if (employeename == null) {
			if (other.employeename != null)
				return false;
		} else if (!employeename.equals(other.employeename))
			return false;
		if (employeepassword == null) {
			if (other.employeepassword != null)
				return false;
		} else if (!employeepassword.equals(other.employeepassword))
			return false;
		return true;
	}
	
	
	

}
