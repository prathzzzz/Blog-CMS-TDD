package com.blogcms.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestHelper {
    private static final Logger logger = LogManager.getLogger(TestHelper.class);

    // String Generators
    public static String generateRandomString(int length) {
        String result = RandomStringUtils.randomAlphanumeric(length);
        logger.debug("Generated random string: {}", result);
        return result;
    }

    public static String generateRandomAlphabetic(int length) {
        String result = RandomStringUtils.randomAlphabetic(length);
        logger.debug("Generated random alphabetic string: {}", result);
        return result;
    }

    public static String generateRandomNumeric(int length) {
        String result = RandomStringUtils.randomNumeric(length);
        logger.debug("Generated random numeric string: {}", result);
        return result;
    }

    public static String generateRandomEmail() {
        String prefix = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        String domain = RandomStringUtils.randomAlphabetic(8).toLowerCase();
        String email = String.format("%s@%s.com", prefix, domain);
        logger.debug("Generated random email: {}", email);
        return email;
    }

    // Number Generators
    public static int generateRandomNumber(int min, int max) {
        int number = RandomUtils.nextInt(min, max + 1);
        logger.debug("Generated random number between {} and {}: {}", min, max, number);
        return number;
    }

    public static String generateRandomPhoneNumber() {
        String phoneNumber = "1" + RandomStringUtils.randomNumeric(10);
        logger.debug("Generated random phone number: {}", phoneNumber);
        return phoneNumber;
    }

    // Date Generator
    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = RandomUtils.nextLong(startEpochDay, endEpochDay + 1);
        
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        logger.debug("Generated random date between {} and {}: {}", startDate, endDate, randomDate);
        return randomDate;
    }

    // Password Generator
    public static String generateRandomPassword(int length) {
        // Ensure minimum length of 8
        length = Math.max(length, 8);
        
        String specialChars = "!@#$%^&*";
        String password = RandomStringUtils.randomAlphanumeric(length - 2) +
                         RandomStringUtils.random(2, specialChars);
        
        logger.debug("Generated random password of length {}", length);
        return password;
    }


} 