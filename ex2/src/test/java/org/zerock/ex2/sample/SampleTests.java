package org.zerock.ex2.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SampleTests {
    @Autowired
    private Restaurant restaurant;


    @Test
    public void test() {
        restaurant = new Restaurant();
        System.out.println("================");
        System.out.println(restaurant);
        System.out.println("================");
    }

    public void test2() {
        Member member1 = new Member();

    }
}