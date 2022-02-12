package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface DepartmentDao {

	List<Department> getAllDepartment() throws SQLException;

}
