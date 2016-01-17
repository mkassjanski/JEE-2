package com.dziennik.web;
import com.dziennik.service.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/remove/*")
public class RemoveStudentServlet extends HttpServlet{
    @EJB
    private StudentManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long studentID = WebUtils.getStudentID(request);

        storage.delete(studentID);

        WebUtils.redirectToMainPage(request, response);
    }
}