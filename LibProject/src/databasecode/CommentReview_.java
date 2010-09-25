package databasecode;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-09-16T11:05:20.528+0200")
@StaticMetamodel(CommentReview.class)
public class CommentReview_ {
	public static volatile SingularAttribute<CommentReview, Integer> id;
	public static volatile SingularAttribute<CommentReview, Review> review;
	public static volatile SingularAttribute<CommentReview, User> user;
	public static volatile SingularAttribute<CommentReview, String> content;
	public static volatile SingularAttribute<CommentReview, Date> addDate;
}
