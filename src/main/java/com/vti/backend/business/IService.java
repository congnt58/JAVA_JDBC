package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.exc.AccountNotFoundException;

public interface IService {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccByUserName(String uName) throws SQLException;

	public boolean createAccount(Account account) throws SQLException;

	public String updateAccount(int oldId, String newUserName, String newEmail) throws SQLException;

	public boolean deleteAccount(String userName) throws SQLException, AccountNotFoundException;
	
	public List<Department> getAllDepartment() throws SQLException;
}
