package com.dziennik.web;

import com.dziennik.domain.Student;
import com.dziennik.service.StudentManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/view/*")
public class ViewStudentServlet extends HttpServlet{
	@EJB
    private StudentManager studentStorage;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long studentID = WebUtils.getStudentID(request);
		
		Student student = studentStorage.get(studentID);
		request.setAttribute("student", student);
		request.setAttribute("notes", student.getComments());
		request.getRequestDispatcher("/student/view.jsp").forward(request, response);
    }
}