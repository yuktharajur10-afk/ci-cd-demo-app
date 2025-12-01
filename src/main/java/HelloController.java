package com.example;

public class HelloController {
    public String sayHello() {
        return "Hello, CI/CD!";
    }

    public static void main(String[] args) {
        System.out.println(new HelloController().sayHello());
    }
}
