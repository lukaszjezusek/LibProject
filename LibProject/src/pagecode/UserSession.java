package pagecode;

import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginContext;
import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
@SessionScoped
public class UserSession {
	@EJB
	UserManagerBean um;
	
	User user = null;
	
	LoginContext lc = null;
	String userID = null;
	String password = null;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
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
		else {
			user = (User) um.getUser(p.getName());
		}
		
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
