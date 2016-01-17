package com.dziennik.web;
import com.dziennik.service.StudentManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit/*")
public class UpdateStudentServlet extends HttpServlet{
    @EJB
    private StudentManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getStudentID(request);

        request.setAttribute("student", storage.get(messageID));
        request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String sex = request.getParameter("sex");
        Long pesel = Long.parseLong(request.getParameter("pesel"));
        
        Long studentID = WebUtils.getStudentID(request);

        storage.update(studentID, name, surname, sex, pesel);

        WebUtils.redirectToStudentView(request, response, studentID);
    }
}