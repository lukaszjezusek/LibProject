package databasecode;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-08-20T11:11:48.151+0200")
@StaticMetamodel(Review.class)
public class Review_ {
	public static volatile SingularAttribute<Review, Integer> id;
	public static volatile SingularAttribute<Review, Book> book;
	public static volatile SingularAttribute<Review, User> user;
	public static volatile SingularAttribute<Review, String> content;
	public static volatile SingularAttribute<Review, Date> addDate;
}
