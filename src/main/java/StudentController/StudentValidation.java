package StudentController;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/rege")
public class StudentValidation extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String pass = request.getParameter("pass");

		RequestDispatcher rd = request.getRequestDispatcher("StudentRegistration.jsp");

		if(fname.equals("")||fname.equals(null))
		{
			request.setAttribute("fnameErr", "firstname can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Validation.fnameChk(fname))
		{
			request.setAttribute("fnameExpErr", "Incorrect formate..!!!");
			rd.forward(request, response);
		}
		if(lname.equals("")||lname.equals(null))
		{
			request.setAttribute("lnameErr", "Lname can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Validation.lnameChk(lname))
		{
			request.setAttribute("lnameExpErr", "Incorrect Formate..!!!");
			rd.forward(request, response);
		}
		if(email.equals("")||email.equals(null))
		{
			request.setAttribute("emailErr", "Email can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Validation.emailChk(email))
		{
			request.setAttribute("emailExpErr", "Incorrect formate..!!!");
			rd.forward(request, response);
		}
		if(mobile.equals("")||mobile.equals(null))
		{
			request.setAttribute("mobileErr", "Mobile can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Validation.mobileChk(mobile))
		{
			request.setAttribute("mobileExpErr", "Incorrect Formate..!!!");
			rd.forward(request, response);
		}
		if(pass.equals("")||pass.equals(null))
		{
			request.setAttribute("passErr", "Password can not be blank..!!!");
			rd.forward(request, response);
		}
		else if(!Validation.passChk(pass))
		{
			request.setAttribute("passExpErr", "Incorrect formate..!!!");
			rd.forward(request, response);
		}

		chain.doFilter(request, response);



	}

}