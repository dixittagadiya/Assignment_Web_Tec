package Validater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FName_Validater {

	public static boolean fnameCheck(String fname)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^[A-Za-z].+$");

		Matcher match = pattern.matcher(fname);

		b = match.matches();

		return b;
	}

}