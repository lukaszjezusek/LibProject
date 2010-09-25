package databasecode;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CommentReviewManager
 */
@Stateless
@LocalBean
public class CommentReviewManager {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CommentReviewManager() {
    }
    
    public void saveCommentReview(Object commentReview) {
    	CommentReview cr = (CommentReview) commentReview;
    	em.persist(cr);
    	em.flush();
    }

}
