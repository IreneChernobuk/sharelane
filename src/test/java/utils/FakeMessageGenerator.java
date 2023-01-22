package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {
    public static String generateFourZipCode() {
        Faker faker = new Faker();
        return faker.numerify("####");
    }

    public static String generateFiveZipCode() {
        Faker faker = new Faker();
        return faker.numerify("#####");
    }

    public static String generateSixZipCode() {
        Faker faker = new Faker();
        return faker.numerify("######");
    }
    public static String generateFirstName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    public static String generateLastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }
    public static String generateEmail(){
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }
    public static String generatePassword(){
        Faker faker = new Faker();
        return faker.internet().password();
    }
    public static String generatePasswordLessFour(){
        Faker faker = new Faker();
        return faker.internet().password(1, 4);
    }
}
