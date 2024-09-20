import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hendrick Nguyen
 *
 */
public class PasswordCheckerUtility extends Exception {

	/**
	 * Compare equality of two passwords
	 * 
	 * @param password        password string to be checked for
	 * @param passwordConfirm passwordConfirm string to be checked against password
	 *                        for
	 * @throws UnmatchedException thrown if not same
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}

	/**
	 * Compare equality of two passwords
	 * 
	 * @param password        password string to be checked for
	 * @param passwordConfirm 2nd password input to be confirmed
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordWithReturn(String password, String passwordConfirm) {
		return (password.equals(passwordConfirm));
	}

	/**
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords
	 * 
	 * @param password password string to be checked for
	 * @return true if both same (case sensitive), false otherwise
	 * @throws LengthException thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6) {
			throw new LengthException();
		} else {
			return true;
		}
	}

	/**
	 * Checks the password alpha character requirement - Password must contain an
	 * uppercase alpha character
	 * 
	 * @param password password string to be checked for
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException thrown if does not meet alpha character
	 *                               requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(password);

		if (matcher.find()) {
			return true;
		} else {
			throw new NoUpperAlphaException();
		}
	}

	/**
	 * Checks the password lowercase requirement - Password must contain at least
	 * one lowercase alpha character
	 * 
	 * @param password password string to be checked for
	 * @return true if meets lowercase requirement
	 * @throws NoLowerAlphaException thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(password);

		if (matcher.find()) {
			return true;
		} else {
			throw new NoLowerAlphaException();
		}

	}

	/**
	 * Checks the password Digit requirement - Password must contain a numeric
	 * character
	 * 
	 * @param password password string to be checked for
	 * @return true if meet Digit requirement
	 * @throws NoDigitException thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(password);

		int count = 0;

		while (matcher.find()) {
			count++;
		}
		if (count >= 1) {
			return true;
		} else {
			throw new NoDigitException();
		}

	}

	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a
	 * Special Character
	 * 
	 * @param password password string to be checked for
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter
	 *                                     requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String special = "[a-zA-Z0-9]*";

		Pattern pattern = Pattern.compile(special);
		Matcher matcher = pattern.matcher(password);

		if (!matcher.matches()) {

			return true;
		}
		throw new NoSpecialCharacterException();
	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more
	 * than 2 of the same character in sequence
	 * 
	 * @param password password string to be checked for
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {

		boolean isValid = true;
		for (int i = 0; i < password.length() - 2; i++) {

			char firstChar = password.charAt(i + 1);
			char secondChar = password.charAt(i + 2);

			if (password.charAt(i) == firstChar && password.charAt(i) == secondChar) {
				isValid = false;
				throw new InvalidSequenceException();
			}

		}

		return isValid;
	}

	/**
	 * Return true if valid password
	 * 
	 * @param password password string to be checked for
	 * @return true if valid password (follows all rules from above), false if an
	 *         invalid password
	 * @throws LengthException             thrown if length is less than 6
	 *                                     characters
	 * @throws NoUpperAlphaException       thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException       thrown if no lowercase alphabetic
	 * @throws NoDigitException            thrown if no digit
	 * @throws NoSpecialCharacterException thrown if does not meet SpecialCharacter
	 *                                     requirement
	 * @throws InvalidSequenceException    thrown if more than 2 of same character.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		try {
			if (isValidLength(password) && hasDigit(password) && hasUpperAlpha(password) && hasLowerAlpha(password)
					&& hasSpecialChar(password) && NoSameCharInSequence(password)) {
				return true;
			}

		} catch (Exception e) {

			throw e;
		}

		return false;
	}

	/**
	 * checks if the password contains 6 to 9 characters
	 * 
	 * @param password password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		return (password.length() > 6 && password.length() < 9);
	}

	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * 
	 * @param password password string to be checked for
	 * @return false if the password is valid and the length of password is NOT
	 *         between 6 and 9 (inclusive).
	 * @throws WeakPasswordException if length of password is between 6 and 9
	 *                               (inclusive), ALTHOUGH the password may be
	 *                               VALID.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {

		if (!hasBetweenSixAndNineChars(password)) {
			return false;
		} else {
			throw new WeakPasswordException();
		}

	}

	/**
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords
	 * 
	 * @param passwords array of password strings to be checked for
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> invalidPasswords = new ArrayList<>();

		for (int i = 0; i < passwords.size(); i++) {

			try {
				if (!isValidPassword(passwords.get(i))) {
					invalidPasswords.add(passwords.get(i) + " " + isValidPassword(passwords.get(i)));
				}

			} catch (Exception e) {

				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());

			}

		}
		return invalidPasswords;
	}
}
