package ru.stroganov.skypro.employee_map.string_checker;

import org.apache.commons.lang3.StringUtils;
import ru.stroganov.skypro.employee_map.exception.WrongStringFormatException;

public class StringChecker {
    public static String check(String s) {
        if (!StringUtils.isAlpha(s)) {
            throw new WrongStringFormatException("не верно заполнено строковое поле");
        }
        return StringUtils.capitalize(s);
    }
}
