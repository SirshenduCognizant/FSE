package com.fsd.assign.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsd.assign.model.Book;
import com.fsd.assign.model.Subject;
import com.fsd.assign.orm.repository.BookRepository;
import com.fsd.assign.orm.repository.SubjectRepository;

@Service("hibernateService")
@Transactional
public class HibernateServiceImpl implements HibernateService{

	/*@Autowired
	private HibernateDao dao;*/
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#saveSubject(com.fsd.assign.model.Subject)
	 */
	public void saveSubject(Subject sub) {
		subjectRepository.save(sub);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#saveBook(com.fsd.assign.model.Book)
	 */
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findAllSubjects()
	 */
	public List<Subject> findAllSubjects() {
		return subjectRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findAllBooks()
	 */
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#deleteBookById(long)
	 */
	public void deleteBookById(long bookId) {
		bookRepository.deleteById(bookId);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#deleteSubjectById(long)
	 */
	public void deleteSubjectById(long subId) {
		subjectRepository.deleteById(subId);;
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findBySubId(long)
	 */
	public Optional<Subject> findBySubId(long subId) {
		return subjectRepository.findById(subId);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findBybookId(long)
	 */
	public Optional<Book> findBybookId(long bookId){
		return bookRepository.findById(bookId);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findByBookTitle(long)
	 */
	public Book findByBookTitle(String bookTitle){
		return bookRepository.findByTitle(bookTitle);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findBySubjectDuration(int)
	 */
	public Subject findBySubjectDuration(int durationInHours){
		return subjectRepository.findByDurationInHours(durationInHours);
	}
	
	/* (non-Javadoc)
	 * @see com.fsd.assign.service.HibernateService#findBySubjectDuration(int)
	 */
	public void updateBook(long bookId, String newTitle){
		 bookRepository.updateBook(bookId, newTitle);
	}
	
}
