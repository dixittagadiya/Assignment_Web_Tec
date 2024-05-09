package StudentController;

import java.io.IOException;

import StudentDao.Std_Dao;
import StudentModel.Std_model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rege")
public class StudentReg_Controller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String gender = req.getParameter("gender");
		String pass = req.getParameter("pass");

		Std_model student = new Std_model();

		student.setFname(fname);
		student.setLname(lname);
		student.setEmail(email);
		student.setMobile(mobile);
		student.setGender(gender);
		student.setPass(pass);


		Std_Dao dao = new Std_Dao();

		if(id.equals("")||id.equals(null))
		{
			boolean b = dao.emailExit(student);

			if(b)
			{
				req.setAttribute("emailErr", "Email already exist...!!!");
				req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
			}
			else
			{
				int i = dao.studentRegistration(student);

				if(i>0)
				{
					req.setAttribute("registrationMsg", "Student Registration successfully..!!!!");
					req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);

				}

			}
		}
		else
		{
			int uid = Integer.parseInt(id);
			student.setId(uid);
			boolean b = dao.emailExit(student);

			if(b)
			{
				req.setAttribute("emailErr", "Email already exist...!!!");
				req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);	
			}
			else
			{
				int i = dao.updateStudent(student);
				if(i>0)
				{
					req.setAttribute("updateMsg", "Studet details update successfully...!!!");
					req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
				}
			}
		}



	}

}