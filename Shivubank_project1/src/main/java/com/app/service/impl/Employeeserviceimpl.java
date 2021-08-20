package com.app.service.impl;


import java.util.ArrayList;
import java.util.List;



import com.app.dao.Bankdao;
import com.app.dao.impl.Bankdaoimpl;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.service.Employeeservice;

public class Employeeserviceimpl implements Employeeservice {

	private Bankdao bankdao= new Bankdaoimpl();

	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customerList=new ArrayList<>();

		if(customerList!=null) {
			customerList=bankdao.getAllCustomers();
		}
		
		return customerList;
	}

	@Override
	public String getPasswordByemployeeId(long employeeid) throws BusinessException {
		String employee= null;
		if(employeeid == 0) {
			throw new BusinessException("enter correct Userid");
		}else {
			employee=bankdao.getPasswordByemployeeId(employeeid);
		}
		return employee;
	}

	@Override
	public long getemployeeid(long employeeid) throws BusinessException {
		if(employeeid == 0) {
			throw new BusinessException("enter correct Userid");
		}else {
		return bankdao.getemployeeid(employeeid);
		}
	}

	@Override
	public boolean isValid(Employee employee) throws BusinessException {
		boolean flag = false;
		if(employee.getEmployeename()!=null && employee.getEmployeepassword()!=null) {
			flag = bankdao.isValid(employee);
		}
		else {
			throw new BusinessException("Invalid Username And Password");
		}
		return flag;
	}
	

}
