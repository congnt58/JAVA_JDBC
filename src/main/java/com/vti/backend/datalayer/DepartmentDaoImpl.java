package com.vti.backend.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JDBCUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	public List<Department> getAllDepartment() throws SQLException {
		List<Department> list = new ArrayList<Department>();

		String query = "SELECT * FROM Department";

		ResultSet resultSet = JDBCUtil.getIntance().getStatement().executeQuery(query);

		while (resultSet.next()) {
			list.add(new Department(resultSet));
		}

		return list;
	}
}
