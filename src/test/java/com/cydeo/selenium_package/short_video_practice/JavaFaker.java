package com.cydeo.selenium_package.short_video_practice;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker {
    @Test
    public void practice(){
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());// first method chained is for category, second method chained specify category inside main category.
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().state() = " + faker.address().state());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.number().numberBetween(10000,19000) = " + faker.number().numberBetween(10000, 19000));
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.letterify(\"????\") = " + faker.letterify("????"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
    }
}
