package cs5004_hw7_problem1;

import java.lang.Comparable;

/**
 * Item.java
 * 
 * Item class creates objects that conatain a Name and a corresponding ID
 * number. compareTo() can be used to compare id numbers.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/9/2019
 * 
 */
public class Item implements Comparable<Object>
{
	private String name;
	private int id;

	/**
	 * This is the default constructor for the item class. it sets the ID to 0 and
	 * the name to NO_NAME to indicate that the Item truly has not been initialized
	 * yet
	 */
	public Item()
	{
		this.setId(0);
		this.setName("NO_NAME");
	}

	/**
	 * This is the constructor to initialize Item objects. Name and ID are given as
	 * parameters and assigned to the corresponding variables
	 * 
	 * @param name - String - name of person ID belongs to
	 * @param id   - int - ID of person associated with this object
	 */
	public Item(String name, int id)
	{
		this.setId(id);
		this.setName(name);
	}

	/**
	 * returns current name string
	 * 
	 * @return name - String - current name of person
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * sets the given parameter name to the new name of person associated with this
	 * object
	 * 
	 * @param name - String - new name to be set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * returns current ID integer
	 * 
	 * @return id - int - current ID number
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * checks validity of the ID given and sets it to the new ID.
	 * 
	 * @param id - int - new id to be set
	 */
	public void setId(int id)
	{
		if (id < 0)
		{
			System.err.println("Invalid ID");
			System.exit(-1);
		}
		this.id = id;
	}

	/**
	 * This function allows 2 Item objects (or any object that has compareTo() that
	 * returns an int) to be compared to each other. It returns an int relating the
	 * Id's of the objects to each other.
	 * 
	 * returning a negative value means this object is "lower" or "less-than" the
	 * parameter object. returning 0 means they are equal, and returning a positive
	 * number means that this object is "greater than" the parameter object.
	 * 
	 * @return int - value comparing this object to the given parameter object
	 */
	public int compareTo(Object o)
	{
		if (o == this)
		{
			return 0;
		}
		if (!(o.getClass() == Item.class))
		{
			throw new ClassCastException("ERROR: compareTo(Object o) - Object o not same Type as this object.");
		}

		Item other = (Item) o;

		return (this.getId() - other.getId());

	}

	/**
	 * returns a string with the name and ID of this object.
	 * 
	 * @return str - String - string description of this Item object
	 */
	public String toString()
	{
		String str = "";
		str += "Name: " + name + ", ID: " + id;

		return str;
	}

	/**
	 * returns a boolean indicating whether the parameter object and this object are
	 * equal or not
	 * 
	 * @return boolean
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o.getClass() == Item.class))
		{
			return false;
		}
		Item thing = (Item) o;

		return (this.getName() == thing.getName()) && (this.getId() == thing.getId());
	}

}
