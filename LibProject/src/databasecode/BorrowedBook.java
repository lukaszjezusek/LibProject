package databasecode;

import databasecode.Book;
import databasecode.User;
import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BorrowedBook
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="getActiveBorrow", query="SELECT bb from BorrowedBook bb WHERE bb.book = :book AND bb.returnDate IS NULL AND bb.borrowDate IS NOT NULL"),
	@NamedQuery(name="getWaitingToBorrowNumber", query="SELECT COUNT(bb) from BorrowedBook bb WHERE bb.book = :book AND bb.borrowDate IS NULL"),
	@NamedQuery(name="getAskBorrowAll", query="SELECT bb from BorrowedBook bb WHERE bb.borrowDate IS NULL"),
	@NamedQuery(name="getAskBorrow", query="SELECT bb from BorrowedBook bb WHERE bb.borrowDate IS NULL AND bb.book NOT IN (SELECT DISTINCT bbb.book from BorrowedBook bbb WHERE bbb.borrowDate IS NOT NULL AND bbb.returnDate IS NULL)"),
	@NamedQuery(name="getAvailableAskBorrow", query="SELECT DISTINCT bb.book from BorrowedBook bb WHERE bb.book NOT IN (SELECT DISTINCT bbb.book from BorrowedBook bbb WHERE bbb.borrowDate IS NOT NULL AND bbb.returnDate IS NULL)"),
	@NamedQuery(name="getBorrowed", query="SELECT bb from BorrowedBook bb WHERE bb.borrowDate IS NOT NULL AND bb.returnDate IS NULL AND bb.user = :user AND bb.book = :book"),
	@NamedQuery(name="getUserWaiting", query="SELECT bb from BorrowedBook bb WHERE bb.borrowDate IS NULL AND bb.book = :book AND bb.user = :user"),
})

public class BorrowedBook implements Serializable {

	    
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Book book;
	@Temporal(TemporalType.DATE)
	private Date askDate;
	@Temporal(TemporalType.DATE)
	private Date borrowDate;
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	@ManyToOne
	private User user;
	private static final long serialVersionUID = 1L;

	public BorrowedBook() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}   
	public Date getAskDate() {
		return this.askDate;
	}

	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}   
	public Date getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}   
	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
