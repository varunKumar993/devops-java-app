package com.devops;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static String getMessage() {
        return "DevOps CI/CD pipeline is working - webhook test!";
    }

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080),
                0
        );

        server.createContext("/", App::handleRoot);
        server.createContext("/health", App::handleHealth);

        server.start();

        System.out.println("Application started on port 8080");
    }

    private static void handleRoot(HttpExchange exchange) throws IOException {

        String response = getMessage();

        exchange.sendResponseHeaders(200, response.getBytes().length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(response.getBytes());
        }
    }

    private static void handleHealth(HttpExchange exchange) throws IOException {

        String response = "UP";

        exchange.sendResponseHeaders(200, response.getBytes().length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(response.getBytes());
        }
    }
}