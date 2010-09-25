package databasecode;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    }
    
    public void saveReview(Object review) {
    	Review r = (Review) review;
    	em.persist(r);
    	em.flush();
    }

    
    public Object getReview(int id) {
    	try {
    		return (Review) em.createNamedQuery("getReviewWithComments").setParameter("id", id).getSingleResult();
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    	
    } 
}
