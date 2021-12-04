package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));

    //private DataGenerator() {}


    public static String generateCity() {
        return faker.address().city();
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName() {
        return faker.name().fullName();
    }

    public static String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }
}
