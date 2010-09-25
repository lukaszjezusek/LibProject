package pagecode;

import java.security.Principal;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import databasecode.Book;
import databasecode.BookManagerBean;
import databasecode.Review;
import databasecode.ReviewManagerBean;
import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
public class AddReview {
	@EJB
	BookManagerBean bm;
	@EJB
	UserManagerBean um;
	@EJB
	ReviewManagerBean rm;
	
	String content;
	int bookId;
	Book book = null;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
		this.book = (Book) bm.getBook(bookId);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String addReview() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
		Book b = (Book) bm.getBook(bookId);
		User u = (User) um.getUser(p.getName());
		if(b != null && u != null) {
			Review r = new Review();
			r.setBook(b);
			r.setUser(u);
			r.setContent(content);
			r.setAddDate(new Date());
			
			rm.saveReview(r);
		}
		return "reviewadded";
	}
}
