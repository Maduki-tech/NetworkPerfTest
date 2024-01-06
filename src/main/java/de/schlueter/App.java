package de.schlueter;

import de.schlueter.client.Client;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        int requests = args[0].isEmpty() ? 1 : Integer.parseInt(args[0]);
        SpringApplication.run(App.class, args);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            add(requests);
            multiply(requests);
            parse(requests);
        }
        long finishTime = System.currentTimeMillis();
        long timeElapsed = finishTime - startTime;

        System.out.println("Time elapsed (total): " + timeElapsed + "ms");

        System.exit(0);
    }

    private static void add(int requests) {
        String url = "http://localhost";
        int port = 8080;
        String route = "/add";
        Client client = new Client(url, port, route);

        // Request start here
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < requests; i++) {
            Random rand = new Random();
            int firstNumber = rand.nextInt(100000);
            int secondNumber = rand.nextInt(100000);
            client.request(firstNumber, secondNumber);
        }
        long finishTime = System.currentTimeMillis();
        long timeElapsed = finishTime - startTime;
        System.out.println("Time elapsed (add): " + timeElapsed + "ms");
    }

    private static void multiply(int requests) {
        String url = "http://localhost";
        int port = 8080;
        String route = "/multiply";
        Client client = new Client(url, port, route);

        // Request start here
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < requests; i++) {
            Random rand = new Random();
            int firstNumber = rand.nextInt(100);
            int secondNumber = rand.nextInt(100);
            client.request(firstNumber, secondNumber);
        }
        long finishTime = System.currentTimeMillis();
        long timeElapsed = finishTime - startTime;
        System.out.println("Time elapsed (multiply): " + timeElapsed + "ms");
    }

    private static void parse(int requests) {
        String url = "http://localhost";
        int port = 8080;
        String route = "/parse";
        Client client = new Client(url, port, route);

        // Request start here
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < requests; i++) {
            String input = "Hello World!";
            client.request(input);
        }
        long finishTime = System.currentTimeMillis();
        long timeElapsed = finishTime - startTime;
        System.out.println("Time elapsed (parse): " + timeElapsed + "ms");
    }
}
