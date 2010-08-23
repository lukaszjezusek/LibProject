package pagecode;

import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
@SessionScoped
public class UserSession {
	@EJB
	UserManagerBean um;
	
	User user = null;
	
	public User getUser() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
		if(p == null) {
			user = null;
		}
		else if(user != null) {
			if(user.getName().equals(p.getName())) {
				return user;
			}
		}
		
		user = (User) um.getUser(p.getName());
		
		return user;
	}
	
	public boolean isLogged() {
		if(getUser() == null) {
			return false;
		}
		
		else
			return true;
	}
}
