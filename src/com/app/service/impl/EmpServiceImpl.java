package com.app.service.impl;

import java.util.List;

import com.app.dao.IEmpDao;
import com.app.dao.impl.EmpDaoImpl;
import com.app.model.Employee;
import com.app.service.IEmpService;

public class EmpServiceImpl implements IEmpService  {

	private IEmpDao dao;
	public EmpServiceImpl() {
		dao = new EmpDaoImpl();
	}
	@Override
	public String saveEmp(Employee emp) {

		return dao.saveEmp(emp);
	}

	@Override
	public List<Employee> getAllEmp() {

		return dao.getAllEmp();
	}

}
