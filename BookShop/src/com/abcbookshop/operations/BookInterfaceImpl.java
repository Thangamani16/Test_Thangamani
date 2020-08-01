package com.abcbookshop.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.abcbookshop.model.BookDetails;
public class BookInterfaceImpl implements BookInterface {


	@Override
	public void addBook(String name,String author, String type, int count,double price) {
		Connection con = ConnectionClass.Connectiondb();
		try {
			String sq = "select max(BookId) from BooksList";
			PreparedStatement statement1 = con.prepareStatement(sq);
			ResultSet rs = statement1.executeQuery();
			int i = 6000;
			while(rs.next()) {

			String sql = "insert into BooksList values(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(sql);
			BookDetails p = new BookDetails();
			statement.setInt(1, i++);
			statement.setString(2, name);
			statement.setString(3, author);
			statement.setString(4, type);
			statement.setInt(5, count);
			statement.setDouble(6, price);
			statement.executeUpdate();
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
		
	}
	@Override
	public Set<BookDetails> displayBooks() {
			Set<BookDetails> m1 = new HashSet<BookDetails>();
			Connection con = ConnectionClass.Connectiondb();
			try {
				String sql = "select * from BooksList";
				PreparedStatement stmt = con.prepareStatement(sql);			   				
				ResultSet rs=stmt.executeQuery();				
				while(rs.next()) {
					BookDetails pd1=new BookDetails();
					pd1.setBookId(rs.getInt(1));
					pd1.setBookName(rs.getString(2));
					pd1.setAuthorName(rs.getString(3));
					pd1.setBookType(rs.getString(4));
					pd1.setNoOfCopies(rs.getInt(5));
					pd1.setPrice(rs.getInt(6));
					m1.add(pd1);	             
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}
			return m1;
		}
	@Override
	public void updateBookName(int bookId, int noOfUnits) {
		String sql="update BooksList set noOfCopies=? where BookId=?";
		Connection con = ConnectionClass.Connectiondb();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,bookId);
			stmt.setInt(2,noOfUnits);
			stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	@Override
	public Set<BookDetails> searchBook(String sname) {
		
		Set<BookDetails> m2 = new HashSet<BookDetails>();
		Connection con = ConnectionClass.Connectiondb();
		try {

			String sql = "select * from BooksList where Name=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, sname);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				BookDetails np=new BookDetails();
				np.setBookId(rs.getInt(1));
				np.setBookName(rs.getString(2));
				np.setAuthorName(rs.getString(3));
				np.setBookType(rs.getString(4));
				np.setNoOfCopies(rs.getInt(5));
				np.setPrice(rs.getInt(6));
				m2.add( np);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m2;
	}
}