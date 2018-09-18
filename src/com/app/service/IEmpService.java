package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmpService {
	public String saveEmp(Employee emp);
	public List<Employee> getAllEmp();
}
