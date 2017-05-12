import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * File : Main.java 
 * Purpose : This is the driver class from which controls passes to the other classes
 * 
 * 
 */
public class Main {
	static {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		String clerkID;
		int option;
		int contOption; // continue option
		StdOut.println("Clerk Logging...");
		StdOut.print("Please enter the ID :");
		clerkID = StdIn.readString();

		Clerk clerk = TRLController.clerkValidate(clerkID);
		// check for client ID
		if (clerk == null) {
			StdOut.println("Error: Clerk ID doesn't exit");
			return;
		}
		// ------------------------------------

		StdOut.println("Logged: " + clerk.toString());
		Log.print("[" + timeStamp + "]: Logged:" + clerk.toString());
		// Present the menu option
		while (true) {
			StdOut.println("\nMain Menu...");
			StdOut.println("----------------");
			mainMenu();
			StdOut.print("Select one option :");
			option = StdIn.readInt();
			// check for the option
			if (option != 1) {
				StdOut.print("System terminated...");
				System.exit(1);
			}
			contOption = 1;
			while (contOption == 1) {
				StdOut.println("\nA new transaction started by "
						+ clerk.toString());
				Log.print("[" + timeStamp + "]: A new transaction started by "
						+ clerk.toString());
				// -------------------------------------------------
				StdOut.println("Sub Menu");
				StdOut.println("----------------");
				subMenu();
				StdOut.print("Select one option :");
				option = StdIn.readInt();
				// check for the option
				switch (option) {
				case 1: {
					Driver_TP3.checkOut();
					break;
				}
				case 2: {
					Driver_TP3.checkIn();
					break;
				}
				case 3: {
					Driver_TP3.soldCopyToPatron(clerk);
					break;
				}
				case 4: {
					contOption = 0;
					break;
				}
				case 5:
					Driver_TP3.determinePatronHold();
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

		}

	}
	
	/**
	 * Main menu option
	 */
	public static void mainMenu() {
		StdOut.println("1.Start a new transaction ...");
		StdOut.println("2.Exit");
	}

	/**
	 * Sub menu option
	 */
	public static void subMenu() {
		StdOut.println("1.Check out ...");
		StdOut.println("2.Check in ...");
		StdOut.println("3.Sell a copy to Patron ...");
		StdOut.println("4.Back to Main Menu");
		StdOut.println("5.Determine the Patron having holds....");
		StdOut.println("6.Exit");
	}

	

}
