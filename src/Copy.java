
/**
 * File    : Copy.java
 * Purpose : This class contains the attributes of the copy like price, copyID
 *
 *
 */
import java.util.Date;



public class Copy
{
	private String copyID;
	private double price;
	private Patron outTo;
	private Date dueDate;

	// following generated in Eclipse Source menu
/**
 * 
 * @return the due date of the copy
 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * 
	 * @param dueDate : set the due date of the copy
	 */

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * 
	 * @return the patron whom copy issued to
	 */
	public Patron getOutTo()
	{
		return outTo;
	}

	/**
	 * 
	 * @param outTo : set the patron whom copy issued to
	 */
	public void setOutTo(Patron outTo)
	{
		this.outTo = outTo;
	}

	/**
	 * 
	 * @return the copyId of the copy
	 */
	public String getCopyID()
	{
		return copyID;
	}

	/**
	 * Constructor
	 * @param cid
	 */
	public Copy(String cid)
	{
		this.copyID = cid;
	}

	/**
	 * The string representation of the copy object
	 */
	public String toString()
	{
		return "Copy w/id= " + this.copyID+"\t\tDue Date: "+Driver_TP3.sdf.format(dueDate);
	}

	/**
	 * 
	 * @return the price of the copy
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * 
	 * @param price: set the price of the copy
	 */
	public void setPrice(double price)
	{
		this.price=price;
	}
	
	/**
	 * Compares the 2 copies on the basis of copyID
	 */
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Copy))
			return false;

		return ((Copy) o).getCopyID().equals(this.copyID); // yuck.
	}

	public static void main(String[] args)
	{
		Copy c1 = new Copy("0047");
		Patron p1 = new Patron("James", "007");

		System.out.println(c1);
		System.out.println(p1);
		
	}
}
