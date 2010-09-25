package pagecode;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import databasecode.Book;
import databasecode.BookManagerBean;
import databasecode.BorrowedBook;
import databasecode.CommentBook;
import databasecode.CommentBookManagerBean;
import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
@SessionScoped
public class ViewBook {
	@EJB
	BookManagerBean bm;
	@EJB
	UserManagerBean um;
	@EJB
	CommentBookManagerBean cbm;
	
	int id = 0;
	Book book = null;
	
	String commentContent = "";
	
	BorrowedBook userBorrow = null;
	BorrowedBook userWaitBorrow = null;
	
	Boolean isBookBorrowedByUser = false;
	Boolean isBookBorrowedByUserChecked = false;
	
	Boolean isUserWaiting = false;
	Boolean isUserWaitingChecked = false;
	
	Long waitingNumber;
	Boolean waitingNumberChecked = false;
	
	Boolean isBookAvailable = false;
	Boolean isBookAvailableChecked = false;
	
	public Book getBook() {
		return book;
	}
	
	public int getReviewsNumber() {
		return book.getReviews().size();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		this.book = (Book) bm.getBook(id);
		isBookBorrowedByUserChecked = false;
		isUserWaitingChecked = false;
		waitingNumberChecked = false;
		isBookAvailableChecked = false;
	}
	
	public boolean isBookAvailable() {
		if(isBookAvailableChecked == false) {
			isBookAvailable = bm.isBookAvailable(book);
			
			isBookAvailableChecked = true;
		}
		return isBookAvailable;
	}
	
	
	
	public Long getWaitingNumber() {
		if(waitingNumberChecked == false) {
			waitingNumber = bm.getWaitingToBorrowNumber(book);
		
			waitingNumberChecked = true;
		}
		return waitingNumber;
		
	}
	
	private User getCurrentUser() {
		User user = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
		if(p == null) {
			user = null;
		}
		else {
			user = (User) um.getUser(p.getName());
		}
		
		return user;
	}
	
	public boolean isUserWaiting() {
		if(isUserWaitingChecked == false) {
			userWaitBorrow = null;
			isUserWaiting = false;
			List<BorrowedBook> userWait = null;
			userWait = bm.getUserWaiting(book, getCurrentUser());
			if(userWait != null)
				if(userWait.isEmpty() == false) {
					userWaitBorrow = userWait.get(0);
					isUserWaiting = true;
				}
			isUserWaitingChecked = true;
		}
		return isUserWaiting;
	}
	
	public boolean isBookBorrowedByUser() {
		
		if(isBookBorrowedByUserChecked == false) { 
			isBookBorrowedByUser = false;
			userBorrow = null;
			List<BorrowedBook> listbb = null;
			listbb = bm.getBorrowed(book, getCurrentUser());
			if(listbb != null) {
				if(listbb.isEmpty() == false) {
					userBorrow = listbb.get(0);
					isBookBorrowedByUser = true;
				}
			}
			
			isBookBorrowedByUserChecked = true;
		}
		return isBookBorrowedByUser; 
	}
	
	public String deleteAsk() {
		
		if(isUserWaiting() == true) {
			bm.deleteBorrowedBook(userWaitBorrow);
		}
		
		return "books";
	}
	
	public String borrow() {
		BorrowedBook bb = new BorrowedBook();
		bb.setAskDate(new Date());
		bb.setBorrowDate(null);
		bb.setReturnDate(null);
		bb.setUser(getCurrentUser());
		bb.setBook(book);
		
		bm.saveBorrowedBook(bb);
		
		return "askborrowbook";
	}
	
	public String returnbook() {
		if(isBookBorrowedByUser() == true) {
			userBorrow.setReturnDate(new Date());
			
			bm.updateBorrowedBook(userBorrow);
		}
		
		return "returnbook";
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String addComment() {
		Book b = book;
		User u = getCurrentUser();
		if(b != null && u != null) {
			CommentBook cb = new CommentBook();
			cb.setBook(b);
			cb.setUser(u);
			cb.setContent(commentContent);
			cb.setAddDate(new Date());
			
			cbm.saveCommentBook(cb);
			
			commentContent = "";
		}
		return "commentbookadded";
	}
	
}
