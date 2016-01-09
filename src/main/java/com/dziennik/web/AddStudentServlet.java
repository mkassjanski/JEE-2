package com.dziennik.web;
import com.dziennik.service.StudentManager;
import com.dziennik.domain.Student;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddStudentServlet extends HttpServlet{
    @EJB
    private StudentManager studentStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String sex = request.getParameter("sex");
        Long pesel = Long.parseLong(request.getParameter("pesel"));


        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setSurname(surname);
        newStudent.setSex(sex);
        newStudent.setPesel(pesel);

        studentStorage.addStudent(newStudent);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }
}