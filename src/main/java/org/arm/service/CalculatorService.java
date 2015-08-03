package org.arm.service;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class CalculatorService {

	public int add(String string) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isNotBlank(string)) {
			
			String[] newLineSplit = string.split("\\n");
			
			
			
		    return	Arrays.asList(newLineSplit).parallelStream().flatMap(parseIntsAsStream).mapToInt(Integer::valueOf).sum();
			
		}
		return 0;
	}

	
	private Function<String, Stream<Integer>> parseIntsAsStream = intString -> {
		
		String[] numbersArray = intString.split(",") ;
		
		
		return  Arrays.asList(numbersArray).parallelStream().map(i ->  Integer.parseInt( i.trim()));
		
	};


}
