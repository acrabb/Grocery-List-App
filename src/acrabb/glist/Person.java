/**
 * Programmer: André Crabb
 * Chapter  - Exercise 
 * Date Created: Nov 11, 2011
 * Date Modified: Nov 11, 2011
 *
 * Problem Statement/Notes:
 *
 * Overall Plan:
 * 1.
 * etc.
 *
 * REVISIONS:
 * 
**/

/**
*
*/
package acrabb.glist;

/**
 * @author Andre Crabb
 *
 */
public class Person {
    private String name;
    
    
    /**
     * @param name
     */
    public Person(String name) {
        this.name = name.toLowerCase();
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
        if (!(obj instanceof Person))
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
    
    
}
