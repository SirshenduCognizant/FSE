package com.fsd.assign.service;

import java.util.List;
import java.util.Optional;

import com.fsd.assign.model.Book;
import com.fsd.assign.model.Subject;

public interface HibernateService {

	void saveSubject(Subject sub);

	void saveBook(Book book);

	List<Subject> findAllSubjects();

	List<Book> findAllBooks();

	void deleteBookById(long bookId);

	void deleteSubjectById(long subId);

	Optional<Subject> findBySubId(long subId);

	Optional<Book> findBybookId(long bookId);
	
	Book findByBookTitle(String bookTitle);
	
	Subject findBySubjectDuration(int durationInHours);
	
	void updateBook(long bookId, String newTitle);

}