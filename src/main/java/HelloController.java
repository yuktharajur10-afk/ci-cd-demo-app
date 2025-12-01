package com.example;

public class HelloController {

    public String sayHello() {
        return "Hello, CI/CD!";
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new HelloController().sayHello());

        // Keep the app alive indefinitely
        while (true) {
            Thread.sleep(1000); // sleep 1 second
        }
    }
}
