package databasecode;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-08-04T15:38:42.513+0200")
@StaticMetamodel(Book.class)
public class Book_ {
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> picsrc;
}