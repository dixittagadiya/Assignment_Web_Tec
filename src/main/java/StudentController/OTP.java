package StudentController;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import studentModel.Student;
@WebServlet("/otpGenerator")
public class OTP  extends HttpServlet{

	public int otp1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String lname = req.getParameter("lname");

		Student s = new Student();

		s.setEmail(email);

		Random r = new Random();

		int otp = r.nextInt(1000,9999);

		ServletContext sx = req.getServletContext();
		sx.setAttribute("otp", ""+otp);
		sx.setAttribute("email", email);

		otp1 = otp;

		Mailer.send(email, "Otp Verification ", "Otp : "+otp);

		req.setAttribute("lname", lname);
		req.getRequestDispatcher("studentLogin.jsp").forward(req, resp);

	}

}