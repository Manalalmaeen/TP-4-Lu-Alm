import java.util.ArrayList;

public class Patron
{
	private String name;
	private String patronID;
	public String getPatronID() {
		return patronID;
	}

	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	public ArrayList<Copy> getCopiesOut() {
		return copiesOut;
	}

	public void setCopiesOut(ArrayList<Copy> copiesOut) {
		this.copiesOut = copiesOut;
	}

	private ArrayList<Copy> copiesOut;
	private boolean holdStatus;

	public Patron(String n, String id)
	{
		this.name = n;
		this.patronID = id;
		this.copiesOut = new ArrayList<Copy>();
	}

	public boolean checkCopyOut(Copy c)
	{
		c.setOutTo(this);
		copiesOut.add(c);
		return true;
	}

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
	
	public String getName(){
		return name;
	}
    public int getNoOfCopies(){
    	return copiesOut.size();
    }
    
    public boolean  getHoldStatus(){
    	return holdStatus;
    }
    
    public void  setHoldStatus(boolean holdStatus){
    	this.holdStatus  = holdStatus;
    }
    
	public static void main(String[] args)
	{
		Patron p1 = new Patron("James", "007");

		System.out.println(p1);
		
		
	}

}
