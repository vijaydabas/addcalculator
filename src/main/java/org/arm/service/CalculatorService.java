package org.arm.service;

import org.apache.commons.lang3.StringUtils;

public class CalculatorService {

	public int add(String string) {
		
		if(StringUtils.isNotBlank(string)) {
			final int firstNumber = Integer.parseInt(string)  ;
			return firstNumber;
		}
		return 0;
	}

}
