package com.app.service;

import com.app.model.Customer;
import com.app.model.Employee;

import java.util.List;

import com.app.exception.BusinessException;

public interface Employeeservice {
	public List<Customer> getAllCustomers() throws BusinessException ;
	public String getPasswordByemployeeId(long employeeid) throws BusinessException;
	public long getemployeeid(long employeeid) throws BusinessException ;
	public boolean isValid(Employee employee) throws BusinessException;
}
