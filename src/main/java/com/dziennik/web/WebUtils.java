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
}
