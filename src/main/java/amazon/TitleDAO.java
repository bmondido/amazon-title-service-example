package amazon;

import java.util.ArrayList;
import java.util.List;

public class TitleDAO {
	public List<Title> find(List<String> filters, List<String> sort){
		
		//compile the filters into the where clause query string
		//compile the sort values into the order by clause query string
		//TODO call the database 
		//any exceptions from database availability should be reported here
		return null;
	}
	
	public Title findById(int id, List<String> sort){
		//shortcut method to find by id
		ArrayList<String> filterList = new ArrayList<String>();
		filterList.add(String.valueOf(id));
		List<Title> returnList = find(filterList, sort);
		
		if(returnList.size() == 1){
			return returnList.get(0);
		} else{
			//report error that there's more than one title with same id
			return null;
		}
	}
	
	
}
