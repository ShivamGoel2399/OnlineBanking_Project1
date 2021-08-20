package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.Bankdao;
import com.app.dbutil.PostgresConnection;
import com.app.exception.BusinessException;
import com.app.model.Account;
import com.app.model.Customer;
import com.app.model.Employee;
import com.app.model.Transaction;
import com.app.service.impl.Customerserviceimpl;



public class Bankdaoimpl implements Bankdao{
	
	private static Logger log = Logger.getLogger(Bankdaoimpl.class);
	
	 @Override
	public long getemployeeid(long employeeid) throws BusinessException{
		 long tid =0;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select employeeid from banking_schema.employee where employeeid=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setLong(1, employeeid);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 tid=resultset.getLong("employeeid");
		
			 }
		 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return tid;
		} 

	@Override
	public Customer registercustomer(Customer customer) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			
			String sql = ("insert into banking_schema.customer(customername,customerphoneno,customergender,customeremailId,customerpassword,customerpancard) values(?,?,?,?,?,?)");
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, customer.getCustomername());
			preparedStatement.setLong(2, customer.getCustomerphoneno());	
			preparedStatement.setString(3, customer.getCustomergender());
			preparedStatement.setString(4, customer.getCustomeremailid());
			preparedStatement.setString(5, customer.getCustomerpassword());
			preparedStatement.setString(6, customer.getCustomerpancard());
		    
			int c = preparedStatement.executeUpdate();
			
			if (c == 1 ) {
				System.out.println("Registration Successful");
				ResultSet resultset = preparedStatement.getGeneratedKeys();
				if(resultset.next()) {
					customer.setCustomerid(resultset.getLong(1));
				}
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
		}
		return customer;
	}

	



	@Override
	public String getpasswordbycustomerid(long customerid) throws BusinessException {
		String customer=null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="select customerid,customerpassword from banking_schema.customer where customerid=?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setLong(1, customerid);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next() ) { 
				customer = resultSet.getString("customerpassword");
			}else {
				throw new BusinessException("Invalid UserId or Password.Exception From DAOLayer ");
			}		
		}catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
		}
		return customer;
	}



	@Override
	public Account createAccount(Account account) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="insert into banking_schema.account(customerid,accounttype,customeraadharno,accountbalance) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1, account.getCustomerid());
			preparedStatement.setString(2, account.getAccounttype());
			preparedStatement.setString(3, account.getCustomeraadharno());
			preparedStatement.setDouble(4, account.getAccountbalance());
			int c = preparedStatement.executeUpdate();
			
			if (c == 1 ) {
				System.out.println("Account Opened Successfully");
				ResultSet resultset = preparedStatement.getGeneratedKeys();
				if(resultset.next()) {
					account.setCustomeraccountno(resultset.getLong(5));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
		}
		return account;
	}





	@Override
	public List<Customer> getAllCustomers() throws BusinessException {
         List<Customer> customerList=new ArrayList<>();
		
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="select * from banking_schema.customer order by customerid";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				
				Customer customer=new Customer();
				customer.setCustomerid(resultSet.getLong("customerid"));
				customer.setCustomername(resultSet.getString("customername"));
				customer.setCustomergender(resultSet.getString("customergender"));
				customer.setCustomeremailid(resultSet.getString("customeremailid"));
				customer.setCustomerphoneno(resultSet.getLong("customerphoneno"));
				customer.setCustomerpassword(resultSet.getString("customerpassword"));
				customerList.add(customer);
			}
			if(customerList.size()==0) {
				throw new BusinessException("No customer exist");
			} 
			else {
				return customerList;
			}
		}catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
		}
	}





	@Override
	public String getPasswordByemployeeId(long employeeid) throws BusinessException {
		String employee=null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql="select employeepassword from banking_schema.employee where employeeid=?";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setLong(1, employeeid);
			ResultSet resultset=preparedStatement.executeQuery();
			
			if (resultset.next() ) { 
				employee=resultset.getString("employeepassword");
			}else {
				throw new BusinessException("Invalid EmployeeId or Password. Exception From DAOLayer");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
		}
		return employee;
	}

	@Override
	public long getcustomerid(long customerid) throws BusinessException {
		long tid =0;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select customerid from banking_schema.customer where customerid=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setLong(1, customerid);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 tid=resultset.getLong("customerid");
			 }	 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return tid;
	}

	@Override
	public boolean isValid(Employee employee) throws BusinessException {
		boolean flag = false;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="select employeename from banking_schema.employee where employeename =? and employeepassword =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmployeename());
			preparedStatement.setString(2,employee.getEmployeepassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				flag=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Error Occured. Kindly contact ShivuBank Admin");
		}
		return flag;
	}

	@Override
	public boolean isValidcustomer(Customer customer) throws BusinessException {
		boolean flag = false;
		try(Connection connection = PostgresConnection.getConnection()){
			String sql="select customername from banking_schema.customer where customername =? and customerpassword =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getCustomername());
			preparedStatement.setString(2,customer.getCustomerpassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				flag=true;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.warn(e.getMessage());
			throw new BusinessException("Internal Error Occured. Kindly contact ShivuBank Admin");
		}
		return flag;
	}
	@Override
	public long getaccountno(long accountno) throws BusinessException {
		long taccountno =0;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select accountno from banking_schema.account where accountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setLong(1, accountno);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 taccountno=resultset.getLong("accountno");
			 }	 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return taccountno;
	}

	@Override
	public float checkbalancebyaccountno(long accountno) throws BusinessException {
		float taccountbalance =0;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select accountbalance from banking_schema.account where customeraccountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setLong(1, accountno);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 taccountbalance=resultset.getLong("accountbalance");
			 }	 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return taccountbalance;
	}

	@Override
	public float withdraw(float balance,float amount,long accountno) throws BusinessException {
		String s ="Withdrawl: "+amount;
		transaction(s, accountno);
		float totalaccountbalance =balance-amount;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql="Update banking_schema.account set accountbalance=? where customeraccountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setFloat(1, totalaccountbalance);
			 preparedStatement.setLong(2, accountno);
			 int c = preparedStatement.executeUpdate();
				
				if (c == 1 ) {
					System.out.println("Withdraw is Successful");
					 }	 
			 }catch (ClassNotFoundException | SQLException e) {
				 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return totalaccountbalance;
	}

	@Override
	public String getcustomernamebyaccountno(long accountno) throws BusinessException {
		String tcustomername =null;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select c.customername from banking_schema.customer c join banking_schema.account on c.customerid = (select a.customerid from banking_schema.account a where accountno=?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setLong(1, accountno);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 tcustomername=resultset.getString("customername");
			 }	 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return tcustomername;
	}

	@Override
	public void transaction(String transactiontype, long accountno) throws BusinessException{
		
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql="insert into banking_schema.transaction(transactiontype,customeraccountno) values (?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 preparedStatement.setString(1, transactiontype);
			 preparedStatement.setLong(2, accountno);
			 preparedStatement.executeUpdate();
			
			 }catch(ClassNotFoundException | SQLException e) {
				 log.warn(e.getMessage());
					throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
			 }
		
	}

	@Override
	public float deposit(float balance, float amount, long accountno) throws BusinessException {
		String s ="Deposited : "+amount;
		transaction(s, accountno);
		float totalaccountbalance =balance+amount;
		System.out.println(totalaccountbalance);
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql="Update banking_schema.account set accountbalance=? where customeraccountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setFloat(1, totalaccountbalance);
			 
			 preparedStatement.setLong(2, accountno);
			 int c = preparedStatement.executeUpdate();
				
				if (c == 1 ) {
					System.out.println("Money Deposited Successfully");
				
					 }	 
			 }catch (ClassNotFoundException | SQLException e) {
				 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return totalaccountbalance;
	}

	@Override
	public long getcustomerid(String customername) throws BusinessException {
		long tid =0;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql = "select customerid from banking_schema.customer where customername=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, customername);
			 ResultSet resultset = preparedStatement.executeQuery();
			 if(resultset.next()) {
				 tid=resultset.getLong("customerid");
			 }	 
		 }catch (ClassNotFoundException | SQLException e) {
			 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return tid;
	}

	@Override
	public List<Transaction> getAllTransaction(long accountno) throws BusinessException {
		 List<Transaction> transactionList=new ArrayList<>();
			
			try (Connection connection = PostgresConnection.getConnection()) {
				String sql="select * from banking_schema.transaction where customeraccountno=?";
				
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setLong(1, accountno);
				ResultSet resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
					
					Transaction transaction=new Transaction();
					transaction.setTransactionid(resultSet.getLong("transactionid"));
					transaction.setTransactiontype(resultSet.getString("transactiontype"));
					transaction.setCustomeraccountno(resultSet.getLong("customeraccountno"));
					transactionList.add(transaction);
				}
				if(transactionList.size()==0) {
					throw new BusinessException("No transaction exist");
				} 
				else {
					return transactionList;
				}
			}catch (ClassNotFoundException | SQLException e) {
				log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
			}
	}
	@Override
	public float transdeposit(float balance, float amount, long accountno) throws BusinessException {
		String s ="Credited : "+amount;
		transaction(s, accountno);
		float totalaccountbalance =balance+amount;
		System.out.println(totalaccountbalance);
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql="Update banking_schema.account set accountbalance=? where customeraccountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setFloat(1, totalaccountbalance);
			 
			 preparedStatement.setLong(2, accountno);
			 int c = preparedStatement.executeUpdate();
				
				if (c == 1 ) {
					System.out.println("Money Deposited Successfully");
				
					 }	 
			 }catch (ClassNotFoundException | SQLException e) {
				 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return totalaccountbalance;
	}
	
	@Override
	public float transwithdraw(float balance,float amount,long accountno) throws BusinessException {
		String s ="debited : "+amount;
		transaction(s, accountno);
		float totalaccountbalance =balance-amount;
		 try (Connection connection = PostgresConnection.getConnection()) {
			 String sql="Update banking_schema.account set accountbalance=? where customeraccountno=?";
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setFloat(1, totalaccountbalance);
			 preparedStatement.setLong(2, accountno);
			 int c = preparedStatement.executeUpdate();
				
				if (c == 1 ) {
					System.out.println("Withdraw is Successful");
					 }	 
			 }catch (ClassNotFoundException | SQLException e) {
				 log.warn(e.getMessage());
				throw new BusinessException("Internal ERROR occured. Kindly contact SYSTEM ADMIN. Exception From DAOLayer");
				}
		 return totalaccountbalance;
	}
}
