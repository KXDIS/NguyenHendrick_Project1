
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> password;

	@Before
	public void setUp() throws Exception {
		String[] passwords = { "tooshrt", "noupper", "NOLOWER", "Nodigit!", "noSpecialChar1", "NoSameSeqqq1@" };
		password = new ArrayList<String>();
		password.addAll(Arrays.asList(passwords));
	}

	@After
	public void tearDown() throws Exception {
		password = null;
	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abC1@"));
			assertTrue("Did not throw LengthException", false);
		} catch (LengthException e) {
			assertTrue("Successfully threw a LengthExcepetion", true);
		}

		catch (Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("noupperal1"));

			assertTrue("Did not throw NoUpperAlphaException", false);
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 * 
	 * @throws NoLowerAlphaException
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws NoLowerAlphaException {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("NOLOWER1"));

			assertTrue("Did not throw NoLowerAlphaException", false);
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		} catch (Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
//		assertTrue(PasswordCheckerUtility.hasLowerAlpha("aaabbbccc"));
//
//		try {
//			assertFalse(PasswordCheckerUtility.hasLowerAlpha("AAABBBCCC"));
//		} catch (NoLowerAlphaException e) {
//			e.printStackTrace();
//		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {

			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("ABCabc@1");
			assertTrue("Did not throw WeakPassword Exception", false);
		} catch (WeakPasswordException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("1Nseqqq!!"));
			assertTrue("Did not throw an InvalidSequenceException", false);
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("NoDigitt!"));
			assertTrue("Did not throw an InvalidSequenceException", false);
		} catch (NoDigitException e) {
			assertTrue("Successfully threw an NoDigitException", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException", false);
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			PasswordCheckerUtility.isValidPassword("GoodPassword12#");
			assertTrue("No exception thrown", true);
			;

		} catch (Exception e) {
			assertTrue("Threw an exception", false);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(password);

		assertEquals(PasswordCheckerUtility.getInvalidPasswords(invalidPasswords).size(), 5);

	}

}
