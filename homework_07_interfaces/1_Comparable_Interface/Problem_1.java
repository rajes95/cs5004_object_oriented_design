import java.lang.Comparable;
import cs5004_hw7_problem1.Item;

/**
 * Problem_1.java
 * 
 * This class creates 5 objects of type Item in a 5 item array of type
 * Comparable (which is an Interface) and then prints them out before and after
 * sorting into ascending order based on Identification number using selection
 * sort.
 * 
 * @author Rajesh Sakhamuru
 * @version 7/9/2019
 * 
 */
public class Problem_1
{

	/**
	 * This is the main where all of the code to create and sort the objects in the
	 * array is exectured
	 * 
	 * @param args - String[] - unused
	 */
	public static void main(String[] args)
	{

		@SuppressWarnings("unchecked")
		Comparable<Object>[] array = (Comparable<Object>[]) new Comparable[5];

		// creates 5 objects of Item type (which implements Comparable)
		array[0] = new Item("Jim", 9017);
		array[1] = new Item("Bob", 2349);
		array[2] = new Item("Pam", 1194);
		array[3] = new Item("May", 8383);
		array[4] = new Item("Don", 7000);

		System.out.println("Before Sorting:");
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(i + ": " + array[i]);
		}

		System.out.println("-----------------\nAfter Sorting:");
		sort(array, array.length); // selection sort

		for (int i = 0; i < array.length; i++)
		{
			System.out.println(i + ": " + array[i]);
		}

	}

	/**
	 * This sort method uses a traditional selection sort with the compareTo methods
	 * to order the array of objects given 'a' to be in ascending order.
	 * 
	 * The smallest index is found and moved to the beginning of the array, and for
	 * each iteration of the for-loop in this function a smaller subset (smaller by
	 * 1) of the array has it's smallest index object located and moved.
	 * 
	 * @param a          - Comparable[] - array of Comparable objects which have
	 *                   compareTo methods.
	 * @param numberUsed - int - end index up to which to sort the given array
	 */
	private static void sort(Comparable<Object>[] a, int numberUsed)
	{
		int index, nextSmallestIndex;
		for (index = 0; index < numberUsed - 1; index++)
		{
			nextSmallestIndex = indexOfSmallest(index, a, numberUsed);
			swap(index, nextSmallestIndex, a);
		}
	}

	/**
	 * This function finds the Smallest index'd object (using compareTo()) from the
	 * startIndex to the numberUsed (which is really the endIndex). The identified
	 * object's INDEX is then returned.
	 * 
	 * @param startIndex - int - starting index of objects to compare in array
	 * @param a          - Comparable[] - array of comparable objects
	 * @param numberUsed - int - ending index of objects to compare in array.
	 *                   Typically entire length of array.
	 * @return indexOfMin - index of minimum valued object in array
	 */
	private static int indexOfSmallest(int startIndex, Comparable<Object>[] a, int numberUsed)
	{
		Comparable<Object> min = a[startIndex];
		int indexOfMin = startIndex;
		int index;
		for (index = startIndex + 1; index < numberUsed; index++)
		{
			if (a[index].compareTo(min) < 0) // compareTo can be overridden in specific object type.
			{
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}

	/**
	 * simple swap function that changes the place of 2 objects in the given array
	 * of Comparable objects.
	 * 
	 * @param i - int - index of one of the objects to swap.
	 * @param j - int - index of other object being swapped.
	 * @param a - Comparable[] - array of comparable objects.
	 */
	private static void swap(int i, int j, Comparable<Object>[] a)
	{
		Comparable<Object> temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
