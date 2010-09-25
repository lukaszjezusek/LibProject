package databasecode;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-16T11:10:23.717+0200")
@StaticMetamodel(Review.class)
public class Review_ {
	public static volatile SingularAttribute<Review, Integer> id;
	public static volatile SingularAttribute<Review, Book> book;
	public static volatile SingularAttribute<Review, User> user;
	public static volatile SingularAttribute<Review, String> content;
	public static volatile SingularAttribute<Review, Date> addDate;
	public static volatile CollectionAttribute<Review, CommentReview> comments;
}
