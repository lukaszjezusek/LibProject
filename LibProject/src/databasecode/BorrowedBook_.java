package databasecode;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2010-08-25T19:39:46.138+0200")
@StaticMetamodel(BorrowedBook.class)
public class BorrowedBook_ {
	public static volatile SingularAttribute<BorrowedBook, Integer> id;
	public static volatile SingularAttribute<BorrowedBook, Book> book;
	public static volatile SingularAttribute<BorrowedBook, Date> askDate;
	public static volatile SingularAttribute<BorrowedBook, Date> borrowDate;
	public static volatile SingularAttribute<BorrowedBook, Date> returnDate;
	public static volatile SingularAttribute<BorrowedBook, User> user;
}
