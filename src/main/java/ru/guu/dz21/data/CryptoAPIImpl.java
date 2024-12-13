package ru.guu.dz21.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import ru.guu.dz21.domain.Crypto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class CryptoAPIImpl implements CryptoAPI {
    private static final String API_URL = "https://api.coincap.io/v2/assets";

    @Override
    public List<Crypto> fetchCryptoRates() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(API_URL).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Failed to fetch data: HTTP " + responseCode);
            }
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder jsonResponse = new StringBuilder();
            while (scanner.hasNext()) {
                jsonResponse.append(scanner.nextLine());
            }
            scanner.close();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse.toString(), JsonObject.class);
            String data = jsonObject.getAsJsonArray("data").toString();
            System.out.println("Data successfully uploaded " + responseCode);

            return gson.fromJson(data, new TypeToken<List<Crypto>>() {
            }.getType());
        } catch (IOException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
        return List.of();
    }
}
