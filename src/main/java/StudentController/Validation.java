package StudentController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean emailChk(String email)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$");

		Matcher matcher = pattern.matcher(email);

		b = matcher.matches();

		return b;

	}

	public static boolean fnameChk(String fname)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^[A-Za-z].+$");

		Matcher matcher = pattern.matcher(fname);

		b = matcher.matches();

		return b;
	}

	public static boolean lnameChk(String lname)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^[A-Za-z]+$");

		Matcher matcher = pattern.matcher(lname);

		b = matcher.matches();

		return b;

	}

	public static boolean mobileChk(String mobile)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^\\\\d{10}$");

		Matcher matcher = pattern.matcher(mobile);

		b = matcher.matches();

		return b;

	}

	public static boolean passChk(String pass)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=?]).{8,}");

		Matcher matcher = pattern.matcher(pass);

		b = matcher.matches();

		return b;
	}

}