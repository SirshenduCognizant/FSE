/**
 * 
 */
package com.fsd.assign.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsd.assign.model.Book;

/**
 * @author 158797
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Book findByTitle(String title);
	
	@Modifying(clearAutomatically = true)
    @Query(
    		value ="UPDATE #{#entityName} b SET b.title = :title WHERE b.bookId = :bookId",
    		nativeQuery = true)
    void updateBook(@Param("bookId") long bookId, @Param("title") String title);
}
