package com.abcbookshop.operations;

import com.abcbookshop.exceptions.UserException;

public class ValidationCheck {

	public static void nameMatch(String name) throws UserException{
		String Pattern = "[A-Za-z]+";
		if(!name.matches(Pattern)) {
			throw new UserException("Only Alphabets Allowed");	
		}
	}
	public static void unitsMatch(String units) throws UserException{
		String Pattern = "[1-9]+";
		if(!units.matches(Pattern)) {
			throw new UserException("Enter Stock Greater Than Zero");	
		}
	}
	public static void priceMatch(String price1) throws UserException{
		String Pattern = "[0-9]{1,}[.]*[0-9]*";
		if(!price1.matches(Pattern)) {
			throw new UserException("Invalid Price");	
		}
	}
	public static void bookNameMatch(String name) throws UserException{
		String Pattern = "[A-Za-z]+[0-9]*";
		if(!name.matches(Pattern)) {
			throw new UserException("Book Name Invalid");	
		}
	}
}
