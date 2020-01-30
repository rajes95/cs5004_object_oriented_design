import cs5004_hw9_problem2.PriorityQueue;

/**
 * Problem_2.java
 * 
 * This program tests a PriorityQueue class implemented using an ArrayList. Add
 * is adding items to the queue with their given priority, and remove() removes
 * and returns the object in the PriorityQueue that has the highest priority.
 * 
 * The PriorityQueue class is tested for when it is given data with the same
 * priority order, in ascending and descending order as well as if the data is
 * mixed and includes negative priority values.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/29/2019
 * 
 */
public class Problem_2
{
	/**
	 * This class is where the class PriorityQueue is tested by giving it a variety
	 * of possible data orders and priority values.
	 * 
	 * @param args - not used
	 */
	public static void main(String[] args)
	{
		// data added with the same priority value as already-preasent data, have less
		// priority than objects with the same priority value that were there before
		// being added.
		System.out.println("Data given all have equal priority so data\nis ordered by the order it is provided in:");
		PriorityQueue<String> q = new PriorityQueue<String>();
		q.add("highest", 8);
		q.add("second highest", 8);
		q.add("third highest", 8);
		q.add("fourth highest", 8);
		q.add("fifth highest", 8);
		q.add("least", 8);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());

		// sorting data provided in ascending order
		System.out.println("-------------\nData given in ascending priority order:");
		PriorityQueue<String> r = new PriorityQueue<String>();
		r.add("one", 1);
		r.add("two", 2);
		r.add("three", 3);
		r.add("four", 4);
		r.add("five", 5);
		r.add("six", 6);
		System.out.println(r.remove());
		System.out.println(r.remove());
		System.out.println(r.remove());
		System.out.println(r.remove());
		System.out.println(r.remove());
		System.out.println(r.remove());

		// sorting data provided in descending order
		System.out.println("-------------\nData given in descending priority order:");
		PriorityQueue<String> s = new PriorityQueue<String>();
		s.add("six", 6);
		s.add("five", 5);
		s.add("four", 4);
		s.add("three", 3);
		s.add("two", 2);
		s.add("one", 1);
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());
		System.out.println(s.remove());

		// sorting data provided in a mixed order
		System.out.println("-------------\nData given in a mixed priority order:");
		PriorityQueue<String> t = new PriorityQueue<String>();
		t.add("four", 4);
		t.add("six", 6);
		t.add("two", 2);
		t.add("three", 3);
		t.add("one", 1);
		t.add("five", 5);
		System.out.println(t.remove());
		System.out.println(t.remove());
		System.out.println(t.remove());
		System.out.println(t.remove());
		System.out.println(t.remove());
		System.out.println(t.remove());

		// sorting data provided in a mixed priority order including some repitition and
		// negative values
		System.out.println(
				"-------------\nData given in a mixed priority order\nincluding repitition and negative priority:");
		PriorityQueue<String> u = new PriorityQueue<String>();
		u.add("-two", -2);
		u.add("two", 2);
		u.add("zero", 0);
		u.add("one", 1);
		u.add("zero again", 0);
		u.add("-one", -1);
		System.out.println(u.remove());
		System.out.println(u.remove());
		System.out.println(u.remove());
		System.out.println(u.remove());
		System.out.println(u.remove());
		System.out.println(u.remove());

		// sorting data provided in a mixed priority order and is of type Double this
		// time
		System.out.println(
				"-------------\nData given in a mixed priority order\nbut using double as the objects this time:");
		PriorityQueue<Double> v = new PriorityQueue<Double>();
		v.add(.002, 2);
		v.add(.006, 6);
		v.add(.005, 5);
		v.add(.001, 1);
		v.add(.004, 4);
		v.add(.003, 3);
		System.out.println(v.remove());
		System.out.println(v.remove());
		System.out.println(v.remove());
		System.out.println(v.remove());
		System.out.println(v.remove());
		System.out.println(v.remove());
	}

}
