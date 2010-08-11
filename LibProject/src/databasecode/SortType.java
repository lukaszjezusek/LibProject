package databasecode;

public class SortType {
	String name;
	String queryName;
	
	public SortType(String name, String queryName) {
		super();
		this.name = name;
		this.queryName = queryName;
	}
	
	public SortType(SortType st) {
		this.name = st.name;
		this.queryName = st.queryName;
	}
	
	public String getName() {
		return name;
	}

	public String getQueryName() {
		return queryName;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof SortType))
			return false;
		else {
			SortType sp = (SortType) o;
			if(sp.name.equals(name) && sp.queryName.equals(queryName))
				return true;
			return false;
		} 
	}
	
	
}
