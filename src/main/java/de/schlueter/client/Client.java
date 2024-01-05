package de.schlueter.client;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    String url;

    public Client(String url, int port, String route) {
        StringBuilder urlsb = new StringBuilder();
        urlsb.append(url);
        urlsb.append(":");
        urlsb.append(port);
        urlsb.append(route);
        this.url = urlsb.toString();
    }

    public void request(int firstNumber, int secondNumber) {
        StringBuilder urlsb = new StringBuilder();
        urlsb.append(url);
        urlsb.append("?firstNumber=");
        urlsb.append(firstNumber);
        urlsb.append("&secondNumber=");
        urlsb.append(secondNumber);

        try {
            URL url = new URL(urlsb.toString());

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
