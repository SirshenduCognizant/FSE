/**
 * 
 */
package com.fsd.assign.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 158797
 *
 */
@Entity
@Table(name="book")
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7939271189952983009L;
	
	@Id
	@Column(name = "bookId", nullable = false)
	long bookId;
	
	@Column(name = "title", nullable = true)
	String title;
	
	@Column(name = "price", nullable = true)
	double price;
	
	@Column(name = "volume", nullable = true)
	int volume;
	
	@Column(name = "publishDate", nullable = true)
	String publishDate;
	
	public Book() {
		super();
	}
	
	public Book(long bookId, String title, double price, int volume, String publishDate) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
	
	/**
	 * @return the bookId
	 */
	public long getBookId() {
		return bookId;
	}
	
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	/**
	 * @return the publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}
	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
}
