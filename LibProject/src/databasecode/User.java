package databasecode;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="WEBUSER")
@NamedQueries({
	@NamedQuery(name="getUser", query="SELECT u from User u WHERE u.name = :name")
})
public class User implements Serializable {
	   
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<Review> reviews;
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private Collection<BorrowedBook> borrowedBooks;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	public Collection<BorrowedBook> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(Collection<BorrowedBook> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
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
