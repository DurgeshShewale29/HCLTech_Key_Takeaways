package com.cca.SD.book.controllers;

import com.cca.SD.book.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.cca.SD.book.models.Book;

@Controller
@RestController
@RequestMapping("/book/api")
public class BookRESTController {
	@Autowired
	private BookService service;
	public BookRESTController() {
		//service= new BookService();
	}
	@GetMapping("/getbookname")
	public String getBookName() {
		return service.getBookName();
	}
	@GetMapping("/readbooks")
	public List<Book> readBooks() {
		return service.readBooks();
	}

}
