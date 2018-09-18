package com.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.IEmpDao;
import com.app.factory.ConnectionFactory;
import com.app.model.Employee;

public class EmpDaoImpl implements IEmpDao {
	private String status = "";
	private Connection con = null;

	@Override
	public String saveEmp(Employee emp) {
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from empmvctab where eid = ? ");
			pst.setInt(1, emp.getEmpId());
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true) {
				status = "exist";
			} else {
				pst = con.prepareStatement("insert into empmvctab values(?,?,?,?,?,?)");
				pst.setInt(1, emp.getEmpId());
				pst.setString(2, emp.getEmpName());
				pst.setFloat(3, emp.getEmpSal());
				pst.setString(4, emp.getGender());
				pst.setString(5, emp.getEmpType());
				pst.setString(6, emp.getEmpAddr());
				int i = pst.executeUpdate();
				if (i > 0)
					status = "success";
				else
					status = "failure";
			}

		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> list_emp = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from empmvctab");
			ResultSet rs = pst.executeQuery();
			Employee emp = null;
			list_emp = new ArrayList<Employee>();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt("EID"));
				emp.setEmpName(rs.getString("ENAME"));
				emp.setEmpSal(rs.getFloat("ESAL"));
				emp.setGender(rs.getString("GENDER"));
				emp.setEmpType(rs.getString("ETYPE"));
				emp.setEmpAddr(rs.getString("EADDR"));
				list_emp.add(emp);

			}
		} catch (Exception e) {
			list_emp = null;
			e.printStackTrace();
		}
		return list_emp;
	}
}
