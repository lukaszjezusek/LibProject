package pagecode;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import databasecode.Book;
import databasecode.BookManagerBean;

@ManagedBean
public class ViewBook {
	@EJB
	BookManagerBean bm;
	int id = 0;
	Book book = null;
	
	public Book getBook() {
		return book;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		this.book = (Book) bm.getBook(id);
	}
	
	
}
