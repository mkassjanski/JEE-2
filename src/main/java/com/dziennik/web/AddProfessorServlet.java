package com.dziennik.web;
import com.dziennik.service.ProfessorManager;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/AddProfessor")
public class AddProfessorServlet extends HttpServlet{

    @EJB
    private ProfessorManager pm;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/professor/add.jsp").forward(request, response);
    }
	
}
