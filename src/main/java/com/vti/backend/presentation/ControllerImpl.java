package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.business.ServiceImpl;
import com.vti.backend.business.IService;
import com.vti.entity.Account;
import com.vti.exc.AccountNotFoundException;

public class ControllerImpl implements IController {

	private IService service;
	
	
	public ControllerImpl() {
		service = new ServiceImpl();
	}
	
	
	public List<Account> getAllAccount() throws SQLException {
		return service.getAllAccount();
	}


	public Account findAccountByUserName(String uName) throws SQLException {
		if (uName.isBlank() || uName.isEmpty()) {
			return null;
		}
		return service.findAccByUserName(uName);
	}


	public boolean createAccount(Account account) throws SQLException {
		return service.createAccount(account);
	}


	public String updateAccount(int oldId, String newUserName, String newEmail) throws SQLException {
		return service.updateAccount(oldId, newUserName, newEmail);
	}


	public boolean deleteAcc(String userName) throws Exception {
		if (userName == null || userName == "") {
			throw new Exception("Không được để trống username");
		}
		return service.deleteAccount(userName);
	}


}
