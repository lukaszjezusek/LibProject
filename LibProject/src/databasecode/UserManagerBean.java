package databasecode;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserManagerBean
 */
@Stateless
@LocalBean
public class UserManagerBean {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserManagerBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Object getUser(String name) {
    	try {
    		return (User) em.createNamedQuery("getUser").setParameter("name", name).getSingleResult();
    	}
    	catch(NoResultException e) {
    		return null;
    	}
    }

}
