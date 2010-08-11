package databasecode;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="getBooksSortByTitleASC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.title ASC"),
	@NamedQuery(name="getBooksSortByTitleDESC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.title DESC"),
	@NamedQuery(name="getBooksSortByAuthorASC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.author ASC"),
	@NamedQuery(name="getBooksSortByAuthorDESC", query="SELECT b from Book b WHERE b.title LIKE :title AND b.author LIKE :author ORDER BY b.author DESC")
})
public class Book implements Serializable {

	   
	@Id
	private Integer id;
	private String title;
	private String author;
	private String picsrc;
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
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