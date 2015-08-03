package org.arm.service;

import static org.junit.Assert.assertTrue;

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
	
}
