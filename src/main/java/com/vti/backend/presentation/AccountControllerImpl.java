package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.business.AccountServiceImpl;
import com.vti.backend.business.IAccountService;
import com.vti.entity.Account;

public class AccountControllerImpl implements IAccountController {

	private IAccountService accService;
	
	
	public AccountControllerImpl() {
		accService = new AccountServiceImpl();
	}
	
	
	public List<Account> getAllAccount() throws SQLException {
		return accService.getAllAccount();
	}


	public Account findAccountByUserName(String uName) throws SQLException {
		if (uName.isBlank() || uName.isEmpty()) {
			return null;
		}
		return accService.findAccByUserName(uName);
	}


	public boolean createAccount(Account account) throws SQLException {
		return accService.createAccount(account);
	}


	public String updateAccount(int oldId, String newUserName, String newEmail) throws SQLException {
		return accService.updateAccount(oldId, newUserName, newEmail);
	}


}
