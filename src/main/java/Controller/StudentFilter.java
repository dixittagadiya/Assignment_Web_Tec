package Controller;

import java.io.IOException;

import Validater.Email_Validater;
import Validater.FName_Validater;
import Validater.LName_Validater;
import Validater.Mobile_Validater;
import Validater.Pass_Validater;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/reg")
public class StudentFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");

		RequestDispatcher rd = request.getRequestDispatcher("Studentform.jsp");


		if(fname.equals("")||fname.equals(null))
		{
			request.setAttribute("fnameerr", "First name can not be blank..!!!!");
			rd.forward(request, response);
		}
		else if(!FName_Validater.fnameCheck(fname))
		{
			request.setAttribute("fnameerr", "Invalid first name..!!!");
			rd.forward(request, response);
		}
		if(lname.equals("")||lname.equals(null))
		{
			request.setAttribute("lnameerr", "Last name can not be blank...!!!");
			rd.forward(request, response);
		}
		else if(!LName_Validater.lnameValidate(lname))
		{
			request.setAttribute("lnameerr", "Invalid last name..!!!");
			rd.forward(request, response);
		}
		if(email.equals("")||email.equals(null))
		{
			request.setAttribute("Emailerr", "Email can not be blank..!!");
			rd.forward(request, response);
		}
		else if(!Email_Validater.emailCheck(email))
		{
			request.setAttribute("Emailerr", "Invalid Email...!!!!");
			rd.forward(request, response);
		}
		if(mobile.equals("")||mobile.equals(null))
		{
			request.setAttribute("mobileerr", "Mobile can not be blank...!!!!");
			rd.forward(request, response);
		}
		else if(!Mobile_Validater.mobileValidator(mobile))
		{
			request.setAttribute("mobileerr", "mobile should be 10 digit");
			rd.forward(request, response);
		}
		if(password.equals("")||password.equals(null))
		{
			request.setAttribute("passErr", "Password can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Pass_Validater.passwordvalidator(password))
		{
			request.setAttribute("passErr", "Pass must be in correct...!!!");
			rd.forward(request, response);
		}

		chain.doFilter(request, response);

	}






}