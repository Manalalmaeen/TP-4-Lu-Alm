

public class Clerk {
	
	private String name;
	private String clerkID;
	
	
	public Clerk(String n, String id)
	{
		this.name = n;
		this.clerkID = id;
		
	}
	
	public String toString()
	{
		String toReturn = "Clerk w/ name: " + this.name + ", id: " + this.clerkID;
		return toReturn;
	}
	
	public String getName(){
		return name;
	}

	public String getClerkID(){
		return clerkID;
	}


}
