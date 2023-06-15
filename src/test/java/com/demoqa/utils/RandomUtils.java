package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static public Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public static String getRandomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public static String getRandomHobbies() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return faker.options().option(hobby);
    }
}