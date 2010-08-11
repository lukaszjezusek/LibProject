package pagecode;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import databasecode.Book;
import databasecode.BookManagerBean;
import databasecode.SortType;

//import pagecode.controller.BookManager;
//import pagecode.controller.Testbean;

import java.util.*;

@ManagedBean
@SessionScoped
public class Books {
	
	@EJB
	BookManagerBean bm;
	
	int choosenSort = 0;
	
	public int getChoosenSort() {
		return choosenSort;
	}

	public void setChoosenSort(int choosenSort) {
		this.choosenSort = choosenSort;
	}
	
	public Collection<SelectItem> getSortSelectItems() {
		Collection<SelectItem> result = new ArrayList<SelectItem>();
		List<SortType> sorts = bm.getSortTypeList();
	
		for(int i = 0; i < sorts.size(); i++) {
			result.add(new SelectItem(i, sorts.get(i).getName()));
		}
		
		return result;
	}
	
	public List<Book> getBooksList() {
		return bm.getBooksListSorted(choosenSort);
	}
}