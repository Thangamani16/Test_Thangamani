package com.abcbookshop.operations;

import java.util.Set;

import com.abcbookshop.model.BookDetails;

public interface BookInterface {
	public void addBook(String name,String author, String type, int count,double price);
	public Set<BookDetails> displayBooks();
	public void updateBookName(int bookId, int noOfUnits);
	public Set<BookDetails> searchBook(String sname);
}
