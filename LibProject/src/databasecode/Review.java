package databasecode;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="getReviewWithComments", query="SELECT r from Review r LEFT JOIN FETCH r.comments WHERE r.id = :id")
})

public class Review implements Serializable {

	    
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	private Book book;
	@ManyToOne
	private User user;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date addDate;
	@OneToMany(mappedBy="review", fetch=FetchType.LAZY)
	private Collection<CommentReview> comments;
	private static final long serialVersionUID = 1L;

	public Review() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Book getBook() {
		return book;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddDateString() {
		return addDate.toString();
	}
	
	
	public Collection<CommentReview> getComments() {
		return comments;
	}
	public void setComments(Collection<CommentReview> comments) {
		this.comments = comments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Review)) {
			return false;
		}
		Review other = (Review) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
   
}
