import static org.junit.Assert.*;

import java.util.Date;

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
	public void  testGetClerkName2(){
		
		Clerk clerk = new Clerk ("JackSon", "22");
		assertEquals("JackSon", clerk.getName());

	 }
	@Test
	public void testCheckinCopies(){
		Copy copy=new Copy("123");
		Patron patron=new Patron("M","123");
		assertFalse(patron.checkCopyIn(copy));
	}
	
	@Test
	public void testMain() throws Exception {
		StdOut.println("-----------------Information about the App--------------------------------");
		
		StdOut.println();
	}

	@Test
	public void testSubMenu() throws Exception {
		StdOut.println("1.Check out ...");
		StdOut.println("2.Check in ...");
		StdOut.println("3.Sell a copy to Patron ...");
		StdOut.println("4.Back to Main Menu");
		StdOut.println("5.Determine the Patron having holds....");
		StdOut.println("6.Exit");
	
	}

	@Test
	public void testMainMenu() throws Exception {
		
	}
	@Test
	public void testPrint() throws Exception {
		System.out.println();
	}
	@Test
	public void testClerk2() throws Exception {
		Clerk clerktest=new Clerk("M","2");
	}

	@Test
	public void testToString() throws Exception {
		Clerk clerktest=new Clerk("M","2");
		clerktest.toString();
	}

	@Test
	public void testGetName2() throws Exception {
		Clerk clerktest=new Clerk("M","2");
		assertEquals("M",clerktest.getName());
	}
	@Test
	public void testPaymentMenu() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
	}

	@Test
	public void testCheckOut() throws Exception {
	
	}

	@Test
	public void testCheckIn() throws Exception {
		
	}

	@Test
	public void testSoldCopyToPatron() throws Exception {
		
	}

	@Test
	public void testDeterminePatronHold() throws Exception {
		
	}
	@Test
	public void testGetPatronID() throws Exception {
		
	}

	@Test
	public void testSetPatronID() throws Exception {
		
	}

	@Test
	public void testGetCopiesOut() throws Exception {
		
	}

	@Test
	public void testSetCopiesOut() throws Exception {
		
	}

	@Test
	public void testCheckCopyOut() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		assertFalse(patrontest.checkCopyOut(copytest));
	}

	@Test
	public void testCheckCopyIn() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		assertFalse(patrontest.checkCopyIn(copytest));
	}

	@Test
	public void testToStringPatron() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		patrontest.toString();
		patrontest.getPatronID();
		
	}

	@Test
	public void testGetNoOfCopiesPatron() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		patrontest.getNoOfCopies();
	}

	@Test
	public void testGetHoldStatusPatron() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		assertFalse(patrontest.getHoldStatus());
	}

	@Test
	public void testSetHoldStatus() throws Exception {
		Copy copytest=new Copy("123");
		Patron patrontest=new Patron("M","12");
		patrontest.setHoldStatus(false);
		
	}

	@Test
	public void testMainPatron() throws Exception {
		
	}
	@Test
	public void testPayment() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
		
	}

	@Test
	public void testDeopsite() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
		assertFalse(paymenttest.deopsite());
	}

	@Test
	public void testCreditCard() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
		
	}

	@Test
	public void testDebitCard() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
	}

	@Test
	public void testUniversityAccountPayment() throws Exception {
		Payment paymenttest=new Payment(1,2.0);
	}
	@Test
	public void testClerkValidateTRL() throws Exception {
		
	}

	@Test
	public void testGetClerkName() throws Exception {
	
	}

	@Test
	public void testCopyValidate() throws Exception {
		Copy copytest=new Copy("123");
		copytest.setDueDate(null);
	}

	@Test
	public void testPatronValidate() throws Exception {
		
	}

	@Test
	public void testFindPatronHavingHolds() throws Exception {
		
	}

	@Test
	public void testGetPatron() throws Exception {
		Patron patrontest=new Patron("M","12");
		assertEquals("12",patrontest.getPatronID());
	}

	@Test
	public void testGetCopy() throws Exception {
		Copy copytest=new Copy("123");
		Date date=new Date();
		copytest.setDueDate(date);
		System.out.print(copytest.getDueDate());
	}


}
