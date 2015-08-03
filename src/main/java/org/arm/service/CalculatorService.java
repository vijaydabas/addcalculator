package org.arm.service;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class CalculatorService {

	public int add(String string) {
		
		if(StringUtils.isNotBlank(string)) {
			String[] numbersArray = StringUtils.split(",") ;
			return Arrays.asList(numbersArray).parallelStream().map(i -> Integer.parseInt(i)).mapToInt(Integer::valueOf).sum();
		}
		return 0;
	}


}
