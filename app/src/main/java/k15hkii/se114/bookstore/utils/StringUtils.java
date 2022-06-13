package k15hkii.se114.bookstore.utils;

import kotlin.text.Regex;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringUtils {

    public static final Pattern PHONE_PATTERN = Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$"
    );

    public static final Pattern MAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");

    public static boolean isMail(String mail) {
        return MAIL_PATTERN.matcher(mail).matches();
    }

    public static boolean isPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
