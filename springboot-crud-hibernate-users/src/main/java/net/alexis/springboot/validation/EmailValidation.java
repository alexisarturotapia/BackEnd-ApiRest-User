package net.alexis.springboot.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

	private static final String EMAIL_PATTERN = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
