package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class HelloController {

    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            String htmlResponse = "<!DOCTYPE html>" +
                    "<html lang='en'>" +
                    "<head>" +
                    "  <meta charset='UTF-8'>" +
                    "  <meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "  <title>My CI/CD Project</title>" +
                    "  <link href='https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap' rel='stylesheet'>" +
                    "  <style>" +
                    "    body { font-family: 'Roboto', sans-serif; margin:0; padding:0; background:#f0f2f5; color:#333; }" +
                    "    header { background:#ff4757; color:white; padding:40px 20px; text-align:center; }" +
                    "    header h1 { margin:0; font-size:2.5em; }" +
                    "    section { padding:40px 20px; text-align:center; }" +
                    "    .btn { display:inline-block; margin:10px; padding:10px 20px; background:#1e90ff; color:white; text-decoration:none; border-radius:5px; font-weight:bold; }" +
                    "    footer { background:#333; color:white; padding:20px; text-align:center; }" +
                    "  </style>" +
                    "</head>" +
                    "<body>" +
                    "  <header>" +
                    "    <h1>Hello, CI/CD!</h1>" +
                    "    <p>Deployed via GitHub Actions & Render.com</p>" +
                    "  </header>" +
                    "  <section>" +
                    "    <h2>Check out my project links</h2>" +
                    "    <a class='btn' href='https://github.com/yourusername/your-repo' target='_blank'>GitHub Repo</a>" +
                    "    <a class='btn' href='https://your-app-name.onrender.com' target='_blank'>Live App</a>" +
                    "  </section>" +
                    "  <section>" +
                    "    <h2>About the Project</h2>" +
                    "    <p>This project demonstrates a CI/CD pipeline with automated deployment on Render.com. " +
                    "It uses a minimal Java HTTP server serving a modern HTML page.</p>" +
                    "  </section>" +
                    "  <footer>" +
                    "    &copy; 2025 My Portfolio Project" +
                    "  </footer>" +
                    "</body>" +
                    "</html>";

            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, htmlResponse.getBytes().length);
            exchange.getResponseBody().write(htmlResponse.getBytes());
            exchange.close();
        });

        server.start();
        System.out.println("Server running on port " + port);
    }
}
