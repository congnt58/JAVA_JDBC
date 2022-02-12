package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;
import com.vti.exc.AccountNotFoundException;

public interface IAccountController {
	public List<Account> getAllAccount() throws SQLException;

	public Account findAccountByUserName(String uName) throws SQLException;

	public boolean createAccount(Account account) throws SQLException;

	public String updateAccount(int oldId, String newUserName, String newEmail) throws SQLException;

	public boolean deleteAcc(String userName) throws Exception;
}
