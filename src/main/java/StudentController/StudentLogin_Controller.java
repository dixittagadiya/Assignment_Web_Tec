package StudentController;

import java.io.IOException;

import StudentDao.Std_Dao;
import StudentModel.Std_model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Studentlogin")
public class StudentLogin_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Std_model student = new Std_model();

		student.setEmail(email);
		student.setPass(pass);

		Std_Dao dao = new Std_Dao();

		String lname = dao.loginChk(student);

		if(lname==null)
		{
			req.setAttribute("loginErr", "Invalid Credentials..!!!!");
			req.getRequestDispatcher("StudentLogin.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("LoginMsg", "Login  Sccessfully..!!!");
			req.setAttribute("lname", lname);
			req.getRequestDispatcher("otpGenerator").forward(req, resp);

		}

		}

}