/**
 * File    : Patron.java
 * Purpose : This class stores the attributes of the patron
 */

import java.util.ArrayList;

public class Patron
{
	private String name;
	private String patronID;
	/**
	 * 
	 * @return the patron id
	 */
	public String getPatronID() {
		return patronID;
	}

	/**
	 * This method set the patron id
	 * @param patronID
	 */
	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	/**
	 * 
	 * @return the copies out list
	 */
	public ArrayList<Copy> getCopiesOut() {
		return copiesOut;
	}

	/**
	 * This method set the copies out list
	 * @param copiesOut
	 */
	public void setCopiesOut(ArrayList<Copy> copiesOut) {
		this.copiesOut = copiesOut;
	}

	private ArrayList<Copy> copiesOut;
	private boolean holdStatus;

	/**
	 * Constructor
	 * @param n : name of the patron
	 * @param id : id of the patron
	 */
	public Patron(String n, String id)
	{
		this.name = n;
		this.patronID = id;
		this.copiesOut = new ArrayList<Copy>();
	}

	/**
	 * This method return the true if the copy is not checked out otherwise false
	 * @param c
	 * @return
	 */
	public boolean checkCopyOut(Copy c)
	{
		c.setOutTo(this);
		copiesOut.add(c);
		return true;
	}

	/**
	 * This method return true if the copy is succesfully check in otherwise false
	 * @param c : copy
	 * @return 
	 */
	public boolean checkCopyIn(Copy c)
	{
		c.setOutTo(null);
		if (copiesOut.contains(c))
		{
			copiesOut.remove(c);
			return true;
		}
		else
			return false;
	}

	/**
	 * This method return the  string reprsentation of patron object
	 */
	public String toString()
	{
		String toReturn = "Patron w/ name: " + this.name + ", id: " + this.patronID;

		if (this.copiesOut.isEmpty())
		{
			toReturn = toReturn + "\nNo copies checked out.\n";
		}
		else
			for (Copy copy : this.copiesOut)
			{
				toReturn = toReturn + "\nCopies checked out:";
				toReturn = toReturn + "\n\t" + copy.toString() + "\n";
			}

		return toReturn;
	}
	
	/**
	 * 
	 * @return the name of the patron
	 * 
	 */
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return the number of copies checked out
	 */
    public int getNoOfCopies(){
    	return copiesOut.size();
    }
    
    /**
     * 
     * @return the hold status
     */
    public boolean  getHoldStatus(){
    	return holdStatus;
    }
    
    /**
     * This method set the hold status
     * @param holdStatus
     */
    public void  setHoldStatus(boolean holdStatus){
    	this.holdStatus  = holdStatus;
    }
    
	public static void main(String[] args)
	{
		Patron p1 = new Patron("James", "007");

		System.out.println(p1);
		
		
	}

}
