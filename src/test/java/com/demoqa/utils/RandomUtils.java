package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static public Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomMonth() {
        return faker.options().option(  "January", "February", "March", "April", "May", "June", "July",
                                                "August", "September", "October", "November", "December");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }
}