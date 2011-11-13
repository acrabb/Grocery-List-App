/**
 * 
 */
package acrabb.glist;

import java.util.ArrayList;

/**
 * @author zach
 *
 */
public class List {
	private String name;
	private int id;
	private ArrayList<ListItem> items;
	
	public List(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ListItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<ListItem> items) {
		this.items = items;
	}
	
	public void loadFromDatabase(){
		// Load from the database
	}
	
	public boolean removeItem(ListItem item){
		return items.remove(item);
	}
	
	public void addItem(ListItem item){
		if(!items.contains(item)){
			items.add(item);
		}else{
			//TODO Combine items
		}
	}

	public long getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
