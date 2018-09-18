package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Employee;
import com.app.service.IEmpService;
import com.app.service.impl.EmpServiceImpl;

public class EmpServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		Employee emp = null;
		IEmpService service = new EmpServiceImpl();
		String status = "";
		if(action.equalsIgnoreCase("Register")) {
			int eid =Integer.parseInt(request.getParameter("eid"));
			String ename = request.getParameter("ename");
			Float esal =Float.parseFloat(request.getParameter("esal"));
			String gender = request.getParameter("gender");
			String etype = request.getParameter("etype");
			String eaddr = request.getParameter("eaddr");
			emp = new Employee();
			emp.setEmpId(eid);
			emp.setEmpName(ename);emp.setEmpSal(esal);
			emp.setGender(gender);emp.setEmpType(etype);
			emp.setEmpAddr(eaddr);
			status = service.saveEmp(emp);
			RequestDispatcher rd = null;
			if(status.equals("success")) {
				rd = request.getRequestDispatcher("success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure")){
			rd = request.getRequestDispatcher("failure.html");
			rd.forward(request, response);
			}
			if(status.equals("exist")){
				rd = request.getRequestDispatcher("exist.html");
				rd.forward(request, response);
				}
		}
		if(action.equalsIgnoreCase("ViewAll")) {
			List<Employee> list_emp =service.getAllEmp();
			out.println("<html><body> ");
			out.println("<h1>Employee Details</h1>");
			out.println("<table> ");
			out.println("<tr><td>EID</td><td>ENAME</td><td>ESAL</td><td>GENDER</td><td>TYPE</td><td>ADDRESS</td> </tr>");
			for(Employee e:list_emp) {
				out.println("<tr>");
			out.println("<td>"+e.getEmpId()+"</td>");
			out.println("<td>"+e.getEmpName()+"</td>");
			out.println("<td>"+e.getEmpSal()+"</td>");
			out.println("<td>"+e.getGender()+"</td>");
			out.println("<td>"+e.getEmpType()+"</td>");
			out.println("<td>"+e.getEmpAddr()+"</td>");
			out.println("</tr>");
			}
			out.println("</table></body></html>");
		}
		
	}
}