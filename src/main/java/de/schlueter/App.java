package de.schlueter;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.schlueter.client.Client;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        int requests = args[0].isEmpty() ? 1 : Integer.parseInt(args[0]);
        SpringApplication.run(App.class, args);
        String url = "http://localhost";
        int port = 8080;
        String route = "/add";
        Client client = new Client(url, port, route);

        // Request start here
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < requests; i++){
            Random rand = new Random();
            int firstNumber = rand.nextInt(100);
            int secondNumber = rand.nextInt(100);
            client.request(firstNumber, secondNumber);
        }
        long finishTime = System.currentTimeMillis();
        long timeElapsed = finishTime - startTime;
        System.out.println("Time elapsed: " + timeElapsed + "ms");

        System.exit(0);
    }
}
