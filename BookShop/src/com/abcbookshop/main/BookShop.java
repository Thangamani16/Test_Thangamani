package com.abcbookshop.main;

import com.abcbookshop.model.BookDetails;
import com.abcbookshop.operations.BookInterface;
import com.abcbookshop.operations.BookInterfaceImpl;
import com.abcbookshop.operations.ConnectionClass;
import com.abcbookshop.operations.ValidationCheck;
import com.abcbookshop.exceptions.UserException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookShop {

	public static void main(String[] args) {
		ConnectionClass.Connectiondb();
		System.out.println("1 - Adding The Book\n2 - Display Books\n3 - Search Book by Name\n4 - Update Book Name\n5 - Exit");
		Scanner s = new Scanner(System.in);
		Set<BookDetails> m = new HashSet<BookDetails>();
		while (true) {
			System.out.println("Enter Your Choice");
			int Choice = s.nextInt();
			switch (Choice) {

			case 1:
				String name = null;
				while (true) {
					System.out.println("Enter Book Name");
					name = s.next();
					try {
						ValidationCheck.bookNameMatch(name);
						break;
					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
				}
				String author = null;
				while (true) {
					System.out.println("Enter Author Name");
					author = s.next();
					try {
						ValidationCheck.nameMatch(author);
						break;
					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
				}
				String type = null;
				while (true) {
					System.out.println("Enter Book Type");
					type = s.next();
					try {
						ValidationCheck.nameMatch(type);
						break;
					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
				}
				String count1 = null;
				while (true) {
					System.out.println("Enter Number of Copies");
					count1 = s.next();
					try {
						ValidationCheck.unitsMatch(count1);
						break;
					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
				}
				int count = Integer.parseInt(count1);
				String price1 = null;
				while (true) {
					System.out.println("Enter Book Price");
					price1 = s.next();
					try {
						ValidationCheck.priceMatch(price1);
						break;
					} catch (UserException e) {
						System.out.println(e.getMessage());
					}
				}
				double price = Double.parseDouble(price1);
				BookInterface si = new BookInterfaceImpl();
				si.addBook(name,author,type,count,price);
				System.out.println("Book Added");
				break;
			case 2:
				BookInterface si1 = new BookInterfaceImpl();
				Set<BookDetails> m1=si1.displayBooks();
				for (BookDetails p : m1) {
					System.out.println(p);
				}
				break;
			case 3:
				BookInterface prod2 = new BookInterfaceImpl();
				System.out.println("Enter the Book Id to Update");
				String newName = s.next();
				int productId3 = Integer.parseInt(newName);
				System.out.println("Enter the number of units");
				String units1 = s.next();
				int updatedCopies= Integer.parseInt(units1);
				prod2.updateBookName(productId3, updatedCopies);
				System.out.println("Update Success");
				break;
			case 4:
				System.out.println("Enter Book Name to Search");
				String sname = s.next();
				BookInterface prod = new BookInterfaceImpl();
				Set<BookDetails> searchList = prod.searchBook(sname);
				if (searchList.size()==0) {
					System.out.println("Book not found");
				} else {
					for (BookDetails p : searchList) {
						System.out.println(p);
					}
							
				}

	}
		}
	}
}
