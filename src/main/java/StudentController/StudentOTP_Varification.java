package StudentController;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/otpverify")
public class StudentOTP_Varification extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String otp = req.getParameter("Otp");
		String lname = req.getParameter("lname");

		ServletContext cx = req.getServletContext();
		String myOtp = (String) cx.getAttribute("otp");



		if (!otp.equals(myOtp))
		{
			req.setAttribute("otpErr", "Invalid Otp");
		}
		else 
		{
			req.setAttribute("lname", lname);
			req.getRequestDispatcher("studentHome.jsp").forward(req, resp);
		}

	}

}