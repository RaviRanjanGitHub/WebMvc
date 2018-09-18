package com.app.model;

public class Employee {
private int empId;
private String empName;
private float empSal;
private String gender;
private String empType;
private String empAddr;
public Employee() {
	super();
}
public Employee(int empId) {
	super();
	this.empId = empId;
}
public Employee(int empId, String empName, float empSal, String gender, String empType, String empAddr) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empSal = empSal;
	this.gender = gender;
	this.empType = empType;
	this.empAddr = empAddr;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public float getEmpSal() {
	return empSal;
}
public void setEmpSal(float empSal) {
	this.empSal = empSal;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmpType() {
	return empType;
}
public void setEmpType(String empType) {
	this.empType = empType;
}
public String getEmpAddr() {
	return empAddr;
}
public void setEmpAddr(String empAddr) {
	this.empAddr = empAddr;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", gender=" + gender
			+ ", empType=" + empType + ", empAddr=" + empAddr + "]";
 }
}