package com.fsd.assign.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.assign.model.Book;
import com.fsd.assign.model.Subject;
import com.fsd.assign.service.HibernateService;

//@CrossOrigin()
@RestController
public class HelloWorldRestController {

	private static final String ERROR_STATUS = "error";

	@Autowired
	HibernateService service;

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/newBookPost", method = RequestMethod.POST)
	public ResponseEntity newBookPost(@RequestBody Book book) {
		System.out.println("NEW Book Post Called." + book);
		if (0 != book.getBookId()) {
			service.saveBook(book);
			return new ResponseEntity<>("Successfully Book save", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ERROR_STATUS + ":::: New Book not save", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/updateBookPut", method = RequestMethod.PUT)
	public ResponseEntity updateBookPut(@RequestBody Book book) {
		System.out.println("UPDATE Book Post Called." + book);
		if (0 != book.getBookId()) {
			service.updateBook(book.getBookId(), book.getTitle());
			return new ResponseEntity<>("Book Update Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ERROR_STATUS + ":::: New Information is not update", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ResponseEntity delteBook(@RequestParam(value = "key") long key) {
		try {
			service.deleteBookById(key);
			return new ResponseEntity<>("Book Key Deleted Succussfully", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ERROR_STATUS + "::: No Book exists with this key", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
	public ResponseEntity deleteSubject(@RequestParam(value = "key") long key) {
		try {
			service.deleteSubjectById(key);
			return new ResponseEntity<>("Book Key Deleted Succussfully", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(ERROR_STATUS + "::: No Book exists with this key", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/searchBook", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> searchBook(@RequestParam(value = "key") long key) {
		List<Book> bookAll = new ArrayList<Book>();
		if (0 != key) {
			Optional<Book> book = service.findBybookId(key);
			bookAll.add(book.get());
			return new ResponseEntity<List<Book>>(bookAll, HttpStatus.OK);
		} else {
			bookAll.add(new Book());
			return new ResponseEntity<List<Book>>(bookAll, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> searchSubject(@RequestParam(value = "key") long key) {
		List<Subject> subAll = new ArrayList<Subject>();
		if (0 != key) {
			Optional<Subject> sub = service.findBySubId(key);
			subAll.add(sub.get());
			return new ResponseEntity<List<Subject>>(subAll, HttpStatus.OK);
		} else {
			subAll.add(new Subject());
			return new ResponseEntity<List<Subject>>(subAll, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/searchAllBook", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> searchAllBook() {
		List<Book> bookAll = service.findAllBooks();
		return new ResponseEntity<List<Book>>(bookAll, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchAllSubject", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> searchAllSubject() {
		List<Subject> subjectAll = service.findAllSubjects();
		return new ResponseEntity<List<Subject>>(subjectAll, HttpStatus.OK);
	}
}
