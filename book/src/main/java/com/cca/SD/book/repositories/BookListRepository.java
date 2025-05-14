package com.cca.SD.book.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cca.SD.book.models.Book;


import java.util.ArrayList;
import java.util.Arrays;


@Repository
public class BookListRepository implements BookCRUD <Book,Long>
{
	
	private String bookName;
	private List<Book> books;
	public BookListRepository() {
		books = new ArrayList<Book>(Arrays.asList(
				new Book(1L,"Java Core","Prashant",650.5),
				new Book(2L,"JSP","Ashwini",750.5),
				new Book(3L,"Spring Boot","Sakshi",950.5),
				new Book(4L,"Angular","Harsha",850.5)));
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public List<Book> readBooks() {
		return books;
	}

	@Override
	public void createBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(Long bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book getBookByBno(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
