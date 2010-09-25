package databasecode;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CommentBookManagerBean
 */
@Stateless
@LocalBean
public class CommentBookManagerBean {
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CommentBookManagerBean() {
    }
    
    public void saveCommentBook(Object commentBook) {
    	CommentBook cb = (CommentBook) commentBook;
    	em.persist(cb);
    	em.flush();
    }

}
