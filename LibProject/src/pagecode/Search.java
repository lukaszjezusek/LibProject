package pagecode;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import databasecode.Book;
import databasecode.BookManagerBean;
import databasecode.SortType;

import java.security.*;

import java.util.*;

@ManagedBean
public class Search {
	
	@EJB
	BookManagerBean bm;
	
	int choosenSort = 0;
	
	String searchTitle = "";
	String searchAuthor = "";
	
/*	public String getUsr() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
		return p.getName();
	} */
	
	public String getSearchTitle() {
		return searchTitle;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public String getSearchAuthor() {
		return searchAuthor;
	}

	public void setSearchAuthor(String searchAuthor) {
		this.searchAuthor = searchAuthor;
	}

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
		return bm.getBooksListSorted(choosenSort, searchTitle, searchAuthor);
	}
	
	public int getResultsNumber() {
		return getBooksList().size();
	}
}