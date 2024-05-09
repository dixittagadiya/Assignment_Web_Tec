package StudentController;

import java.io.IOException;
import java.util.ArrayList;

import StudentDao.Std_Dao;
import StudentModel.Std_model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import studentDao.stdDao;
import studentModel.Student;


@WebServlet("/StudentView")
public class View_Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Std_Dao dao = new Std_Dao();
		ArrayList<Std_model> std = dao.getAllstudent();

		req.setAttribute("data", std);
		req.getRequestDispatcher("Disp.jsp").forward(req, resp);

	}

}