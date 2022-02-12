package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountDao;
import com.vti.backend.datalayer.AccountDaoImpl;
import com.vti.entity.Account;
import com.vti.exc.AccountNotFoundException;

public class AccountServiceImpl implements IAccountService {

	private AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}

	public List<Account> getAllAccount() throws SQLException {
		return accountDao.getAllAccount();
	}

	public Account findAccByUserName(String uName) throws SQLException {
		// logic
		String uNameLowerCase = uName.toLowerCase().trim();

		return accountDao.findAccByUserName(uNameLowerCase);
	}

	public boolean createAccount(Account account) throws SQLException {
		if (accountDao.createAccount(account) > 0) {
			return true;
		}
		return false;
	}

	public String updateAccount(int oldId, String newUserName, String newEmail) throws SQLException {
		String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

//		String USERNAME_PATTERN = "^vti_.*";
		Account account = accountDao.findAccByID(oldId);
		if (account == null) {
			return "Không tìm thấy account có id = " + oldId;
		}

		if (newUserName != null) {
//			if (newUserName.matches(USERNAME_PATTERN)) {
			account.setUserName(newUserName);
//			}else {
//				return "UserName sai định dạng => vti_*********";
//			}	
		}
		if (newEmail != null) {
			if (newEmail.matches(EMAIL_PATTERN)) {
				account.setEmail(newEmail);
			} else {
				return "Update thất bại => Email truyền vào sai định dạng";
			}
		}

		int count = accountDao.updateAccount(account);

		if (count > 0) {
			return "Update thành công";
		} else {
			return "Update thất bại";
		}
	}
	
	public boolean deleteAccount(String userName) throws SQLException, AccountNotFoundException  {
		if (findAccByUserName(userName) == null) {
			throw new AccountNotFoundException("Không thể xóa tài khoản không có trong danh sách");
		}
		
		int a = accountDao.deleteAccount(userName);
		if (a > 0) {
			return true;
		}
		return false;
	}

}
