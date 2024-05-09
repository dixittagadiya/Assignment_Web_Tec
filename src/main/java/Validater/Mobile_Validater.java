package Validater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile_Validater {

	public static boolean mobileValidator(String mobile)
	{
		boolean b = false;

		Pattern pattern = Pattern.compile("^\\d{10}$");

		Matcher match = pattern.matcher(mobile);

		b = match.matches();

		return b;
	}

}