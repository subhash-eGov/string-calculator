package org.egov.bootcamp.string_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int calculate(String value) throws Exception {
		value = value.replaceAll("\\s","");
		Matcher matcher = Pattern.compile("^(\\d)+(?>\\+(\\d)+)?$").matcher(value);
		if (value.equals("") || !matcher.matches())
			throw new InvalidDataException();
		String[] args = value.split("\\+");
		int result = 0;
		for (String arg : args) {
			result = result + Integer.parseInt(arg);
		}
		return result;
	}
}
