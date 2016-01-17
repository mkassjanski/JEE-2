package com.dziennik.web;
import com.dziennik.service.*;
import com.dziennik.domain.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/comments/add/*")
public class AddCommentServlet extends HttpServlet{
    @EJB
    private StudentManager studentStorage;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long messageID = WebUtils.getStudentID(request);
        Student student = studentStorage.get(messageID);

        String type = request.getParameter("type");
        String commentText = request.getParameter("message");
        String author = request.getParameter("author");

        Comment comment = new Comment();
        comment.setMessage(commentText);
        comment.setAuthor(author);
        comment.setCreatedAt(new Date());
        comment.setType(type);

        studentStorage.addComment(student, comment);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + messageID));
    }
}