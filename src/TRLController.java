import java.util.ArrayList;
import java.util.Date;


public class TRLController {
	
	public static ArrayList<Patron> patronList = new ArrayList<Patron>();

	public static Clerk clerkValidate(String clerkId){
		String clerkName = getClerkName(clerkId);
		if (clerkName != null){
			return new Clerk(clerkName,clerkId);
		}
		return null;
	}
	
	private static String getClerkName(String clerkId){
		// get ClerkName from datbase record by clerkId
		// String clerkName =  getClerkNameFromDB(clerkID)
		// return clerkName
		return "Micheal";
		
	}
	public static Copy CopyValidate(String copyId){
		Copy copy  = getCopyDetails(copyId);
		if (copy != null){
			return copy;
		}
		return null;
	}
	
	private static Copy getCopyDetails(String copyId){
		// get copy details from datbase record by copyId
		// Copy copy =  getcopyDetailsFromDB(copyID)
		// return copy
		return new Copy(copyId);
		
	}public static Patron patronValidate(String patronId){
		for(Patron p : patronList){
			if(p.getPatronID().equalsIgnoreCase(patronId)){
				return p;
			}
		}
		String patronName = getPatronName(patronId);
		if (patronName != null){
			Patron p =new Patron(patronName,patronId);
			patronList.add(p);
			return p;
		}
		return null;
	}
	
	private static String getPatronName(String patronId){
		// get patronName from datbase record by patronId
		// String patronName =  getpatronNameFromDB(patronID)
		// return patronName
		return "John";
		
	}

	public static void findPatronHavingHolds(Date curDate) {
		for(Patron p : patronList){
			String copy="";
			for(Copy c :p.getCopiesOut()){
				if(c.getDueDate().compareTo(curDate)<0){
					copy +="\t\tCopy Id: "+ c.getCopyID()+"\n";
				}
			}
			if(!"".equals(copy)){
				System.out.println(p.getName() + " has the following due copies: ");
				System.out.println(copy);
				p.setHoldStatus(true);
				
			}
			else{
				System.out.println(p.getName() + " has no due copies");
			}
			System.out.println();
		}
		
	}

	public static Patron getPatron(String patronID) {
		for(Patron p : patronList){
			if(p.getPatronID().equalsIgnoreCase(patronID)){
				return p;
			}
		}
		return null;
	}

	public static Copy getCopy(Patron patron, String copyID) {
		for(Copy c :patron.getCopiesOut()){
			if(c.getCopyID().equalsIgnoreCase(copyID)){
				return c;
			}
			
		}
		return null;
	}



}
