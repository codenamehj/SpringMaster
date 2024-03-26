package com.dbal.app.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbal.app.book.model.BookVO;
import com.dbal.app.book.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", bookService.getBookList());
		return "book/bookList";
	}
	
	@RequestMapping("/rentlist")
	public String rentlist(Model model) {
		model.addAttribute("rentlist", bookService.getRentList());
		return "book/rentBookList";
	}
	
	@RequestMapping("/insert")
	public String insertForm(Model model) {
		model.addAttribute("bookNo", bookService.getBookNo());
		return "book/bookInsert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO) {
		bookService.saveBook(bookVO);
		return "redirect:/list";
	}
}
