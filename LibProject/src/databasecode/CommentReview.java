package databasecode;

import databasecode.Review;
import databasecode.User;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommentReview
 *
 */
@Entity

public class CommentReview implements Serializable {

	   
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Review review;
	@ManyToOne
	private User user;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date addDate;
	private static final long serialVersionUID = 1L;

	public CommentReview() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Review getReview() {
		return this.review;
	}

	public void setReview(Review review) {
		this.review = review;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public String getAddDateString() {
		return addDate.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentReview other = (CommentReview) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
   
}
