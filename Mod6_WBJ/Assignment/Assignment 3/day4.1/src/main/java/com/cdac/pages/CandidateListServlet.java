package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.CandidateDao;
import com.cdac.dao.CandidateDaoImpl;
import com.cdac.pojos.Candidate;
import com.cdac.pojos.User;

/**
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");

        try (PrintWriter pw = response.getWriter()) {
            pw.print("<h5> In Candidate List Page </h5>");

            // 1. Get HttpSession from WC
            HttpSession hs = request.getSession();
            System.out.println("Session ID: " + hs.getId());
            System.out.println("Is this a new session? " + hs.isNew());

            // 2. Get user details from the Session scope
            User user = (User) hs.getAttribute("user_dtls");
            if (user != null) {
                // Session tracking is successful
                pw.print("<h5>Hello, " + user.getFirstName() + " " + user.getLastName() + "</h5>");

                // 3. Get candidate dao from session
                CandidateDao candidateDao = (CandidateDao) hs.getAttribute("candidate_dao");

                // If candidateDao is not found in the session, initialize it
                if (candidateDao == null) {
                    candidateDao = new CandidateDaoImpl();  // Initialize the CandidateDaoImpl
                    hs.setAttribute("candidate_dao", candidateDao); // Add it to session
                }

                // 4. Invoke candidate dao's method to get List of all candidates
                List<Candidate> allCandidates = candidateDao.getAllCandidates();

                // 5. Generate form dynamically to render all candidates' list
                pw.print("<h5><form method='post' action='logout'>"); // Changed action to 'vote'
                for (Candidate c : allCandidates) {
                    pw.print("<h5><input type='radio' name='id' value='" 
                            + c.getCandidateId() + "'>" 
                            + c.getName() + " (" + c.getPartyName() + ")</input></h5>");
                }
                pw.print("<input type='submit' value='Vote'/>");
                pw.print("</form></h5>");
            } else {
                pw.print("<h5>No Cookies (JSESSIONID) found! Please accept cookies!</h5>");
            }
        } catch (Exception e) {
            // Catch any exceptions and rethrow them as ServletException
            throw new ServletException("Error in doGet of " + getClass(), e);
        }
    }
}
