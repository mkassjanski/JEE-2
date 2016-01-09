package com.dziennik.web;

import com.dziennik.service.StudentManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class MainStudentServlet extends HttpServlet{
	@EJB
    private StudentManager studentStorage;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("students", studentStorage.getAllStudent());
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
