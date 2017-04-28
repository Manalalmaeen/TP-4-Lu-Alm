

public class Payment {
	
	double price;
	int paymentType;
	
	
	public Payment(int paymentType , double price){
		this.price=price;
		this.paymentType =paymentType;
	}
	
	public boolean  deopsite(){
		
		switch(paymentType){
		case 1:{
			StdOut.print("Please confirm the cash payment of $"+price +" [Y/N] :");
			char ch = (StdIn.readString()).charAt(0);
			if (ch=='Y' || ch=='y'){
				StdOut.println("Payment Success!!!");
				return true;
			}else{
				StdOut.println("Payment Failed!!!");
				return false;
			}			
		}
		case 2:{
			StdOut.print("Please confirm the check received for payment of $"+price +" [Y/N] :");
			char ch = (StdIn.readString()).charAt(0);
			if (ch=='Y' || ch=='y'){
				StdOut.println("Payment Success!!!");
				return true;
			}else{
				StdOut.println("Payment Failed!!!");
				return false;
			}
		}
		case 3:{
			return creditCard(price);
			
		}
		case 4:{
			return debitCard(price);
			
		}
		case 5:{
			return universityAccount(price);
			
		}
		default :{
			
			break;
		}
		
		}
		return false;
	}
	
	private boolean  creditCard( double price){
		// implementation requried...
		StdOut.println("Payment Success by Credit Card");
		return  true;
	}
	private boolean  debitCard( double price){
		// implementation requried...
		StdOut.println("Payment Success by Debit Card");
		return  true;
	}
	private boolean  universityAccount( double price){
		// implementation requried...
		StdOut.println("Payment Success by University Account");
		return  true;
	}
}















