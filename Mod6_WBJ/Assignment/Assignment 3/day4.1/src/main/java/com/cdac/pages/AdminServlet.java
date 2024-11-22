package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.CandidateDaoImpl;
import com.cdac.pojos.Candidate;

@WebServlet("/admin_page")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type
        response.setContentType("text/html");

        // Get candidates from the database
        CandidateDaoImpl candidateDao = null;
        List<Candidate> candidates = null;
        try {
            candidateDao = new CandidateDaoImpl(); // Initialize DAO
            candidates = candidateDao.getAllCandidates(); // Fetch candidates from DB

            // Create a response HTML
            try (PrintWriter pw = response.getWriter()) {
                pw.print("<h3>Candidate List</h3>");
                pw.print("<form action='voting_page' method='post'>");
                pw.print("<select name='candidateId'>");
                for (Candidate candidate : candidates) {
                    pw.print("<option value='" + candidate.getCandidateId() + "'>" + candidate.getName() + " (" + candidate.getPartyName() + ")</option>");
                }
                pw.print("</select>");
                pw.print("<br/><input type='submit' value='Vote'/>");
                pw.print("</form>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error retrieving candidates!");
        } finally {
            try {
                if (candidateDao != null) {
                    candidateDao.cleanUp(); // Clean up DAO
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
