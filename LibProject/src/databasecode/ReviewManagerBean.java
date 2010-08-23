package databasecode;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ReviewManagerBean
 */
@Stateless
@LocalBean
public class ReviewManagerBean {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ReviewManagerBean() {
        // TODO Auto-generated constructor stub
    }
    
    public void saveReview(Object review) {
    	Review r = (Review) review;
    	em.persist(r);
    	em.flush();
    }

}
