import java.util.Date;


public class Copy
{
	private String copyID;
	private double price;
	private Patron outTo;
	private Date dueDate;


	// following generated in Eclipse Source menu
	
	public Date getDueDate() 
	{
		return dueDate;
	}

	public void setDueDate(Date dueDate) 
	{
		this.dueDate = dueDate;
	}

	public Patron getOutTo()
	{
		return outTo;
	}

	public void setOutTo(Patron outTo)
	{
		this.outTo = outTo;
	}

	public String getCopyID()
	{
		return copyID;
	}

	public Copy(String cid)
	{
		this.copyID = cid;
	}

	public String toString()
	{
		return "Copy w/id= " + this.copyID+ this.copyID+"\t\tDue Date: "+dueDate;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price=price;
	}
	
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
