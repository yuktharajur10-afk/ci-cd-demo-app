package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    public void testSayHello() {
        HelloController hc = new HelloController();
        assertEquals("Hello, CI/CD!", hc.sayHello());
    }
}
