package com.dziennik.web;
import com.dziennik.service.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/comment/remove/*")
public class RemoveCommentServlet extends HttpServlet{
    @EJB
    private StudentManager storage;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long studentID2 = WebUtils.getStudentID2(request);
        Long commentID = WebUtils.getStudentID3(request);
        
        storage.deleteComment(commentID,studentID2);

        WebUtils.redirectToStudentView(request, response, studentID2);
    }
}