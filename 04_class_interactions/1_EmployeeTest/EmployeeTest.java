/**
 * @author Rajesh Sakhamuru
 * @version 6/4/2019
 *
 * The purpose of the EmployeeTest class is to test the Employee class. 
 * The employee class stores a First and last name, as well as a monthly salary
 * for that person. Those values can be modified via getters and setters.
 * 
 * The EmployeeTest class uses the employee class to take make 2 employees
 * and then give them both a 10% raise.
 *
 *
 */


public class EmployeeTest
{

	/**
	 * Create 2 employees, in this case Barack Obama and Joe Biden, each with monthly salaries.
	 * Use getMonSalary() * 12 to get yearly salary.
	 * I then give both of them a 10% raise using setMonSalary.
	 * 
	 * */
	public static void main(String[] args)
	{
		Employee employee1 = new Employee("Barack", "Obama", 33333.34);
		Employee employee2 = new Employee("Joe", "Biden", 20833.34);
		System.out.printf("%s %s's Yearly Salary: $%.2f\n", employee1.getFirstName(), employee1.getLastName(),
				employee1.getMonSalary() * 12);
		System.out.printf("%s %s's Yearly Salary: $%.2f\n", employee2.getFirstName(), employee2.getLastName(),
				employee2.getMonSalary() * 12);

		employee1.setMonSalary(employee1.getMonSalary() * 1.1); // 10% raise
		employee2.setMonSalary(employee2.getMonSalary() * 1.1);

		System.out.println("\nAfter a 10% raise:");
		System.out.printf("%s %s's Yearly Salary: $%.2f\n", employee1.getFirstName(), employee1.getLastName(),
				employee1.getMonSalary() * 12);
		System.out.printf("%s %s's Yearly Salary: $%.2f\n", employee2.getFirstName(), employee2.getLastName(),
				employee2.getMonSalary() * 12);

	}

}

/**
 * 
 * This class allows the creation of an Employee object that can hold a firstName, lastName, and
 * a monthly salary. These values can be modified with getters and setters.
 * 
 */
class Employee
{
	private String firstName;
	private String lastName;
	private double monSalary;
	/**
	 * Getter for firstName
	 * @return String firstName : current first name
	 * */
	public String getFirstName()
	{
		return firstName;
	}

	/** Setter for firstName
	 * @param String firstName : new first name
	 * */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/** Getter for lastName
	 * @return String lastName : current last name
	 * */
	public String getLastName()
	{
		return lastName;
	}

	/** Setter for lastName
	 *  @param String lastName : new last name
	 * */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/** Getter of employee's monthly Salary
	 * @return double monSalary : current monthly Salary 
	 * */
	public double getMonSalary()
	{
		return monSalary;
	}

	/** Setter for employee's monthly salary
	 * @param double monSalary : new monthly salary
	 * */
	public void setMonSalary(double monSalary)
	{
		this.monSalary = monSalary;
	}

	/**
	 * new Employee constructor.
	 * 
	 * @param String firstName : first name of new employee 
	 * @param String lastName  : last name of new employee
	 * @param double monSalary : monthly salary of new employee
	 * */
	Employee(String firstName, String lastName, double monSalary)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		if (monSalary > 0)
		{
			this.monSalary = monSalary;
		}
	}

}


