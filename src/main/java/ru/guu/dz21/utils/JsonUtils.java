package ru.guu.dz21.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonUtils {
    public static String getCryptoDataFromApi(String apiUrl) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            if (connection.getResponseCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                rd.close();
            } else {
                System.err.println("Error: HTTP response code " + connection.getResponseCode());
            }
        } catch (IOException e) {
            System.err.println("Error during API request: " + e.getMessage());
        }
        return result.length() > 0 ? result.toString() : null;
    }
}
