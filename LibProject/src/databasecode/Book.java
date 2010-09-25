package databasecode;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

import databasecode.Review;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="getBooksSortByTitleASC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.title ASC"),
	@NamedQuery(name="getBooksSortByTitleDESC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.title DESC"),
	@NamedQuery(name="getBooksSortByAuthorASC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.author ASC"),
	@NamedQuery(name="getBooksSortByAuthorDESC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.author DESC"),
	@NamedQuery(name="getBookWithReviews", query="SELECT b from Book b LEFT JOIN FETCH b.reviews WHERE b.id = :id"),
	@NamedQuery(name="getBookWithComments", query="SELECT b from Book b LEFT JOIN FETCH b.comments WHERE b.id = :id"),
	@NamedQuery(name="getBookWithCommentsAndReviews", query="SELECT b from Book b LEFT JOIN FETCH b.comments JOIN FETCH b.reviews WHERE b.id = :id")
})
public class Book implements Serializable {

	   
	@Id
	private Integer id;
	private String title;
	private String author;
	private String picsrc;
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private Collection<Review> reviews;
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private Collection<CommentBook> comments;
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private Collection<BorrowedBook> borrowed;
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
		reviews = new ArrayList<Review>();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}   
	public String getPicsrc() {
		return this.picsrc;
	}

	public void setPicsrc(String picsrc) {
		this.picsrc = picsrc;
	}
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public Collection<CommentBook> getComments() {
		return comments;
	}
	public void setComments(Collection<CommentBook> comments) {
		this.comments = comments;
	}
	public Collection<BorrowedBook> getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(Collection<BorrowedBook> borrowed) {
		this.borrowed = borrowed;
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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
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
