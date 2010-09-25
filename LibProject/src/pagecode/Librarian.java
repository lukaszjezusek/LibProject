package pagecode;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import databasecode.Book;
import databasecode.BookManagerBean;
import databasecode.BorrowedBook;

@ManagedBean
public class Librarian {
	@EJB
	BookManagerBean bm;
	
	public List<BorrowedBook> getAskBorrow() {
    	return bm.getAskBorrow();
    }
	
	public List<Book> getAvailableAskBorrow() {
		return bm.getAvailableAskBorrow();
	}
	
	public String borrow(Object borrowedBook) {
		BorrowedBook bb = (BorrowedBook) borrowedBook;
		bb.setBorrowDate(new Date());
		bm.updateBorrowedBook(bb);
		return "librarian";
	}
}
