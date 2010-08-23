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
	   
	@Id
	private Integer id;
	private String name;
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private Collection<Review> reviews;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	//	reviews = new ArrayList<Review>();
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
	//public void setReviews(List<Review> reviews) {
	//	this.reviews = reviews;
	////}
	//public List<Review> getReviews() {
	//	return reviews;
	//}
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
