/**
 * File    : Clerk.java
 * Purpose : This class contains the attributes of the clerk
 * 
 *
 */

public class Clerk {
	
	private String name;
	private String clerkID;
	
	/**
	 * Constructor
	 * @param n : name of the clerk
	 * @param id : id of the clerk
	 */
	public Clerk(String n, String id)
	{
		this.name = n;
		this.clerkID = id;
		
	}
	
	/**
	 * The string representation of the clerk object
	 */
	public String toString()
	{
		String toReturn = "Clerk w/ name: " + this.name + ", id: " + this.clerkID;
		return toReturn;
	}
	/**
	 * 
	 * @return the name of the clerk
	 */
	public String getName(){
		return name;
	}

	/**
	 * 
	 * @return the id of the clerk
	 */
	public String getClerkID(){
		return clerkID;
	}


}
