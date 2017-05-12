/**
 * File    : TRLController.java
 * Purpose : This is the controller class
 *
 */
import java.util.ArrayList;
import java.util.Date;


public class TRLController {
	// stores the patron
	public static ArrayList<Patron> patronList = new ArrayList<Patron>();

	/**
	 * This method return the clerk on the basis of ID
	 * @param clerkId : clerk id
	 * @return  the clerk
	 */
	public static Clerk clerkValidate(String clerkId){
		String clerkName = getClerkName(clerkId);
		if (clerkName != null){
			return new Clerk(clerkName,clerkId);
		}
		return null;
	}
	/**
	 * This method return the clerk name on the basis of id
	 * @param clerkId : clerk id
	 * @return the clerk name
	 */
	private static String getClerkName(String clerkId){
		// get ClerkName from datbase record by clerkId
		// String clerkName =  getClerkNameFromDB(clerkID)
		// return clerkName
		return "Micheal";
		
	}
	/**
	 * This method return the copy object on the basis of id
	 * @param copyId
	 * @return the copy
	 */
	public static Copy CopyValidate(String copyId){
		Copy copy  = getCopyDetails(copyId);
		if (copy != null){
			return copy;
		}
		return null;
	}
	/**
	 * This method return the copy object on the basis of id
	 * @param copyId
	 * @return the copy
	 */
	private static Copy getCopyDetails(String copyId){
		// get copy details from datbase record by copyId
		// Copy copy =  getcopyDetailsFromDB(copyID)
		// return copy
		return new Copy(copyId);
		
	}
	/**
	 * This method return the patron object on the basis of id
	 * @param patronId
	 * @return the patron
	 */
	public static Patron patronValidate(String patronId){
		Patron p =getPatron(patronId);
		if(p!=null) return p;
		String patronName = getPatronName(patronId);
		if (patronName != null){
			p =new Patron(patronName,patronId);
			patronList.add(p);
			return p;
		}
		return null;
	}
	/**
	 * This method return the patron name on the basis of id
	 * @param patronId
	 * @return the patron name
	 */
	private static String getPatronName(String patronId){
		// get patronName from datbase record by patronId
		// String patronName =  getpatronNameFromDB(patronID)
		// return patronName
		return "John";
		
	}

	/**
	 * The method calculates the patron having holds on the basis of date
	 * @param curDate
	 */
	public static void findPatronHavingHolds(Date curDate) {
		// check the size of the patron
		if(patronList.size() ==0){
			StdOut.println("There is no Patron added in the list. Please do the checkout first");
			return;
		}
		// parse the patron
		for(Patron p : patronList){
			String copy="";
			for(Copy c :p.getCopiesOut()){
				// compare the due date with the current date
				if(c.getDueDate().compareTo(curDate)<0){
					copy +="\t\tCopy Id: "+ c.getCopyID()+"\n";
				}
			}
			// set the patron hold status
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

	/**
	 * This method return the patron object on the basis of id
	 * @param patronID
	 * @return the patron
	 */
	public static Patron getPatron(String patronID) {
		for(Patron p : patronList){
			if(p.getPatronID().equalsIgnoreCase(patronID)){
				return p;
			}
		}
		return null;
	}

	/**
	 * The method return the Copy object on the basis of patron and copyID
	 * @param patron
	 * @param copyID
	 * @return the copy
	 */
	public static Copy getCopy(Patron patron, String copyID) {
		for(Copy c :patron.getCopiesOut()){
			if(c.getCopyID().equalsIgnoreCase(copyID)){
				return c;
			}
			
		}
		return null;
	}



}
