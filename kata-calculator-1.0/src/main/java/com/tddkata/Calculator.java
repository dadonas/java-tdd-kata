package com.tddkata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	private static final long MIN_NUMBER_ALLOWED = 0;
	private static final long MAX_NUMBER_ALLOWED = 1000;
	private static final String DEFAULT_DELIMITER = ",";
	private static final String CUSTOM_DELIMITER_INDICATOR = "//";
	
	public static long sum(String expression) {
		String[] numbers = decodeExpression(expression);
		
		Long total = 0L;
		
		for (String num : numbers) {
			
			//if num is empty, convert to zero.
			num = num.isEmpty() ? "0" : num;
			
			Long parsedNumber = Long.parseLong(num);
			
			if (parsedNumber < MIN_NUMBER_ALLOWED) {
				throw new RuntimeException("Number can't be negative!");
			}
			
			if (parsedNumber > MAX_NUMBER_ALLOWED) {
				parsedNumber = 0L;
			}
			
			total += parsedNumber;
		}
		
		return total;
	}
	
	public static String[] decodeExpression(String expression) {
		if (expression.startsWith(CUSTOM_DELIMITER_INDICATOR + "[")) {
			Pattern p = Pattern.compile("\\[(.*?)\\]");
			Matcher m = p.matcher(expression);
			while(m.find())	{
				String group = m.group().replace("\\[|\\]", "");
			    expression = expression.replaceAll(group, DEFAULT_DELIMITER);
			}
		} else if (expression.startsWith(CUSTOM_DELIMITER_INDICATOR)) {
			String delimiter = expression.substring(2,3);
			expression = expression.replaceAll(delimiter, DEFAULT_DELIMITER);
		}
		
		String removeCharsPattern = "\\[|\\]|"+CUSTOM_DELIMITER_INDICATOR;
		expression = expression.replaceAll(removeCharsPattern, "");
		expression = expression.replaceAll("\n", DEFAULT_DELIMITER);
		
		return expression.split(DEFAULT_DELIMITER);
	}

}
