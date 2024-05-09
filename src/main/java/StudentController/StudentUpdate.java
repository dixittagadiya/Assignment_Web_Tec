package StudentController;

import java.io.IOException;

import StudentDao.Std_Dao;
import StudentModel.Std_model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class StudentUpdate  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		int id = Integer.parseInt(req.getParameter("id"));
		Std_Dao dao = new Std_Dao();

		if(action.equals("edit"))
		{
			Std_model s = dao.getstudent(id);
			req.setAttribute("sdata", s);
			req.getRequestDispatcher("StudentRegistration.jsp").forward(req, resp);
		}
		else if(action.equals("delete"))
		{
			int i = dao.deleteStudent(id);

			if(i>0)
			{
				req.setAttribute("deleteMsg", "student deleted Successfully...!!!");
				req.getRequestDispatcher("StudentView").forward(req, resp);
			}
		}

	}

}