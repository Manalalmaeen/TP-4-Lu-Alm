
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Receipt {
	
	public static void getReceipt(Patron patron, double price, Copy c , Clerk clerk){
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		
		StdOut.println("====================================================");
		StdOut.println("            BOOK SOLD     ");
		StdOut.println("----------------------------------------------------");
		StdOut.println("Patron Name :" + patron.getName());
		StdOut.println("----------------------------------------------------");
		StdOut.printf("%3s |%10s|%7s|%6s\n"   ,"Qty","Unit Price","Book ID","Total");
		StdOut.printf("%3d |%10.2f|%7s|%6.2f\n" ,1,price,c.getCopyID(), price);
		StdOut.println("           ");
		StdOut.println("           ");
		StdOut.println("           ");
		StdOut.println("----------------------------------------------------");
		StdOut.println("Sold by " +clerk.getName()+"["+ clerk.getClerkID()+"] on "+ timeStamp +" ");
		StdOut.println("====================================================");
		
		
	}

}
