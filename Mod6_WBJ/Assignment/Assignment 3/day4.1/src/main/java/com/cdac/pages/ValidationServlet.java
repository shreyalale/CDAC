package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;
import com.cdac.utils.DBUtils;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class ValidationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        try {
            // Initialize database connection
            DBUtils.getConnection();  // Make sure connection is available
            userDao = new UserDaoImpl();
        } catch (Exception e) {
            throw new ServletException("Error in init of " + getClass(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()) {
            // Get login credentials from request
            String email = request.getParameter("em").trim();
            String password = request.getParameter("pass").trim();

            // Authenticate the user
            User user = userDao.authenticateUser(email, password);

            if (user == null) {
                pw.print("<h5>Invalid Login, Please <a href='login.html'>Retry</a></h5>");
            } else {
                // Create session and set user details
                HttpSession session = request.getSession();
                session.setAttribute("user_dtls", user);

                if ("admin".equals(user.getUserRole())) {
                    response.sendRedirect("admin_page");
                } else if (user.isStatus()) {
                    response.sendRedirect("logout");
                } else {
                    response.sendRedirect("candidate_list");
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error in doPost of " + getClass(), e);
        }
    }
}
