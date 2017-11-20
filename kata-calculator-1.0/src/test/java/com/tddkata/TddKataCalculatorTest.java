package com.tddkata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class TddKataCalculatorTest {

	//1. An empty string returns zero
	@Test
	public void emptyStringShouldReturnZero() {
		assertThat(Calculator.sum(""),equalTo(0L));
	}
	
	//2. A single number returns the value
	@Test
	public void singleNumberShouldReturnValue() {
		assertThat(Calculator.sum("3"),equalTo(3L));
	}
	
	//3. Two numbers, comma delimited, returns the sum
	@Test
	public void twoNumbersCommaDelimitedShoudReturnSum() {
		assertThat(Calculator.sum("1,2,3"),equalTo(6L));
	}
	
	//4. Two numbers, newline delimited, returns the sum
	@Test
	public void twoNumberNewLineDelimitedShoudRetrnSum() {
		assertThat(Calculator.sum("1\n2\n3"),equalTo(6L));
	}
	
	//5. Three numbers, delimited either way, returns the sum
	@Test
	public void threeNumbersDelimitedShoudReturnSum() {
		assertThat(Calculator.sum("1\n2\n3,1,3"),equalTo(10L));
	}
	
	//6. Negative numbers throw an exception
	@Test(expected = RuntimeException.class)
	public void negativeNumbersShoudThrowException() {
		Calculator.sum("-1");
	}
	
	//7. Numbers greater than 1000 are ignored
	@Test
	public void numbersGreaterThan1000ShouldBeIgnored() {
		assertThat(Calculator.sum("1\n2\n3,1,3,1000,1001"),equalTo(1010L));
	}
	
	//8. A single char delimiter can be defined on the first line (e.g. //# for a‘#’ as the delimiter)
	@Test
	public void singleCharDelimiterCanBeDefined() {
		assertThat(Calculator.sum("//#1#2#3"),equalTo(6L));
	}		
			
	//9. A multi char delimiter can be defined on the first line (e.g. //[###] for‘###’ as the delimiter)
	@Test
	public void multiCharDelimiterCanBeDefined() {
		assertThat(Calculator.sum("//[###][lll]1###2###3lll4"),equalTo(10L));
	}		
			
	//10. Many single or multi-char delimiters can be defined (each wrapped in squarebrackets)
	@Test
	public void manySingleOrMultiCharcanBeDefined() {
		assertThat(Calculator.sum("//[###][lll][@]1###2###3lll4@5"),equalTo(15L));
	}



}
