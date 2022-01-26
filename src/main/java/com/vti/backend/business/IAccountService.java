package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountService {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccByUserName(String uName) throws SQLException;

	public boolean createAccount(Account account) throws SQLException;
}
