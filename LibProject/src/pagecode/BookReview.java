package pagecode;

import java.security.Principal;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import databasecode.CommentReview;
import databasecode.CommentReviewManager;
import databasecode.Review;
import databasecode.ReviewManagerBean;
import databasecode.User;
import databasecode.UserManagerBean;

@ManagedBean
public class BookReview {
	@EJB
	ReviewManagerBean rm;
	@EJB
	CommentReviewManager crm;
	@EJB
	UserManagerBean um;
	
	int id = 0;
	Review review = null;
	
	String commentContent = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		this.review = (Review) rm.getReview(id);
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	private User getCurrentUser() {
		User user = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
		if(p == null) {
			user = null;
		}
		else {
			user = (User) um.getUser(p.getName());
		}
		
		return user;
	}
	
	public String addComment() {
		Review r = review;
		User u = getCurrentUser();
		if(r != null && u != null) {
			CommentReview cr = new CommentReview();
			cr.setReview(r);
			cr.setUser(u);
			cr.setContent(commentContent);
			cr.setAddDate(new Date());
			
			crm.saveCommentReview(cr);
			
			commentContent = "";
		}
		return "commentreviewadded";
	}
	
}
