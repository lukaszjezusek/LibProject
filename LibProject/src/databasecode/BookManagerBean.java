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
	//@PersistenceContext(type=PersistenceContextType.EXTENDED)
	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public BookManagerBean() {
        // TODO Auto-generated constructor stub
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
    
    // TODO: Tutaj powinien byc zwracany Book zamiast Object
    /* Po zamianie:
     * javax.ejb.EJBException: See nested exception; nested exception is: <openjpa-2.1.0-SNAPSHOT-r422266:935231 fatal user error> org.apache.openjpa.persistence.ArgumentException: Errors encountered while resolving metadata. See nested exceptions for details.

Caused by:
org.apache.openjpa.persistence.ArgumentException - The type "class databasecode.Book" has not been enhanced.


     */
    public Object getBook(int id) {
    	//return em.find(Book.class, id);
    	
    	try {
    		return (Book) em.createNamedQuery("getBookWithReviews").setParameter("id", id).getSingleResult();
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    	
    	} 
    
    @SuppressWarnings("unchecked")
	public List<Book> getBooksList() {
    	Query qu = em.createQuery("SELECT b FROM Book b");
    	List<Book> result = (List<Book>) qu.getResultList();
    	return result;
    }
}
