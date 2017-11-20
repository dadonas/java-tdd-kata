package com.tdd.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	private static final String DEFAULT_DELIMITER = ",";
	private static final String NEWLINE_DELIMITER = "\n";
	private static final String CUSTOM_DELIMITER_INDICATOR = "//";
	private static final String CUSTOM_DELIMITER_GROUP_INDICATOR = "\\[|\\]";

	public static int sum(String expression) {
		int result = 0;
		
		expression = prepareExpression(expression);
		
		String[] numbers = expression.split(DEFAULT_DELIMITER);
		
		for (String num : numbers) {
			//if num is empty, consider zero
			int parsedNumber = num.isEmpty() ? 0 : Integer.parseInt(num);
			
			//number greater than 1000 must be ignored
			parsedNumber = parsedNumber > 1000 ? 0 : parsedNumber;
			
			if (parsedNumber < 0) {
				throw new RuntimeException("All numbers must be greater than zero.");
			}
			
			result += parsedNumber;
		}
		
		return result;
	}
	
	private static String prepareExpression(String expression) {
		String possibleDelimiters = NEWLINE_DELIMITER + "|" + CUSTOM_DELIMITER_INDICATOR;
		
		//if multi char delimiter
		if (expression.startsWith(CUSTOM_DELIMITER_INDICATOR + "[")) {
			Pattern p = Pattern.compile("\\[(.*?)\\]");
			Matcher m = p.matcher(expression);
			while(m.find())	{
				String group = m.group().replace(CUSTOM_DELIMITER_GROUP_INDICATOR, "");
			    possibleDelimiters += "|" + group;
			}
			
			possibleDelimiters += "|" + CUSTOM_DELIMITER_GROUP_INDICATOR;
		} else if (expression.startsWith(CUSTOM_DELIMITER_INDICATOR)) {
			//if single char delimiter
			possibleDelimiters += "|" + expression.substring(2,3);
		}
		
		//replace possible delimiter to default delimiter
		return expression.replaceAll(possibleDelimiters,DEFAULT_DELIMITER);
	}

}
