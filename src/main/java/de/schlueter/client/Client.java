package de.schlueter.client;

import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public void request() {
        URL url;
        HttpURLConnection con;
        try {
            url = new URL("http://localhost:8080/");
            con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            System.out.println("Status: " + status);

            String response = con.getResponseMessage();
            System.out.println("Response: " + response);

            // Close connection
            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
