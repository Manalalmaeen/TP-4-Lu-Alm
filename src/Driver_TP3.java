/**
 * File    : Driver_TP3.java
 * Purpose : This class contains the functionality modules like checkOut, checkIn, payment etc.
 * 
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Driver_TP3 {

	/**
	 * Payment Menu Option
	 */
	public static void paymentMenu() {
		StdOut.println("1.Cash");
		StdOut.println("2.Check");
		StdOut.println("3.Credit Card");
		StdOut.println("4.Debit Card");
		StdOut.println("5.University Account");
	}

	public static int NO_OF_COPIES_CAN_HAVE = 5;
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * This function performs the checkout functionality
	 */
	public static void checkOut() {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.patronValidate(patronID);
		// check for the patron
		if (patron == null) {
			StdOut.println("Error: Patron ID doesn't exit");
			return;
		}
		// check for the status
		if (patron.getHoldStatus() == true) {
			StdOut.println("Error: Patron on HOLD");
			return;
		}
		// check for the number of copies
		if (patron.getNoOfCopies() > NO_OF_COPIES_CAN_HAVE) {
			StdOut.println("Error: Patron excededs maximum no of books can have.");
			return;
		}
		// ------------------------------
		StdOut.println("Patron info...");
		StdOut.println(patron);

		String copyID;
		while (ch == 'Y' || ch == 'y') {
			StdOut.print("Please enter the Copy ID : ");
			copyID = StdIn.readString();
			Copy copy = TRLController.CopyValidate(copyID);
			// check for the copy id
			if (copy == null) {
				StdOut.println("Error: Copy with " + copyID + "doesn't exit");
			} else {
				do {
					StdOut.print("Please enter the due date of Copy(dd-mm-yyyy) : ");
					String date = StdIn.readString();
					try {
						copy.setDueDate(sdf.parse(date));
						break;
					} catch (ParseException e) {
						StdOut.print("Incorrect format of date. Please try again!!!!");
						continue;
					}
				} while (true);
				patron.checkCopyOut(copy);
				StdOut.println("Copy check out to Patron with " + patronID);
			}

			StdOut.print("Is more books there?[Y/N]:");
			ch = (StdIn.readString()).charAt(0);
		}
		StdOut.println(patron); // delete
		// -----------------------------

	}

	/**
	 * This method performs the check in functionality
	 */
	public static void checkIn() {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.getPatron(patronID);
		Date curDate = null;
		// check for the patron
		if (patron == null) {
			StdOut.println("Error: Patron ID doesn't exit");
			return;
		}

		// ------------------------------
		StdOut.println("Patron info...");
		StdOut.println(patron);

		String copyID;
		while (ch == 'Y' || ch == 'y') {
			StdOut.print("Please enter the Copy ID : ");
			copyID = StdIn.readString();
			Copy copy = TRLController.getCopy(patron, copyID);
			// check for the copy
			if (copy != null) {

				do {
					StdOut.print("Please enter the current date(dd-mm-yyyy) : ");
					String date = StdIn.readString();
					try {
						curDate = sdf.parse(date);
						// TRLController.findPatronHavingHolds(curDate);
						break;
					} catch (ParseException e) {
						StdOut.print("Incorrect format of date. Please try agaon!!!!");
						continue;
					}
				} while (true);

				// check the current date andd due date
				if (copy.getDueDate().compareTo(curDate) < 0) {
					long diff = curDate.getTime() - copy.getDueDate().getTime();
					System.out.println("This copy has a fine of :$"
							+ TimeUnit.DAYS
									.convert(diff, TimeUnit.MILLISECONDS) * 1);
					System.out.println("Please pay");
				}
				patron.checkCopyIn(new Copy(copyID));
				StdOut.println("Copy check in by Patron with ID " + patronID);
			} else {
				StdOut.println("Error: Copy with " + copyID + "doesn't exit");
			}
			StdOut.print("Is more books there?[Y/N]:");
			ch = (StdIn.readString()).charAt(0);
		}
		StdOut.println(patron); // delete
		boolean hold = false;
		// check for the copies checkout
		for (Copy c : patron.getCopiesOut()) {
			if (c.getDueDate().compareTo(curDate) < 0) {
				hold = true;
				break;
			}
		}
		if (hold) {
			StdOut.println(patron.getName()
					+ " still you have some due copies.");

		} else {
			StdOut.println(patron.getName() + " ,you now have no due copies.");
		}
		patron.setHoldStatus(hold);
		// -----------------------------

	}

	/**
	 * This method sold the copy to patron
	 * @param clerk  : clerk object
	 */
	public static void soldCopyToPatron(Clerk clerk) {
		char ch = 'Y';
		String patronID;
		StdOut.print("Please enter the Patron ID : ");
		patronID = StdIn.readString();
		Patron patron = TRLController.patronValidate(patronID);
		if (patron == null) {
			StdOut.println("Error: Patron ID doesn't exit");
			return;
		}

		// ------------------------------
		StdOut.println("Patron info...");
		StdOut.println(patron);

		String copyID;
		while (ch == 'Y' || ch == 'y') {
			StdOut.print("Please enter the Copy ID : ");
			copyID = StdIn.readString();
			Copy copy = TRLController.CopyValidate(copyID);
			// check for the copy
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
				} 
			} else {
				StdOut.println("Error: Copy with " + copyID + "doesn't exit");
			}
			StdOut.print("Is more books there?[Y/N]:");
			ch = (StdIn.readString()).charAt(0);
		}
		StdOut.println(patron); // delete
		// -----------------------------

	}

	/**
	 * 
	 * This method determine the patron hold on the basis of date entered
	 */
	public static void determinePatronHold() {
		do {
			// ask for the date
			StdOut.print("Please enter the current date(dd-mm-yyyy) : ");
			String date = StdIn.readString();
			try {
				Date curDate = sdf.parse(date);
				TRLController.findPatronHavingHolds(curDate);
				break;
			} catch (ParseException e) {
				StdOut.println("Incorrect format of date. Please try agaon!!!!");
				continue;
			}
		} while (true);

	}
}
