package com.vti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.utils.ScannerUtil;

public class Account {
	
	private int id;
	private String email;
	private String userName;
	
	public Account(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt("AccountID");
		this.email = resultSet.getString("Email");
		this.userName = resultSet.getString("Username");
	}
	
	public Account(int id, String email, String userName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
	}

	public Account() {
		
	}
	
	public void scanInfo() {
		System.out.print("Nhập email: ");
		this.email = ScannerUtil.scString();
		System.out.print("Nhập userName: ");
		this.userName = ScannerUtil.scString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String stringTable() {
		return String.format(" %3d | %-30s| %-10s", id, email, userName);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + "]";
	}

}
