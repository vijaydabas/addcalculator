package org.arm.service;

import static org.junit.Assert.assertTrue;

import org.arm.exception.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class CalculatorServiceTest {

	
	@Test
	public void whenEmptyStringThenReturnZero() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(0 == calculator.add(""));
		
	}
	
	@Test
	public void whenOneAsStringThenReturnOne() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(1 == calculator.add("1"));
		
	}
	
	@Test
	public void whenInputHasOneAndTwoReturnSum() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(3 == calculator.add("1 , 2"));
		
	}
	
	
	@Test
	public void whenInputHasMoreThanTwoNumbers() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(6 == calculator.add("1,2,3"));
		
	}
	
	@Test
	public void whenInputNewLineCharacterBetweenTwoLinesNumbers() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(6 == calculator.add("1 \n 2,3"));
		
	}
	
	@Test
	public void whenInputNewLineCharacterBetweenThreeNumbers() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(6 == calculator.add("1 \n 2 \n 3"));
		
	}
	
	@Test
	public void whenSpecifyNewDelimiterAsFirstLine() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(6 == calculator.add("//[;]\n 1 ; 2 ; 3"));
		
	}
	
	
	@Test
	public void whenNegativeNumbersPassedThenThrowException() throws Exception {
		
		InvalidInputException exception = null;
		CalculatorService calculator = new CalculatorService();
		try {
			calculator.add("//[;]\n 1 ; -2 ; 3");
		} catch (InvalidInputException e) {
			exception = e;
			
		}
		assertTrue(exception.getMessage().contains("Invalid number : -2"));
		
	}
	
	@Test
	public void ignoreNumbersBiggerThan1000() throws Exception {
		CalculatorService calculator = new CalculatorService();
		assertTrue(2 == calculator.add("//[;]\n 1000 ; 2"));
		
	}
}
