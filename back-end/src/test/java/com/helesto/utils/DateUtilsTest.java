package com.helesto.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class DateUtilsTest {

    @Test
    void testaValidaData() {

        // Invalid date
        assertThrows(DateTimeParseException.class, () -> DateUtils.stringToLocalDate("02/29/2021"));

        // Correct date
        assertEquals(DateUtils.stringToLocalDate("02/28/2020"), LocalDate.of(2020, 02, 28));

        // Correct date
        assertTrue(DateUtils.localDateToStringMmDdYyyy(LocalDate.of(1983, 3, 25)).equals("03/25/1983"));

    }

}