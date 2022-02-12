package com.vti.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
	private int id;

	public Department(ResultSet resultSet) throws SQLException {
		this.id = resultSet.getInt("DepartmentID");
	}

	
}
