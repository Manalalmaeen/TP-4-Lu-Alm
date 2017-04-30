

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class Driver_TP3 {

	static{
		StdOut.println("-----------------Information about the App--------------------------------");
		StdOut.println("-----------------Rules--------------------------------");
		StdOut.println("Wherever you asked to enter the date. Please enter in the following format like dd-MM-yyyy.");
		StdOut.println("Fine in the app is computed as: Fine = Number of days * 1");
		StdOut.println("John name is used for all Patron. Patron can have any Id like 1,2");
		StdOut.println("Always try to run the application using existing patron id");
		StdOut.println("----------------------------------------------------------");
		StdOut.println("========================================================================");
		
		StdOut.println();
	}
	public static int NO_OF_COPIES_CAN_HAVE = 5;
	public static SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
	
	public static void mainMenu() {
		StdOut.println("1.Start a new transaction ...");
		StdOut.println("2.Exit");
	}

	public static void subMenu() {
		StdOut.println("1.Check out ...");
		StdOut.println("2.Check in ...");
		StdOut.println("3.Sell a copy to Patron ...");
		StdOut.println("4.Back to Main Menu");
		StdOut.println("5.Determine the Patron having holds....");
		StdOut.println("6.Exit");
	}

	public static void paymentMenu() {
		StdOut.println("1.Cash");
		StdOut.println("2.Check");
		StdOut.println("3.Credit Card");
		StdOut.println("4.Debit Card");
		StdOut.println("5.University Account");
	}

	public static void checkOut() {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.patronValidate(patronID);
		if (patron != null) {
			if (patron.getHoldStatus() == false) {
				if (patron.getNoOfCopies() <= NO_OF_COPIES_CAN_HAVE) {
					// ------------------------------
					StdOut.println("Patron info...");
					StdOut.println(patron);

					String copyID;
					while (ch == 'Y' || ch == 'y') {
						StdOut.print("Please enter the Copy ID : ");
						copyID = StdIn.readString();
						Copy copy = TRLController.CopyValidate(copyID);
						if (copy != null) {
							do{
							StdOut.print("Please enter the due date of Copy(dd-mm-yyyy) : ");
							String date = StdIn.readString();
							try {
								copy.setDueDate(sdf.parse(date));
								break;
							} catch (ParseException e) {
								StdOut.print("Incorrect format of date. Please try agaon!!!!");
								continue;
							}
							}while(true);
							patron.checkCopyOut(copy);
							StdOut.println("Copy check out to Patron with "
									+ patronID);
						} else {
							StdOut.println("Error: Copy with " + copyID
									+ "doesn't exit");
						}
						StdOut.print("Is more books there?[Y/N]:");
						ch = (StdIn.readString()).charAt(0);
					}
					StdOut.println(patron); // delete
					// -----------------------------
				} else {
					StdOut.println("Error: Patron excededs maximum no of books can have.");
				}
			} else {
				StdOut.println("Error: Patron on HOLD");
			}
		} else {
			StdOut.println("Error: Patron ID doesn't exit");
		}

	}
	

	public static void checkIn() {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.getPatron(patronID);
		Date curDate = null;
		if (patron != null) {

			// ------------------------------
			StdOut.println("Patron info...");
			StdOut.println(patron);

			String copyID;
			while (ch == 'Y' || ch == 'y') {
				StdOut.print("Please enter the Copy ID : ");
				copyID = StdIn.readString();
				Copy copy = TRLController.getCopy(patron,copyID);
				if (copy != null) {
					
					do{
						StdOut.print("Please enter the current date(dd-mm-yyyy) : ");
						String date = StdIn.readString();
						try {
							curDate =	sdf.parse(date);
						//TRLController.findPatronHavingHolds(curDate);
							break;
						} catch (ParseException e) {
							StdOut.print("Incorrect format of date. Please try agaon!!!!");
							continue;
						}
						}while(true);
					
					if(copy.getDueDate().compareTo(curDate)<0){
						long diff = curDate.getTime() - copy.getDueDate().getTime();
						System.out.println("This copy has a fine of :$"+ TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)*1);
						System.out.println("Please pay");
					}
					patron.checkCopyIn(new Copy(copyID));
					StdOut.println("Copy check in by Patron with ID "
							+ patronID);
				} else {
					StdOut.println("Error: Copy with " + copyID
							+ "doesn't exit");
				}
				StdOut.print("Is more books there?[Y/N]:");
				ch = (StdIn.readString()).charAt(0);
			}
			StdOut.println(patron); // delete
			boolean hold  = false;
			for(Copy c :patron.getCopiesOut()){
				if(c.getDueDate().compareTo(curDate)<0){
					hold =true;
					break;
				}
			}
			if(hold){
				StdOut.println(patron.getName() + " still you have some due copies.");
				
			}
			else{
				StdOut.println(patron.getName() + " ,you now have no due copies.");
			}
			patron.setHoldStatus(hold);
			// -----------------------------

		} else {
			StdOut.println("Error: Patron ID doesn't exit");
		}
		// =======================================================

	}

	public static void soldCopyToPatron(Clerk clerk) {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.patronValidate(patronID);
		if (patron != null) {
			// ------------------------------
			StdOut.println("Patron info...");
			StdOut.println(patron);

			String copyID;
			while (ch == 'Y' || ch == 'y') {
				StdOut.print("Please enter the Copy ID : ");
				copyID = StdIn.readString();
				Copy copy = TRLController.CopyValidate(copyID);
				if (copy != null) {
					StdOut.println("Payment...");
					paymentMenu();
					StdOut.print("Select the payment options...:");
					int paymentID = StdIn.readInt();
					double price = copy.getPrice();
					Payment payment = new Payment(paymentID, price);
					if (payment.deopsite()) {
						StdOut.println("Copy sold to Patron with patron ID "
								+ patronID);
						Receipt.getReceipt(patron, price, copy, clerk);
					} else {

					}
				} else {
					StdOut.println("Error: Copy with " + copyID
							+ "doesn't exit");
				}
				StdOut.print("Is more books there?[Y/N]:");
				ch = (StdIn.readString()).charAt(0);
			}
			StdOut.println(patron); // delete
			// -----------------------------
		} else {
			StdOut.println("Error: Patron ID doesn't exit");
		}
	}

	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String clerkID;
		int option;
		int contOption; // continue option 
		StdOut.println("Clerk Logging...");
		StdOut.print("Please enter the ID :");
		clerkID = StdIn.readString();

		Clerk clerk =TRLController.clerkValidate(clerkID);
		if (clerk != null) {
			// ------------------------------------

			StdOut.println("Logged: " + clerk.toString());
			Log.print("["+ timeStamp +"]: Logged:" + clerk.toString());
			while (true) {
				StdOut.println("\nMain Menu...");
				StdOut.println("----------------");
				mainMenu();
				StdOut.print("Select one option :");
				option = StdIn.readInt();
				if (option == 1) {
					contOption =1;
					while (contOption ==1) {
						StdOut.println("\nA new transaction started by "+ clerk.toString());
						Log.print("["+ timeStamp +"]: A new transaction started by "+ clerk.toString());
						// -------------------------------------------------
						StdOut.println("Sub Menu");
						StdOut.println("----------------");
						subMenu();
						StdOut.print("Select one option :");
						option = StdIn.readInt();
						switch (option) {
						case 1: {
							checkOut();
							break;
						}
						case 2: {
							checkIn();
							break;
						}
						case 3: {
							soldCopyToPatron(clerk);
							break;
						}
						case 4: {
							contOption=0;
							break;
						}
						case 5:
							determinePatronHold();
							break;
						case 6: {
							StdOut.print("System terminated...");
							System.exit(1);
							break;
						}
						default: {

						}
						}
					}
				} else {
					StdOut.print("System terminated...");
					System.exit(1);
				}
			}
			// -----------------------------------------
		} else {
			StdOut.println("Error: Clerk ID doesn't exit");
		}

	}

	private static void determinePatronHold() {
		do{
			StdOut.print("Please enter the current date(dd-mm-yyyy) : ");
			String date = StdIn.readString();
			try {
			Date curDate =	sdf.parse(date);
			TRLController.findPatronHavingHolds(curDate);
				break;
			} catch (ParseException e) {
				StdOut.println("Incorrect format of date. Please try agaon!!!!");
				continue;
			}
			}while(true);
		
	}
}
