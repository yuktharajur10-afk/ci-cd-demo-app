package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class HelloController {

    public String sayHello() {
        return "Hello, CI/CD!";
    }

    public static void main(String[] args) throws IOException {
        HelloController controller = new HelloController();

        // Get the port from environment variable (Render sets PORT)
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        // Start a simple HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            String response = controller.sayHello();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        server.start();
        System.out.println("Server running on port " + port);

        // Keep the app alive (Render needs a running process)
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
