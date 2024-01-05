package de.schlueter.client;

import java.io.InputStream;
import java.net.*;

public class Client {
    public void request() {
        try {
            URL url = new URL("http://localhost:8080/");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream in = con.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
