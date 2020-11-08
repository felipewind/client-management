package com.helesto.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateUtils {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/uuuu");

    private static DateTimeFormatter dateTimeFormatterSTRICT = DateTimeFormatter.ofPattern("MM/dd/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static String localDateToStringMmDdYyyy(LocalDate localDate) {

        return localDate.format(dateTimeFormatter);

    }

    public static LocalDate stringToLocalDate(String data) throws DateTimeParseException {

        return LocalDate.parse(data, dateTimeFormatterSTRICT);

    }

}
