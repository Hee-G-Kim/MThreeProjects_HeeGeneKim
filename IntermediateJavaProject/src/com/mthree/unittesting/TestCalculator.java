package com.mthree.unittesting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(value = Lifecycle.PER_CLASS)

public class TestCalculator {
         private Calculator calc;
         
         @BeforeAll
         public void setUp() {
                  System.out.println("Inside setup method");
                  calc = new Calculator();
         }
         @AfterAll
         public void tearDown() {
                  System.out.println("Inside tearDown method");
                  calc= null;
         }
         @Test
         public void testAdd() {
                  System.out.println("Insid; test method");
                  int actualResult = calc.add(0,0);
                  int expectedResult = 0;
                  assertEquals(expectedResult,actualResult);
         }
         
}
