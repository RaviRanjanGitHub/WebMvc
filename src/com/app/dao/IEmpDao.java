package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmpDao {
	public String saveEmp(Employee emp);

	public List<Employee> getAllEmp();
}
