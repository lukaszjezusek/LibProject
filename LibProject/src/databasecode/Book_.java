package databasecode;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-19T17:48:07.778+0200")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> picsrc;
	public static volatile CollectionAttribute<Book, Review> reviews;
	public static volatile CollectionAttribute<Book, CommentBook> comments;
	public static volatile CollectionAttribute<Book, BorrowedBook> borrowed;
}
