package databasecode;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Session Bean implementation class BookManagerBean
 */

@Stateless
@LocalBean
public class BookManagerBean {
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BookManagerBean() {
    }
    
    public List<SortType> getSortTypeList() {
    	List<SortType> result = new ArrayList<SortType>();
    	result.add(new SortType("tytuly, rosnaco", "getBooksSortByTitleASC"));
    	result.add(new SortType("tytuly, malejaco", "getBooksSortByTitleDESC"));
    	result.add(new SortType("autorzy, rosnaco", "getBooksSortByAuthorASC"));
    	result.add(new SortType("autorzy, malejaco", "getBooksSortByAuthorDESC"));
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Book> getBooksListSorted(int type, String title, String author) {
    	SortType st = getSortTypeList().get(type);
    	List<Book> result = (List<Book>) em.createNamedQuery(st.queryName).setParameter("title", "%"+title+"%").setParameter("author", "%"+author+"%").getResultList();
    	return result;
    }
    
    public List<Book> getBooksListSorted(int type) {
    	return getBooksListSorted(type, "", "");
    }
    
    public Object getBook(int id) {
    	try {
    		return (Book) em.createNamedQuery("getBookWithCommentsAndReviews").setParameter("id", id).getSingleResult();
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    	
    } 
    
    @SuppressWarnings("unchecked")
	public boolean isBookAvailable(Object book) {
    	// czy ksiazka jest aktualnie dostepna do wypozyczenia
    	try {
    		List<BorrowedBook> listbb = (List<BorrowedBook>) em.createNamedQuery("getActiveBorrow").setParameter("book", (Book) book).getResultList();
    		if (listbb.isEmpty())
    			return true;
    		else
    			return false;
    	}
    	catch (Exception e) {
    		return true;
    	}
    }
    
    @SuppressWarnings("unchecked")
	public List<BorrowedBook> getBorrowed(Object book, Object user) {
    	Book b = (Book) book;
    	User u = (User) user;
    	List<BorrowedBook> result = null;
    	try {
    		result = (List<BorrowedBook>) em.createNamedQuery("getBorrowed").setParameter("user", u).setParameter("book", b).getResultList();
    	}
    	catch(Exception e) {
    		result = null;
    	}
    	
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<BorrowedBook> getUserWaiting(Object book, Object user) {
    	// zwraca nieropatrzone zapytania o wypozyczenie
    	Book b = (Book) book;
    	User u = (User) user;
    	List<BorrowedBook> result = null;
    	try {
    		result = (List<BorrowedBook>) em.createNamedQuery("getUserWaiting").setParameter("book", b).setParameter("user", u).getResultList();
    	}
    	catch(Exception e) {
    		result = null;
    	}
    	
    	return result;
    }
    
    public void saveBorrowedBook(Object borrowedBook) {
    	BorrowedBook bb = (BorrowedBook) borrowedBook;
    	em.persist(bb);
    	em.flush();
    }
    
    public void updateBorrowedBook(Object borrowedBook) {
    	BorrowedBook bb = (BorrowedBook) borrowedBook;
    	em.merge(bb);
    	em.flush();
    }
    
    public void deleteBorrowedBook(Object borrowedBook) {
    	BorrowedBook bb = (BorrowedBook) borrowedBook;
    	BorrowedBook bbb = em.merge(bb);
    	em.remove(bbb);
    	em.flush();
    }
    
    @SuppressWarnings("unchecked")
	public List<BorrowedBook> getAskBorrow() {
    	List<BorrowedBook> result = (List<BorrowedBook>) em.createNamedQuery("getAskBorrow").getResultList();
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Book> getAvailableAskBorrow() {
    	List<Book> result = (List<Book>) em.createNamedQuery("getAvailableAskBorrow").getResultList();
    	return result;
    }
    
    public Long getWaitingToBorrowNumber(Object book) {
    	Long result = (Long) em.createNamedQuery("getWaitingToBorrowNumber").setParameter("book", (Book) book).getSingleResult();
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Book> getBooksList() {
    	Query qu = em.createQuery("SELECT b FROM Book b");
    	List<Book> result = (List<Book>) qu.getResultList();
    	return result;
    }
}
