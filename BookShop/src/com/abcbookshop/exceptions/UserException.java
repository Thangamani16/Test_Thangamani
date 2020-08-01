package com.abcbookshop.exceptions;

public class UserException extends Exception{
	String detailmsg;
	public UserException(String msg) {
		this.detailmsg = msg;
	}
	public String getMessage()
	{
		return detailmsg;
	}
}

