package StudentDao;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import StudentModel.Std_model;

public class Std_Dao {

	Connection cn = null;
	public Std_Dao() {

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");

		cn	= DriverManager.getConnection("jdbc:mysql://localhost:3308/assignment","root","");

		} 
		catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}

	}
	public int studentRegistration(Std_model s) 
	{
		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("insert into student values (?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, s.getFname());
			ps.setString(3, s.getLname());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getMobile());
			ps.setString(6, s.getGender());
			ps.setString(7, s.getPass());

			i = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return i;
	}
	public String loginChk(Std_model s) 
	{
		String lname = null;

		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where email=? and pass=?");
			ps.setString(1, s.getEmail());
			ps.setString(2, s.getPass());

			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				lname = rs.getString(3);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return lname;
	}
	public ArrayList<Std_model> getAllstudent() {

		ArrayList<Std_model> s = new ArrayList<Std_model>();
		PreparedStatement ps;
		try {
			 ps = cn.prepareStatement("select * from student");
			 ResultSet rs = ps.executeQuery();

			 while(rs.next())
			 {
				 Student std = new Student();
				 std.setId(rs.getInt(1));
				 std.setFname(rs.getString(2));
				 std.setLname(rs.getString(3));
				 std.setEmail(rs.getString(4));
				 std.setMobile(rs.getString(5));
				 std.setGender(rs.getString(6));
				 std.setPass(rs.getString(7));

				 s.add(std);

			 }
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return s;
	}
	public Student getstudent(int id) {

		Student s = new Student();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setMobile(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setPass(rs.getString(7));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return s;
	}
	public int deleteStudent(int id) {

		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("delete from student where id = ?");
			ps.setInt(1, id);

			i = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;
	}
	public boolean emailExit(Student s) {

		boolean b = false;

		try {
			PreparedStatement ps = cn.prepareStatement("select * from student where email=?");
			ps.setString(1, s.getEmail());

			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				b = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return b;
	}
	public int updateStudent(Student s ) {

		int i = 0;

		try {
			PreparedStatement ps = cn.prepareStatement("update student set fname=?, lname=?, email=?, mobile=?, gender=?, pass=? where id = ?");
			ps.setString(1, s.getFname());
			ps.setString(2, s.getLname());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getMobile());
			ps.setString(5, s.getGender());
			ps.setString(6, s.getPass());
			ps.setInt(7, s.getId());

			i = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;
	}
	public ArrayList<Student> deletedData() 
	{
		ArrayList<Student> st = new ArrayList<Student>();

		try {
			PreparedStatement ps = cn.prepareStatement("select * from deleteddata");

			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setLname(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setMobile(rs.getString(5));
				s.setGender(rs.getString(6));
				s.setPass(rs.getString(7));

				st.add(s);

			}


		} catch (SQLException e) {

			e.printStackTrace();
		}


		return st;
	}





}