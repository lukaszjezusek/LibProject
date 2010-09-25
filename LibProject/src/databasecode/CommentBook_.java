package databasecode;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-16T09:08:04.734+0200")
@StaticMetamodel(CommentBook.class)
public class CommentBook_ {
	public static volatile SingularAttribute<CommentBook, Integer> id;
	public static volatile SingularAttribute<CommentBook, Book> book;
	public static volatile SingularAttribute<CommentBook, User> user;
	public static volatile SingularAttribute<CommentBook, String> content;
	public static volatile SingularAttribute<CommentBook, Date> addDate;
}
