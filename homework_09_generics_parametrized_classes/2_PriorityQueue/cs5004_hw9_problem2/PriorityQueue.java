package cs5004_hw9_problem2;

import java.util.ArrayList;

/**
 * The PriorityQueue is capable of holding objects of an arbitrary type T. It is
 * implemented using an ArrayList. All items added have an associated priority
 * and the largest priority is removed first when remove() is called.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/29/2019
 */
public class PriorityQueue<T>
{
	// queue holds the objects in the PriorityQueue
	private ArrayList<T> queue;

	// priority holds all of the respective priorities
	private ArrayList<Integer> priority;

	/**
	 * Default constructor for PriorityQueue. Initializes the ArrayLists queue and
	 * priority but leaves them without any values.
	 */
	public PriorityQueue()
	{
		this.setQueue(new ArrayList<T>());
		this.setPriority(new ArrayList<Integer>());
	}

	/**
	 * This constructor is used when the PriorityQueue already has SORTED ArrayLists
	 * of Object and Integer type for the queue objects and priority values
	 * respectively.
	 * 
	 * @param queue    - ArrayList<Object> - SORTED ArrayList of objects
	 * @param priority - ArrayList<Integer> - SORTED ArrayList of Integer objects
	 *                 which hold the priority values to the corresponding index in
	 *                 the queue Arraylist
	 */
	public PriorityQueue(ArrayList<T> queue, ArrayList<Integer> priority)
	{
		this.setQueue(queue);
		this.setPriority(priority);
	}

	/**
	 * returns the ArrayList<Integer> priority which is private in this class
	 * 
	 * @return priority - ArrayList<Integer> - ArrayList of priority values for
	 *         objects in queue
	 */
	public ArrayList<Integer> getPriority()
	{
		return priority;
	}

	/**
	 * sets a new array to the priority ArrayList. mostly for use within the class
	 * but still has public access.
	 * 
	 * It MUST be given sorted priority values.
	 * 
	 * @param priority - new Integer ArrayList of priority values
	 */
	public void setPriority(ArrayList<Integer> priority)
	{
		this.priority = priority;
	}

	/**
	 * returns the ArrayList<Object> queue which is private in this class
	 * 
	 * @return queue - ArrayList<Object> - ArrayList of objects
	 */
	public ArrayList<T> getQueue()
	{
		return queue;
	}

	/**
	 * Sets a new ArrayList to the queue ArrayList. mostly for use within the class
	 * but still has public access.
	 * 
	 * It MUST be given sorted queue objects.
	 * 
	 * @param queue - new Object ArrayList to set for this PriorityQueue
	 */
	public void setQueue(ArrayList<T> queue)
	{
		this.queue = queue;
	}

	/**
	 * Takes an object and places it into the queue based on what priority value it
	 * has and placing the priority value into that same respective spot in the
	 * priority ArrayList of Integer objects.
	 * 
	 * @param o        - Object - object that is placed into the queue
	 * @param priority - int - the priority of that object placed into queue
	 */
	public void add(T o, int priority)
	{
		int index = 0;

		if (this.getPriority().size() != 0)
		{
			index = this.getPriority().size(); // relevant if it has the highest priority
		}

		for (int i = 0; i < this.getPriority().size(); i++)
		{
			if (priority <= this.getPriority().get(i))
			{
				index = i;
				break;
			}
		}

		this.getPriority().add(index, priority);
		this.getQueue().add(index, o);
	}

	/**
	 * remove the highest priority (in this case last index) object and associated
	 * priority value from the Arraylists
	 * 
	 * @return Object - object that is deleted from the PriorityQueue
	 */
	public Object remove()
	{
		this.getPriority().remove(this.getPriority().size() - 1);
		return this.getQueue().remove(this.getQueue().size() - 1);
	}

	/**
	 * Returns a string representation of the PriorityQueue printing out the values
	 * and their respective priorities.
	 * 
	 * @return str - String - String representation of the PriorityQueue
	 */
	public String toString()
	{
		String str = "";

		for (int i = this.getPriority().size() - 1; i >= 0; i--)
		{
			str += this.getPriority().get(i) + " : " + this.getQueue().get(i) + "\n";
		}
		return str;
	}

	/**
	 * This function tests to see whether the provided param object is equal to this
	 * object, and returns a boolean value to indicate the result of the test
	 * 
	 * @param o - Object - any object which can be passed to this function to see if
	 *          it is equivalent to this object
	 * @return equals - boolean - true or false depending on whether the parameter
	 *         object is equivalent to this object or not
	 */
	public boolean equals(Object o)
	{
		boolean equals = true;

		if (o == this)
		{
			return true;
		}
		if (!(o.getClass() == this.getClass()))
		{
			return false;
		}
		
		PriorityQueue<?> Pque = (PriorityQueue<?>) o;
		
		for (int i = this.getPriority().size() - 1; i >= 0; i--)
		{
			if (this.getPriority().get(i) != Pque.getPriority().get(i)
					|| !this.getQueue().get(i).equals(Pque.getQueue().get(i)))
			{
				equals = false;
				break;
			}
		}

		return equals;

	}

}