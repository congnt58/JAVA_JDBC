package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.utils.JDBCUtil;

public class AccountDaoImpl implements AccountDao {

	public List<Account> getAllAccount() throws SQLException {
		List<Account> list = new ArrayList<Account>();

		String query = "SELECT * FROM Account";

		ResultSet resultSet = JDBCUtil.getIntance().getStatement().executeQuery(query);

		while (resultSet.next()) {
			list.add(new Account(resultSet));
		}

		return list;
	}

	public Account findAccByUserName(String uNameLowerCase) throws SQLException {
		
		String query= "Select * From Account WHERE username = ?";
		PreparedStatement prdStatement = JDBCUtil.getIntance().getPreparedStatement(query);
		prdStatement.setString(1, uNameLowerCase);
		
		ResultSet resultSet = prdStatement.executeQuery();
		
		if (resultSet.next()) {
			return new Account(resultSet);
		}
		return null;
	}

	public int createAccount(Account account) throws SQLException {
		String queryString = "insert into Account (`Email`, `UserName`) Values (?,?)";
		
		PreparedStatement prdStatement = JDBCUtil.getIntance().getPreparedStatement(queryString);
		
		prdStatement.setString(1, account.getEmail());
		prdStatement.setString(2, account.getUserName());
		
		return prdStatement.executeUpdate();
	}

}