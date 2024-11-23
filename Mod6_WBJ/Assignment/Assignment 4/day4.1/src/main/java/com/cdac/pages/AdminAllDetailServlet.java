//package com.cdac.pages;
//
//import java.io.IOException;
//import java.io.PrintWriter;
////import java.util.Date;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
////import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.cdac.utils.DBUtils;
//
///**
// * Servlet implementation class FirstServlet
// * value | urlPatterns
// */
//@WebServlet("/admin_page")
//public class AdminAllDetailServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//set cont type
//	response.setContentType("text/html");
//	//Get PW
//	try(PrintWriter pw=response.getWriter()) {
//		pw.print("<h5> In admin page </h5>");
//		Connection conn = DBUtils.getConnection();
//		Statement pst = conn.createStatement();
//		ResultSet rs = pst.executeQuery("select * from candidates");
//		pw.println("<html><body>");
//		pw.println("<table border='1'>");
//		while(rs.next()) {
////			pw.println("<tr><td>" + rs.getInt("id")+"</td>");
////			pw.println("<td>"+rs.getString("name")+"</td>");
//			pw.println("<td>"+rs.getString("party")+"</td>");
//			pw.println("<td>"+rs.getInt("votes")+"</td></tr>");
//		}
//		pw.println("</table>");
//		pw.println("</body></html>");
//		
//	}catch(Exception e) {
//		
//		throw new ServletException("Error in admin page " + getClass() + e);
//	}
//}

//}
