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
	public void testCheckoutCopies(){
		Copy copy=new Copy("12");
		Patron patron=new Patron("M","12");
		assertFalse(patron.checkCopyIn(copy));
	}
	@Test
	public void testCheckinCopies(){
		Copy copy=new Copy("12");
		Patron patron=new Patron("M","12");
		assertFalse(patron.checkCopyIn(copy));
	}
	@Test
	public void testGetName(){
		
		Patron patron=new Patron("M","12");
		assertEquals("M",patron.getName());
	}
}
