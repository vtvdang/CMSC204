import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vivian Dang
 * Utility class for checking and validating passwords.
 */
public class PasswordCheckerUtility {

    /**
     * Compares two passwords and throws an exception if they do not match.
     *
     * @param password        The first password.
     * @param passwordConfirm The second password for confirmation.
     * @throws UnmatchedException Thrown if the passwords do not match.
     */
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException();
        } else {
            System.out.println("Passwords match");
        }
    }

    /**
     * Compares two passwords and returns true if they match.
     *
     * @param password        The first password.
     * @param passwordConfirm The second password for confirmation.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    /**
     * Returns a list of invalid passwords based on validation rules.
     *
     * @param passwords The list of passwords to be validated.
     * @return List of invalid passwords with error messages.
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                String message = password + ": " + e.getMessage();
                invalidPasswords.add(message);
            }
        }
        return invalidPasswords;
    }

    /**
     * Validates a password based on various criteria.
     *
     * @param password The password to be validated.
     * @return True if the password is valid, false otherwise.
     * @throws LengthException              Thrown if the password length is less than 6.
     * @throws NoUpperAlphaException        Thrown if the password lacks uppercase letters.
     * @throws NoLowerAlphaException        Thrown if the password lacks lowercase letters.
     * @throws NoDigitException             Thrown if the password lacks digits.
     * @throws NoSpecialCharacterException  Thrown if the password lacks special characters.
     * @throws InvalidSequenceException     Thrown if the password contains an invalid character sequence.
     */
    public static boolean isValidPassword(String password)
            throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
            NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        if (isValidLength(password) && hasLowerAlpha(password) && hasUpperAlpha(password) &&
                hasSpecialChar(password) && hasDigit(password) && !NoSameCharInSequence(password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a password is weak based on its length.
     *
     * @param password The password to be checked for weakness.
     * @return True if the password is weak, false otherwise.
     * @throws WeakPasswordException Thrown if the password is weak.
     */
    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (hasBetweenSixAndNineChars(password)) {
            throw new WeakPasswordException();
        }
        return false;
    }

    /**
     * Validates the length of a password.
     *
     * @param password The password to be checked for length.
     * @return True if the password meets the length criteria, false otherwise.
     * @throws LengthException Thrown if the password length is less than 6.
     */
    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() >= 6) {
            return true;
        } else {
            throw new LengthException();
        }
    }

    /**
     * Checks if a password contains at least one uppercase letter.
     *
     * @param password The password to be checked.
     * @return True if the password contains an uppercase letter, false otherwise.
     * @throws NoUpperAlphaException Thrown if the password lacks uppercase letters.
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        Pattern upperPattern = Pattern.compile("[A-Z]+");
        Matcher matcher = upperPattern.matcher(password);
        if (matcher.find()) {
            return true;
        } else {
            throw new NoUpperAlphaException();
        }
    }

    /**
     * Checks if a password contains at least one lowercase letter.
     *
     * @param password The password to be checked.
     * @return True if the password contains a lowercase letter, false otherwise.
     * @throws NoLowerAlphaException Thrown if the password lacks lowercase letters.
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        Pattern specialPattern = Pattern.compile("[a-z]+");
        Matcher matcher = specialPattern.matcher(password);
        if (matcher.find()) {
            return true;
        } else {
            throw new NoLowerAlphaException();
        }
    }

    /**
     * Checks if a password contains at least one digit.
     *
     * @param password The password to be checked.
     * @return True if the password contains a digit, false otherwise.
     * @throws NoDigitException Thrown if the password lacks digits.
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        Pattern digitPattern = Pattern.compile("\\d+");
        Matcher matcher = digitPattern.matcher(password);
        if (matcher.find()) {
            return true;
        } else {
            throw new NoDigitException();
        }
    }

    /**
     * Checks if a password contains at least one special character.
     *
     * @param password The password to be checked.
     * @return True if the password contains a special character, false otherwise.
     * @throws NoSpecialCharacterException Thrown if the password lacks special characters.
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = specialPattern.matcher(password);
        if (matcher.find()) {
            return true;
        } else {
            throw new NoSpecialCharacterException();
        }
    }

    /**
     * Checks for the presence of the same character in a sequence of three.
     *
     * @param password The password to be checked.
     * @return True if the password contains an invalid character sequence, false otherwise.
     * @throws InvalidSequenceException Thrown if the password contains an invalid character sequence.
     */
    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            char currentChar = password.charAt(i);
            char nextChar = password.charAt(i + 1);
            char nextNextChar = password.charAt(i + 2);
            if (currentChar == nextChar && nextChar == nextNextChar) {
                throw new InvalidSequenceException();
            }
        }
        return false;
    }

    /**
     * Checks if a password has a length between six and nine characters (inclusive).
     *
     * @param password The password to be checked.
     * @return True if the password has a length between six and nine characters, false otherwise.
     */
    public static boolean hasBetweenSixAndNineChars(String password) {
        return password.length() >= 6 && password.length() <= 9;
    }
}
