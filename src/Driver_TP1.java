

public class Driver_TP1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a Patron 
		StdOut.println("Patron: John created...");
		Patron p = new Patron("John", "JE123");
		
		// Create a some Copies
		StdOut.println("four Copies are created...");
		Copy c1 = new Copy("1234");
		Copy c2 = new Copy("1235");
		Copy c3 = new Copy("1236");
		Copy c4 = new Copy("1237");
		
		
		// Let's add the copies to Patron 
		// Lets checkout all the copies to Patron
		StdOut.println("Let's add these copies to Patron...John");
		p.checkCopyOut(c1);
		p.checkCopyOut(c2);
		p.checkCopyOut(c3);
		p.checkCopyOut(c4);
		
		// display all the copies with Patron	
		StdOut.println("Display the copies that currently have checked out");
		StdOut.println(p.toString());
		
		// Lets checkIn a copy from Patron
		StdOut.println("The copy c1 (id: "+c1.getCopyID()+") has been checked in...");
		p.checkCopyIn(c1);
		
		// display all the copies with Patron	
		StdOut.println("Display the copies that currently have checked out");
		StdOut.println(p.toString());		

	}




}
