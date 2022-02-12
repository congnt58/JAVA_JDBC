package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface AccountDao {
	
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccByUserName(String uNameLowerCase) throws SQLException;

	public int createAccount(Account account) throws SQLException;

	public int updateAccount(Account account) throws SQLException;

	public Account findAccByID(int oldId) throws SQLException;

	public int deleteAccount(String userName) throws SQLException;


}
