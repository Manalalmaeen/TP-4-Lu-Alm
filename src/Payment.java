/**
 * File : Payment.java 
 * Purpose : This class contains the functionality of the payment
 * 
 */
public class Payment {

	// attributes
	double price;
	int paymentType;

	/**
	 * Constructor
	 * 
	 * @param paymentType
	 *            : type of the payment
	 * @param price
	 *            : price
	 */
	public Payment(int paymentType, double price) {
		this.price = price;
		this.paymentType = paymentType;
	}

	/**
	 * 
	 * @return true if payment is successful otherwise false
	 */
	public boolean deopsite() {

		// determine the payment type
		switch (paymentType) {
		case 1: {
			StdOut.print("Please confirm the cash payment of $" + price
					+ " [Y/N] :");
			char ch = (StdIn.readString()).charAt(0);
			// check for the payment
			if (ch == 'Y' || ch == 'y') {
				StdOut.println("Payment Success!!!");
				return true;
			}
			StdOut.println("Payment Failed!!!");
			return false;

		}
		case 2: {
			StdOut.print("Please confirm the check received for payment of $"
					+ price + " [Y/N] :");
			char ch = (StdIn.readString()).charAt(0);
			if (ch == 'Y' || ch == 'y') {
				StdOut.println("Payment Success!!!");
				return true;
			}
			StdOut.println("Payment Failed!!!");
			return false;

		}
		case 3: {
			return creditCard(price);

		}
		case 4: {
			return debitCard(price);

		}
		case 5: {
			return universityAccount(price);

		}
		default: {

			break;
		}

		}
		return false;
	}

	/**
	 * 
	 * @param price : price
	 * @return
	 */
	private boolean creditCard(double price) {
		// implementation requried...
		StdOut.println("Payment Success by Credit Card");
		return true;
	}

	private boolean debitCard(double price) {
		// implementation requried...
		StdOut.println("Payment Success by Debit Card");
		return true;
	}

	private boolean universityAccount(double price) {
		// implementation requried...
		StdOut.println("Payment Success by University Account");
		return true;
	}
}
