package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.utils.DBUtils;

/**
 * Servlet implementation class FirstServlet
 * value | urlPatterns
 */
@WebServlet("/admin_page")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//set cont type
		response.setContentType("text/html");
		//Get PW
		try(PrintWriter pw=response.getWriter()) {
			 
			Connection conn = DBUtils.getConnection();
			Statement pst = conn.createStatement();
			ResultSet rs = pst.executeQuery("select * from candidates order by votes desc limit 2");
			pw.println("<html><body>");
			pw.println("<h2 style=\"text-align: center;\">Top 2 candidates having maximum votes</h2>");
			pw.println("<table border='1' style=\"background-color: white; margin: auto; width: 400px; height:70px\">");
			pw.println("<tr><th>Id</th><th>Name</th><th>Party</th><th>Votes</th></tr>");
			while(rs.next()) {
				 
				pw.println("<tr><td>" + rs.getInt("id")+"</td>");
				pw.println("<td>"+rs.getString("name")+"</td>");
				pw.println("<td>"+rs.getString("party")+"</td>");
				pw.println("<td>"+rs.getInt("votes")+"</td></tr>");
			}
			pw.println("</table>");
			
			pw.println("</br>");
			
			rs = pst.executeQuery("select * from candidates");
			pw.println("<table border='1' style=\"background-color: white; margin: auto; width: 400px; height:70px\">");
			pw.println("<h2 style=\"text-align: center;\">Votes Analysis ( Political Party Wise )</h2>");
			pw.println("<tr><th>Id</th><th>Name</th><th>Party</th><th>Votes</th></tr>");
			while(rs.next()) { 
				pw.println("<tr><td>" + rs.getInt("id")+"</td>");
				pw.println("<td>"+rs.getString("name")+"</td>");
				pw.println("<td>"+rs.getString("party")+"</td>");
				pw.println("<td>"+rs.getInt("votes")+"</td></tr>");
			}
			pw.println("</table>");
			pw.println("</body></html>");
			
		}catch(Exception e) {
			
			throw new ServletException("Error in admin page " + getClass() + e);
		}
	}
}
