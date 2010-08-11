package databasecode;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    
    public Object getBook(int id) {
    	return em.find(Book.class, id);
    } 
    
    @SuppressWarnings("unchecked")
	public List<Book> getBooksList() {
    	Query qu = em.createQuery("SELECT b FROM Book b");
    	List<Book> result = (List<Book>) qu.getResultList();
    	return result;
    }
}
