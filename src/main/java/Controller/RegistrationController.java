package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegistrationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String password = req.getParameter("password");

		System.out.println(fname+" "+lname+" "+email+" "+mobile+" "+gender+" "+password);

		req.setAttribute("fname", fname);
		req.setAttribute("lname",lname);
		req.setAttribute("email", email);
		req.setAttribute("mobile", mobile);
		req.setAttribute("gender", gender);
		req.setAttribute("password", password);

		req.getRequestDispatcher("View.jsp").forward(req, resp);



	}

}