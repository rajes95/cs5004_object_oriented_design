package cs5004_hw9_problem1;

/**
 * The waypoint class marks the coordinates of a location on a map along witha
 * timestamp. The waypoints are best used in an ArrayList with timestamps in
 * consecutive order.
 * 
 * map scaling factor of 1 = 0.1 miles & timestamps (t) are in seconds
 * 
 * @author Rajesh Sakhamuru
 * @version 7/29/2019
 */
public class Waypoint
{
	private double x;
	private double y;
	private int t;

	/**
	 * default constructor which can set the waypoint to (0,0) at timestamp 0.
	 */
	public Waypoint()
	{
		this.setX(0);
		this.setY(0);
		this.setT(0);
	}

	/**
	 * constructor to create a new waypoint with a custom location and timestamp
	 * 
	 * @param x - double - x-coordinate of waypoint
	 * @param y - double - y-coordinate of waypoint
	 * @param t - int - timestamp of waypoint
	 */
	public Waypoint(double x, double y, int t)
	{
		this.setX(x);
		this.setY(y);
		this.setT(t);
	}

	/**
	 * returns the current x-coordinate of the waypoint
	 * 
	 * @return double - current x-coordinate
	 */
	public double getX()
	{
		return x;
	}

	/**
	 * sets the x-coordinate to a new value that is given as parameter
	 * 
	 * @param x - double - new x-coordinate of waypoint.
	 */
	public void setX(double x)
	{
		this.x = x;
	}

	/**
	 * returns the current y-coordinate of the waypoint
	 * 
	 * @return double - current y-coordinate
	 */
	public double getY()
	{
		return y;
	}

	/**
	 * sets the y-coordinate to a new value that is given as parameter
	 * 
	 * @param y - double - new y-coordinate of waypoint.
	 */
	public void setY(double y)
	{
		this.y = y;
	}

	/**
	 * returns the current timestamp of the waypoint
	 * 
	 * @return int - current timestamp
	 */
	public int getT()
	{
		return t;
	}

	/**
	 * sets the timestamp to a new value that is given as parameter
	 * 
	 * @param t - int - new timestamp of waypoint (in seconds)
	 */
	public void setT(int t)
	{
		if (t < 0)
		{
			System.err.println("INVAID 't' value. Must be positive.");
			System.exit(-1);
		}
		this.t = t;
	}

	/**
	 * returns a string that describes the waypoint.
	 * 
	 * @return str - String - string description of the waypoint
	 */
	public String toString()
	{
		String str = "";
		str += "(x,y): (" + this.getX() + "," + this.getY() + "), Timestamp: " + this.getT();
		return str;
	}

	/**
	 * tests to see if this waypoint is equal to the parameter waypoint object
	 * 
	 * @return boolean - true if equal, false if not equal
	 */
	public boolean equals(Object o)
	{
		if (o == this)
		{
			return true;
		}
		if (!(o.getClass() == Waypoint.class))
		{
			return false;
		}
		Waypoint way = (Waypoint) o;

		return this.getX() == way.getX() && this.getY() == way.getY() && this.getT() == way.getT();

	}

}