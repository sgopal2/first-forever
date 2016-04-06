package main.java.com.example.java18.lambda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class LambdaWithComparator {

	public static void main(String[] args) {
		
		List<Book> books = getBookList();
		//OLD approach
		Collections.sort(books, new Comparator<Book>(){
			public int compare(Book b1, Book b2){
				return b1.getTitle().compareTo(b2.getTitle());
			}
		});
		System.out.println(books);
		
		//New approach - with argument type Book, Book
		List<Book> books2 = getBookList();
		Collections.sort(books2, (Book b1, Book b2) -> 	b1.getTitle().compareTo(b2.getTitle()));
		System.out.println(books2);
		//New approach - without argument type
		List<Book> books3 = getBookList();
		Collections.sort(books3, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
		System.out.println(books3);
	}

	static List<Book> getBookList(){
		
		List<Book> books = new ArrayList<Book>();
		try{
			Book b1 = new Book("Sar",Calendar.getInstance().getTime()); 
			Book b2 = new Book("Abc",Calendar.getInstance().getTime()); 
			Book b3 = new Book("Zar",Calendar.getInstance().getTime()); 
			Book b4 = new Book("Sap",Calendar.getInstance().getTime()); 
			books.add(b1);books.add(b2);books.add(b3);books.add(b4);
		}catch(Exception e){};
		
		return books;
	}
}

class Book{
		
	private String title;
	private Date publishedOn;
	
	Book(String title, Date publishedOn){
		this.title = title;
		this.publishedOn = publishedOn;
	}
	
	public String getTitle() {
		return title;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public String toString(){
		return new StringBuilder().append(title).toString();
	}
}

