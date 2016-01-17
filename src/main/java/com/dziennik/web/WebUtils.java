package com.dziennik.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtils {
	public static Long getStudentID(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String studentID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());

        return Long.valueOf(studentID);
    }
	
	public static Long getStudentID2(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String commentID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());
        String parts[] = commentID.split("_");
        String sID = parts[0]; // 004
        String cID = parts[1]; // 034556
        Long ssID = Long.valueOf(sID);
        Long ccID = Long.valueOf(cID);
        
        return Long.valueOf(ssID);
    }
	
	public static Long getStudentID3(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String commentID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());
        String parts[] = commentID.split("_");
        String sID = parts[0]; // 004
        String cID = parts[1]; // 034556
        Long ssID = Long.valueOf(sID);
        Long ccID = Long.valueOf(cID);
        
        return Long.valueOf(ccID);
    }
	
	public static Long getCommentID(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        String commentID = pathInfo.substring(pathInfo.lastIndexOf("/") + 1, pathInfo.length());

        return Long.valueOf(commentID);
    }
	public static void redirectToMainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/main"));
    }

    public static void redirectToStudentView(HttpServletRequest request, HttpServletResponse response, Long id) throws IOException {
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/view/" + id));
    }
}
