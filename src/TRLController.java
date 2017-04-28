public class TRLController {
	
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
		
	}
	
	public static Patron patronValidate(String patronId){
		String patronName = getPatronName(patronId);
		if (patronName != null){
			return new Patron(patronName,patronId);
		}
		return null;
	}
	
	private static String getPatronName(String patronId){
		// get patronName from datbase record by patronId
		// String patronName =  getpatronNameFromDB(patronID)
		// return patronName
		return "John";
		
	}



}
