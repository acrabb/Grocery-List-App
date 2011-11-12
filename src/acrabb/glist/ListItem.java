/**
 * Programmer: André Crabb / Zach Bush
 * Date Created: Nov 11, 2011
 * Date Modified: Nov 11, 2011
 *
 * REVISIONS:
 * 
**/

/**
*
*/
package acrabb.glist;

import java.util.ArrayList;

/**
 * @author Andre Crabb
 *
 */
public class ListItem {
    private String name;
    private float price;
    private int quantity;
    private ArrayList<Person> people;
    
    
    
    /**
     * @param name
     * @param price
     * @param people
     */
    public ListItem(String name, float price, int quantity, ArrayList<Person> people) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.people = people;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name - element to be assigned to the name field
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }
    /**
     * @param price - element to be assigned to the price field
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity - element to be assigned to the quantity field
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * Add a newPerson to the list of Persons that will pay for this item.
     * 
     * @param newPerson
     * @return
     */
    public boolean addPerson(Person newPerson) {
        if (people.contains(newPerson)) {
            return false;
        }
        //SORT?
        people.add(newPerson);
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof ListItem))
            return false;
        ListItem other = (ListItem) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equalsIgnoreCase(other.name))
            return false;
        return true;
    }
    
    
    
    
    
}
