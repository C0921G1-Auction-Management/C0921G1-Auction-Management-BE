package vn.codegym.com.c0921g1_sprint2.DTO.member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMember {

    private static Pattern pattern;
    private static Matcher matcher;

    public static final String REGEX_MEMBER_NAME = "^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$";
    public static final String REGEX_PHONE_NUMBER = "^(\\(84\\)\\+|0)(90|91)(\\d){7}$";
    public static final String REGEX_TIME = "^(\\d){4}-(\\d){2}-(\\d){2}$";
    public static final String REGEX_IDENTITY_NUMBER = "^((\\d){9}|(\\d){12})$";

    //check age member >= 18 - KhanhLDQ
    public static boolean checkAgeMember(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();

        pattern = Pattern.compile(REGEX_TIME);
        matcher = pattern.matcher(dateOfBirth);

        boolean isRetry = false;

        if (!matcher.matches())
            isRetry = true;
        else {
            LocalDate birthDay = LocalDate.parse(dateOfBirth,formatter);
            LocalDate after18Years = birthDay.plusYears(18);
            LocalDate after100Years = birthDay.plusYears(100);

            if (after18Years.isAfter(now) || after100Years.isBefore(now))
                isRetry = true;
        }

        return isRetry;
    }

    //check name format
    public static boolean checkNameFormat(String name) {
        pattern = Pattern.compile(REGEX_MEMBER_NAME);
        matcher = pattern.matcher(name);

        boolean isRetry = false;

        if (!matcher.matches())
            isRetry = true;

        return isRetry;
    }

}
