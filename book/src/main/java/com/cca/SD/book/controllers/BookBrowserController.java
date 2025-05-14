package com.cca.SD.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookBrowserController {
	@GetMapping({"","/"})
	public String showHomePage() {
		return "/book/homePage.html";
	}

}
