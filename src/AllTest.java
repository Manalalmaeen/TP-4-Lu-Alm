import static org.junit.Assert.*;

import org.junit.Test;

public class AllTest{

	@Test
	public void testClerk() {
		Clerk clerk=new Clerk("M","12");
		assertEquals("M",clerk.getName());
		assertEquals("12",clerk.getClerkID());
	}
	@Test
	public void testCopy(){
		Copy copy=new Copy("12");
		assertEquals(copy.getCopyID(),"12");
		
	}
	@Test
	public void testPatron(){
		Patron patron=new Patron("M","12");
		assertEquals("M",patron.getName());
		
	}
	
	
	
	
	@Test
	public void testReceipt(){
		Clerk clerk=new Clerk("M","12");
		Copy copy=new Copy("12");
		Patron patron=new Patron("M","12");
		Receipt receipt=new Receipt();
		receipt.getReceipt(patron, 10.00, copy, clerk);
		
	}
	//Test
	public void testPaymentOption(){
		Payment payment=new Payment(1,2);
		assertEquals(payment.price,2);
	}
	@Test
	public void testCheckoutCopies1(){
		Copy copy=new Copy("12");
		Patron patron=new Patron("M","12");
		assertFalse(patron.checkCopyIn(copy));
	}
	@Test
	public void testCheckinCopies1(){
		Copy copy=new Copy("12");
		Patron patron=new Patron("M","12");
		assertFalse(patron.checkCopyIn(copy));
	}
	@Test
	public void testGetName(){
		
		Patron patron=new Patron("M","12");
		assertEquals("M",patron.getName());
	}
	@Test
	public void testCopyObjedt(){
		Copy copy=new Copy("178");
		assertEquals(copy.getCopyID(),"178");
		
	}
	@Test
	public void testClerkObject() {
		Clerk clerk=new Clerk("XYZ","1245");
		assertEquals("XYZ",clerk.getName());
		assertEquals("1245",clerk.getClerkID());
	}
	@Test
	public void testReceiptObject(){
		Clerk clerk=new Clerk("T","1289");
		Copy copy=new Copy("1289");
		Patron patron=new Patron("M","1289");
		Receipt receipt=new Receipt();
		receipt.getReceipt(patron, 12.00, copy, clerk);
		
	}
	@Test
	public void testPatronObject(){
		Patron patron=new Patron("R","1290");
		assertEquals("R",patron.getName());
		
	}
	@Test
	public void testGetNameProperty(){
		
		Patron patron=new Patron("Name","124");
		assertEquals("Name",patron.getName());
	}
	
	@Test
	public void testCheckoutCopies(){
		Copy copy=new Copy("124");
		Patron patron=new Patron("M","124");
		assertFalse(patron.checkCopyIn(copy));
	}
	@Test
	public void  testGetClerkName(){
		
		Clerk clerk = new Clerk ("JackSon", "22");
		assertEquals("JackSon", clerk.getName());

	 }
	@Test
	public void testCheckinCopies(){
		Copy copy=new Copy("123");
		Patron patron=new Patron("M","123");
		assertFalse(patron.checkCopyIn(copy));
	}
	
	

}
