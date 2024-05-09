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
@WebServlet("/deletedData")
public class DataDelete_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Std_Dao dao = new Std_Dao();

		ArrayList<Std_model> s = dao.deletedData();

		req.setAttribute("Ddata", s);
		req.getRequestDispatcher("deletedData.jsp").forward(req, resp);

	}

}