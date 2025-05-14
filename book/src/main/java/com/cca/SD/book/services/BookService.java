package com.cca.SD.book.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cca.SD.book.models.Book;
import com.cca.SD.book.repositories.BookListRepository;
@Service
public class BookService {
	@Autowired
	private BookListRepository repo;
	public BookService() {
		//repo = new BookListRepository();
	}
	
	public String getBookName() {
		return repo.getBookName();
	}
	
	public List<Book> readBooks() {
		return repo.readBooks();
	}
}
