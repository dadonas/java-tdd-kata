package com.tdd.calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalculatorTest {
	
	//1. An empty string returns zero
	@Test
	public void emptyStringMustReturnZero() {
		assertThat(Calculator.sum(""), is(0));
	}
	
	//2. A single number returns the value
	@Test
	public void singleNumberMustReturnItself() {
		assertThat(Calculator.sum("10"), is(10));
	}
	
	//3. Two numbers, comma delimited, returns the sum
	@Test
	public void twoNumbersCommaDelimitedMustReturnSum() {
		assertThat(Calculator.sum("10,5"), is(15));
	}
	
	//4. Two numbers, newline delimited, returns the sum
	@Test
	public void twoNumbersNewlineDelimitedMustReturnSum() {
		assertThat(Calculator.sum("10\n10"), is(20));
	}
	
	//5. Three numbers, delimited either way, returns the sum
	@Test
	public void threeNumbersNewlineDelimitedMustReturnSum() {
		assertThat(Calculator.sum("10\n10,5"), is(25));
	}
	
	//6. Negative numbers throw an exception
	@Test(expected = RuntimeException.class)
	public void negativeNumbersMustThrowException() {
		Calculator.sum("10\n10\n-5");
	}
	
	//7. Numbers greater than 1000 are ignored
	@Test
	public void numbersGreaterThan1000MustBeIgnored() {
		assertThat(Calculator.sum("10\n10,5,1000,1001"), is(1025));
	}
	
	//8. A single char delimiter can be defined on the first line 
	//(e.g. //# for a‘#’ as the delimiter)
	@Test
	public void singleCharDelimiterCanBeDefined() {
		assertThat(Calculator.sum("//#10#20#30"), is(60));
	}
	
	//9. A multi char delimiter can be defined on the first line 
	//(e.g. //[###] for‘###’ as the delimiter)
	@Test
	public void multiCharDelimiterCanBeDefined() {
		assertThat(Calculator.sum("//[###]10###20###30"), is(60));
	}
	
	//10. Many single or multi-char delimiters can be defined (each wrapped in squarebrackets)
	@Test
	public void singleOrMultiCharDelimiterCanBeDefined() {
		assertThat(Calculator.sum("//[###][@@][****]10###20###30@@40****100"), is(200));
	}
}
