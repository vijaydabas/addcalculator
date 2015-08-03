package org.arm.service;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class CalculatorService {

	private static  String DEFAULT_DELIMITER = ",";

	private Pattern delimiterPattern = Pattern.compile("\\[([^\\]]*)\\]"); 
	
	public int add(String string) {
		// TODO Auto-generated method stub
		
		if(StringUtils.isNotBlank(string)) {
			
			String[] newLineSplit = string.split("\\n");
			
			String modifiedDeLimiter = newLineSplit[0];
			
			String delimiter =  getDelimiter(modifiedDeLimiter);
			
			return Arrays.asList(newLineSplit).parallelStream().filter(hasNumbers).map(createParser(delimiter)).mapToInt(Integer::valueOf).sum();
			
			
		}
		return 0;
	}


	private Predicate<? super String> hasNumbers = str -> {
		 if(!str.contains("[")){
			 return true;
		 }
		 return false;
	};


	private String getDelimiter(String modifiedDeLimiter) {
		String delimiter = DEFAULT_DELIMITER;
		Matcher m = delimiterPattern.matcher(modifiedDeLimiter);
		if (m.find()) {
			delimiter = m.group(1);
		}
		
		return delimiter;
	}

  
	private Function<String, Integer> createParser(String delimiter) {
		
		
		return (String intString) -> {
			String[] numbersArray = intString.split(delimiter);
			
			return  Arrays.asList(numbersArray).parallelStream().map(i ->Integer.parseInt(i.trim())).mapToInt(Integer::valueOf).sum();
			
		};
		
	}


}
