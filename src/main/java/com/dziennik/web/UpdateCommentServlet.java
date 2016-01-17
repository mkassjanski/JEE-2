package com.dziennik.web;
import com.dziennik.service.StudentManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/comment/edit/*")
public class UpdateCommentServlet extends HttpServlet{
    @EJB
    private StudentManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long commentID = WebUtils.getStudentID(request);

        request.setAttribute("comment", storage.getC(commentID));
        request.getRequestDispatcher("/comment/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("type");
        String surname = request.getParameter("message");
        String sex = request.getParameter("author");
        
        Long commentID = WebUtils.getStudentID(request);

        storage.updateComment(commentID, name, surname, sex);

        WebUtils.redirectToMainPage(request, response);
    }
}