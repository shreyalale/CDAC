package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter; 
import java.time.LocalDate;
import java.time.Period;
 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
 
import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import static com.cdac.utils.DBUtils.*;

@WebServlet("/register")
public class userRegistrationServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	
	public void init() throws ServletException{
		try {
			System.out.println("In init");
			openConnection();
			userDao = new UserDaoImpl();
			
		}catch(Exception e) {
			throw new ServletException("Error in init " + getClass() + e);
		}
	}
	
	public void destroy(){
		try {
			System.out.println("In destroy");
			userDao.cleanUp();
			closeConnection();
		} catch(Exception e) {
			throw new RuntimeException("Error in destroy " + getClass()+e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
			try(PrintWriter pw = response.getWriter()){
				String firstname = request.getParameter("fn");
				String lastName = request.getParameter("ln");
				String email = request.getParameter("em");
				String password = request.getParameter("pw");
				String dob = request.getParameter("dob");
				
				LocalDate ld = LocalDate.parse(dob);
				LocalDate now = LocalDate.now();
				
				int age = Period.between(ld, now).getYears();
				
				if(age < 21) {
					pw.println("<h1>Registration Failed!!!!!!!</h1>");
					pw.println("<h2>Age Should be greater that 21 years old.</h2>");
					return;
				}
				else {
					User newU = new User(firstname, lastName, email, password, java.sql.Date.valueOf(dob)); 
					
					String result = userDao.registrationDetails(newU);
					
					pw.print("<h1>"+result+"</h1>");
				}		
				
			} catch(Exception e) {
				throw new ServletException("Error in doPost " + getClass() + e);
			}
		
	}
	
}
