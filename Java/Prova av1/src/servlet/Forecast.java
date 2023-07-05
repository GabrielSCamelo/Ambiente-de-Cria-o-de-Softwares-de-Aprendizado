package servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Forecast {

    private static final String API_KEY = "776a7156-b0b4-40fa-a746-bf77c2bc985a";

    public static Map<String, Object> getForecast(double latitude, double longitude) throws Exception {
        String url = "https://api.meteum.ai/v1/forecast?lat=" + URLEncoder.encode(String.valueOf(latitude), StandardCharsets.UTF_8)
            + "&lon=" + URLEncoder.encode(String.valueOf(longitude), StandardCharsets.UTF_8);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Meteum-API-Key", API_KEY);

        int responseCode = con.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to get forecast. Response code: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Map<String, Object> forecast = new HashMap<>();
        forecast.put("latitude", latitude);
        forecast.put("longitude", longitude);
        forecast.put("data", response.toString());

        return forecast;
    }
}