package com.fsd.assign.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fsd.assign.model.Book;
import com.fsd.assign.model.Subject;
import com.fsd.assign.orm.repository.BookRepository;
import com.fsd.assign.orm.repository.SubjectRepository;



@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateServiceImplTest {
	
	@Mock
	BookRepository bookRepository;
	
	@Mock
	SubjectRepository subjectRepository;
	
	@InjectMocks
	HibernateServiceImpl hibernateService;
	
	@Spy
	static
	List<Subject> subs = new ArrayList<Subject>();
	
	@Spy
	static
	List<Book> books = new ArrayList<Book>();
	
	/*@BeforeClass
	public static void setUp(){
		//MockitoAnnotations.initMocks(this);
		subs = getSubjectList();
		books = getBookList();
	}*/
	
	@Test
	public void saveSubject() {
		Subject sub = new Subject(11,"Todo Sample 8",11);
		hibernateService.saveSubject(sub);
		
		verify(subjectRepository, times(1)).save(sub);
	}
	
	@Test
	public void saveBook() {
		Book book = new Book(111L,"Todo Sample 8",111,111,"2012-12-23");
		hibernateService.saveBook(book);
		
		verify(bookRepository, times(1)).save(book);
	}
	
	@Test
	public void findAllSubjects(){
		List<Subject> subs = new ArrayList<Subject>();
		subs.add( new Subject(11,"Todo Sample 8",11));
		subs.add( new Subject(12,"Todo Sample 8",12));
		subs.add( new Subject(13,"Todo Sample 8",13));
		when(subjectRepository.findAll()).thenReturn(subs);
		
		List<Subject> result = hibernateService.findAllSubjects();
		assertEquals(3, result.size());
	}
	
	@Test
	public void findAllBooks(){
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(111L,"Todo Sample 8",111,111,"2012-12-23"));
		books.add(new Book(222L,"Todo Sample 8",222,222,"2012-12-23"));
		books.add(new Book(333L,"Todo Sample 8",333,333,"2012-12-23"));
		when(bookRepository.findAll()).thenReturn(books);
		
		List<Book> result = hibernateService.findAllBooks();
		assertEquals(3, result.size());
	}
	
	@Test
	public void deleteBookById() {
		hibernateService.deleteBookById(111L);
		verify(bookRepository, times(1)).deleteById(111L);
	}
	
	@Test
	public void deleteSubjectById() {
		hibernateService.deleteSubjectById(11L);
		verify(subjectRepository, times(1)).deleteById(11L);
	}
	
	@Test
	public void findBySubId() {
		Subject sub = new Subject(11L,"Todo Sample 8",11);
		Optional<Subject> subOP = Optional.of(sub);
		when(subjectRepository.findById(11L)).thenReturn(subOP);
		
		Optional<Subject> result = hibernateService.findBySubId(11L);
		assertEquals(true, result.isPresent());
		assertEquals(11, result.get().getSubjectid());
		assertEquals("Todo Sample 8", result.get().getSubtitle());
		assertEquals(11, result.get().getDurationInHours());
		
	}
	
	@Test
	public void findByBookId() {
		Book book = new Book(111L,"Todo Sample 8",111,111,"2012-12-23");
		Optional<Book> bookOP = Optional.of(book);
		when(bookRepository.findById(111L)).thenReturn(bookOP);
		
		Optional<Book> result = hibernateService.findBybookId(111L);
		assertEquals(111L, result.get().getBookId());
		assertEquals("Todo Sample 8", result.get().getTitle());
		assertEquals(111, result.get().getVolume());
		assertEquals("2012-12-23", result.get().getPublishDate());
		
	}
	
	@Test
	public void findByBookTitle(){
		Book book = new Book(111L,"Todo Sample 8",111,111,"2012-12-23");
		when(bookRepository.findByTitle("Todo Sample 8")).thenReturn(book);
		
		Book result = hibernateService.findByBookTitle("Todo Sample 8");
		assertEquals(111L, book.getBookId());
		assertEquals("Todo Sample 8", book.getTitle());
		assertEquals(111, book.getVolume());
		assertEquals("2012-12-23", book.getPublishDate());
	}
	
	@Test
	public void findBySubjectDuration() {
		Subject sub = new Subject(11L,"Todo Sample 8",11);
		when(subjectRepository.findByDurationInHours(11)).thenReturn(sub);
		
		Subject result = hibernateService.findBySubjectDuration(11);
		assertEquals(11, result.getSubjectid());
		assertEquals("Todo Sample 8", result.getSubtitle());
		assertEquals(11, result.getDurationInHours());
	}
	
	public void updateBook(long bookId, String newTitle){
		hibernateService.updateBook(111L, "Todo Sample 10");
		verify(bookRepository, times(1)).updateBook(111L, "Todo Sample 10");
	}

}
